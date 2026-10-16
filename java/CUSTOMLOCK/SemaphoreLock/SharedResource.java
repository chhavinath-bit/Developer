import java.util.concurrent.Semaphore;

public class SharedResource {
	boolean isAvailable= false;
	

	public void producer(Semaphore lock){
		try {
			lock.acquire();
			System.out.println("Lock acquired by: "+ Thread.currentThread().getName());
			isAvailable = true;
			Thread.sleep(8000);
		} catch (Exception e) {
		}
		finally{
			lock.release();
			System.out.println("Lock release by: "+ Thread.currentThread().getName());
		}
	}

	public void consumer(){
		
	}
}
