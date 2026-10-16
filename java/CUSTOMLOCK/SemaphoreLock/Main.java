
import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String[] args) {
		SharedResource s1= new SharedResource();
		SharedResource s2= new SharedResource();
		Semaphore lock = new Semaphore(2);
  
		Thread th1= new Thread(() -> { 
			s1.producer(lock);
		});

		Thread th2= new Thread(() -> { 
			s2.producer(lock);
		});

		Thread th3= new Thread(() -> { 
			s1.producer(lock);
		});

		Thread th4= new Thread(() -> { 
			s2.producer(lock);
		});

		Thread th5= new Thread(() -> { 
			s2.producer(lock);
		});

		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();


	}
}
