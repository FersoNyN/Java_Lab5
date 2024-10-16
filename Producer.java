public class Producer extends Thread {
    private Fifo fifo;   // Shared FIFO queue
    private String text; // Text to produce
    private int waitTime; // Wait time in milliseconds

    public Producer(Fifo fifo, String text, int waitTime) {
        this.fifo = fifo;
        this.text = text;
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        int messageCount = 0;
        try {
            while (messageCount < 3) { // Limiting the number of messages for testing
                // Get the current time in milliseconds
                long currentTimeMillis = System.currentTimeMillis();
                String message = text + " " + messageCount;

                // Put the message in the FIFO
                fifo.put(message);

                // Print the produced message
                System.out.println("produced " + message + " " + (currentTimeMillis % 100000));

                // Increment the message count
                messageCount++;

                // Wait for the specified time before producing the next message
                Thread.sleep(waitTime);
            }
        } catch (InterruptedException e) {
            System.out.println("Producer was interrupted.");
        }
    }
}
