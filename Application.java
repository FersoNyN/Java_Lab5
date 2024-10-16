public class Application {
    public static void main(String[] args) {
        Fifo fifo = new Fifo();
        Producer producer1 = new Producer(fifo, "first", 500);
        Producer producer2 = new Producer(fifo, "second", 500);
        Consumer consumer1 = new Consumer(fifo, "consumer1", 1000);

        producer1.start();
        // this extra if delay is needed
        /* try {
            Thread.sleep(500); // Wait for 500 milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
        }
        */
        producer2.start();
        consumer1.start();
    }
}
