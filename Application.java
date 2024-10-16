public class Application {
    public static void main(String[] args) {
        // Create two Producer threads with different message texts
        Producer producer1 = new Producer("first");
        Producer producer2 = new Producer("second");

        // Start the first Producer thread
        producer1.start();

        try {
            // Sleep for 0.5 seconds before starting the second thread
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Start the second Producer thread
        producer2.start();
    }
}
