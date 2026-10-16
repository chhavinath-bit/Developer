
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	public static void main(String[] args) {
		SharedResource s1= new SharedResource();
		SharedResource s2= new SharedResource();

        ReentrantLock l= new ReentrantLock();
		Thread th1= new Thread(() -> { 
			s1.producer();
		});

		Thread th2= new Thread(() -> { 
			s2.producer();
		});

		th1.start();
		th2.start();


	}
}
