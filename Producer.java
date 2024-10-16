import java.util.concurrent.TimeUnit;

public class Producer extends Thread {
    private String text;       // The text part of the message
    private int messageCount;  // Tracks the number of messages

    // Constructor to initialize the text
    public Producer(String text) {
        this.text = text;
        this.messageCount = 0;
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

                // Print the message with text, message count, and time
                System.out.println(text + " " + messageCount + " " + time);

                // Increment the message count for the next message
                messageCount++;

                // Sleep for 1 second before printing the next message
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            System.out.println(text + " thread was interrupted.");
        }
    }
}
