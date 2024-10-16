public class Consumer extends Thread {
    private Fifo fifo;   // Shared FIFO queue
    private String id;   // Identifier for the Consumer
    private int delay;   // Delay in milliseconds between reads

    // Constructor to initialize the FIFO, identifier, and delay
    public Consumer(Fifo fifo, String id, int delay) {
        this.fifo = fifo;
        this.id = id;
        this.delay = delay;
    }

    // Override the run() method to define the thread's behavior
    @Override
    public void run() {
        try {
            while (true) {
                // Read a string from the FIFO
                String message = fifo.get();

                // Get the current time in milliseconds at the moment of consumption
                long currentTimeMillis = System.currentTimeMillis();
                String consumedTime = String.format("%05d", currentTimeMillis % 100000);

                // Print the "consumed" message with the required format
                System.out.println("consumed " + id + " " + message + " " + consumedTime);

                // Sleep for the specified delay (N milliseconds)
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            System.out.println(id + " consumer thread was interrupted.");
        }
    }
}
