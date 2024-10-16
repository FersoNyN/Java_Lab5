public class Application {
    public static void main(String[] args) {
        Fifo fifo = new Fifo();
        Producer producer1 = new Producer(fifo, "first", 500);
        Producer producer2 = new Producer(fifo, "second", 500);
        Consumer consumer1 = new Consumer(fifo, "consumer1", 1000);

        producer1.start();
        producer2.start();
        consumer1.start();
    }
}
