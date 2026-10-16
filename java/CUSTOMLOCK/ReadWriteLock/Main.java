
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class Main {
	public static void main(String[] args) {
		SharedResource s= new SharedResource();

		ReadWriteLock r= new ReentrantReadWriteLock();

		Thread Th1= new Thread(()-> {
			s.producer(r);
		});

		Thread Th2 = new Thread(()-> {
			s.producer(r);
		});

	
        SharedResource s1= new SharedResource();


		Thread Th3= new Thread(()->{
             s1.consumer(r);
		});


        	Th1.start();
		Th2.start();
      
	  Th3.start();


	}
}
