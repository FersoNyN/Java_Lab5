import java.util.concurrent.*;
import java.util.Date;

public class Producer {
    private String text;       // The text part of the message
    private int messageCount;  // Tracks the number of messages

    // Constructor to initialize the text
    public Producer(String text) {
        this.text = text;
        this.messageCount = 0;
    }

    // The go() method which prints a message every second
    public void go() {
        // Create a ScheduledExecutorService for periodic execution
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        // Schedule a task to run every 1 second
        executor.scheduleAtFixedRate(() -> {
            // Get the current time in milliseconds
            long currentTimeMillis = System.currentTimeMillis();
            
            // Extract the last 5 digits of the system time
            String time = String.format("%05d", currentTimeMillis % 100000);
            
            // Print the message with text, message count, and time
            System.out.println(text + " " + messageCount + " " + time);
            
            // Increment the message count for the next message
            messageCount++;
        }, 0, 1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        // Example usage of Producer
        Producer producer = new Producer("demo");
        producer.go();
    }
}
