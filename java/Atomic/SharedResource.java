
import java.util.concurrent.atomic.AtomicInteger;



public class SharedResource {

	AtomicInteger Counter = new AtomicInteger(0);

	public void increment(){
		try{
			Thread.sleep(100);
		    Counter.incrementAndGet();
		}catch(Exception e){

		}
		

	}

	public int get(){
		return Counter.get();
	}

}
