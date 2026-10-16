
import java.util.concurrent.locks.ReadWriteLock;


public class SharedResource {
	boolean isAvailable= false;

	public void producer(ReadWriteLock l){
        try{
           l.readLock().lock();
		   System.out.println("Read lock acquired by: "+ Thread.currentThread().getName());
		   Thread.sleep(8000);
		}catch(Exception e){

		}
		finally{
			l.readLock().unlock();
			System.out.println("Read lock unlocked by: "+ Thread.currentThread().getName());
		}
	}

	public void consumer(ReadWriteLock l){
		try {
			l.writeLock().lock();
			System.out.println("Write lock acquired by: "+ Thread.currentThread().getName());
			Thread.sleep(8000);
			
		} catch (Exception e) {
		}
		finally{
			l.writeLock().unlock();
			System.out.println("Write lock release by: "+ Thread.currentThread().getName());

		}
	}
}
