
public class Main {
	
	public static void main(String[] args) {
		SharedResource s= new SharedResource();
        
		Thread Th1= new Thread(()-> {
             for(int i=0; i< 200; i++){
				s.increment();
			 }
		});
		
		Thread Th2= new Thread(()-> {
             for(int i=0; i< 200; i++){
				s.increment();
			 }
		});
		
		Th1.start();
		Th2.start();

		try {
			Th1.join();
			Th2.join();
		} catch (Exception e) {
		}

		System.out.println("counter after ops: "+ s.get());
	}
}
