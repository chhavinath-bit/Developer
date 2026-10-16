import java.util.ArrayDeque;
import java.util.Queue;

public class Buffer {
    private final Queue<Integer> q = new ArrayDeque<>();
    private final int capacity = 3;

    public synchronized void addIntoBuffer(int x)
            throws InterruptedException {

        while (q.size() == capacity) {
			System.out.println("Producer full, waiting for consumer ");
            wait();
        }

        q.add(x);
        System.out.println(
            Thread.currentThread().getName()
            + " produced: " + x + " | Buffer: " + q
        );

        notifyAll();
    }

    public synchronized int removeFromBuffer()
            throws InterruptedException {

        while (q.isEmpty()) {
			System.out.println("Consumer empty, waiting for Producer");
            wait();
        }

        int x = q.remove();
        System.out.println(
            Thread.currentThread().getName()
            + " consumed: " + x + " | Buffer: " + q
        );

        notifyAll();
        return x;
    }
}
