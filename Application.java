public class Application {
    public static void main(String[] args) {
        // Create a shared FIFO object for the producer and consumer
        Fifo fifo = new Fifo();

        // Create two Producer threads that will produce messages into the FIFO
        Producer producer1 = new Producer("first", fifo);
        Producer producer2 = new Producer("second", fifo);

        // Create a Consumer thread that will consume messages from the FIFO
        Consumer consumer = new Consumer(fifo, "consumer1", 500); // Consumer waits 500 milliseconds between reads

        // Start the producer and consumer threads
        producer1.start();
        producer2.start();
        consumer.start();
    }
}
