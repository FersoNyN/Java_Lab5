import java.util.ArrayList;

public class Fifo {
    private final ArrayList<String> queue;   // The underlying queue to store strings
    private final int capacity;              // Maximum size of the queue

    // Constructor initializes the queue and sets the capacity to 10
    public Fifo() {
        this.queue = new ArrayList<>();
        this.capacity = 10;
    }

    // Synchronized put method to add strings to the queue
    public synchronized void put(String item) throws InterruptedException {
        // Wait while the queue is full
        while (queue.size() == capacity) {
            wait();  // Caller waits until there is space in the queue
        }

        // Add the item to the queue
        queue.add(item);
        
        // Notify other threads that may be waiting to get items from the queue
        notifyAll();
    }

    // Synchronized get method to remove and return the oldest string from the queue
    public synchronized String get() throws InterruptedException {
        // Wait while the queue is empty
        while (queue.isEmpty()) {
            wait();  // Caller waits until there's something to retrieve
        }

        // Remove and return the first item from the queue
        String item = queue.remove(0);
        
        // Notify other threads that may be waiting to put items into the queue
        notifyAll();
        
        return item;
    }
}
