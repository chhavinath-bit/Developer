import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
	
	public static void main(String[] args) {
		ThreadPoolExecutor tp= new ThreadPoolExecutor(2,10, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new CustomThreadFactory(), new CustomRejectHandler());


		for(int i=0; i<9; i++){
			tp.submit(()->{
				try{
                  Thread.sleep(8000);
				}catch(Exception e){

				}
               System.out.println("Task processed by: "+ Thread.currentThread().getName());
			});
		}

		tp.shutdown();

	}
}
class CustomThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r){
		Thread th= new Thread(r);
		th.setPriority(Thread.NORM_PRIORITY);
		th.setDaemon(false);
      
		return th;
	}

}

class CustomRejectHandler implements RejectedExecutionHandler{

	@Override 
	public void rejectedExecution(Runnable r, ThreadPoolExecutor e){
		System.out.println("Task rejected: "+r );
	}
}
