import java.util.concurrent.TimeUnit;

public class Producer extends Thread {
    private String text;       // The text part of the message
    private int messageCount;  // Tracks the number of messages
    private Fifo fifo;         // Shared FIFO queue

    // Constructor to initialize the text and the shared Fifo object
    public Producer(String text, Fifo fifo) {
        this.text = text;
        this.messageCount = 0;
        this.fifo = fifo;
    }

    // Override the run() method to define the thread's behavior
    @Override
    public void run() {
        try {
            while (true) {
                // Get the current time in milliseconds
                long currentTimeMillis = System.currentTimeMillis();

                // Extract the last 5 digits of the system time
                String time = String.format("%05d", currentTimeMillis % 100000);

                // Create the message to insert into the Fifo
                String message = text + " " + messageCount;

                // Insert the message into the Fifo
                fifo.put(message);

                // Print the "produced" message with the required format
                System.out.println("produced " + message + " " + time);

                // Increment the message count for the next message
                messageCount++;

                // Sleep for 1 second before producing the next message
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            System.out.println(text + " thread was interrupted.");
        }
    }
}
