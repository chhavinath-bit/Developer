public class main {
	
	public static void main(String[] args) {
		Buffer b = new Buffer();

		Thread producer = new Thread(() -> {
			try {
				for (int i = 1; i <= 10; i++) {
					b.addIntoBuffer(i);
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}, "Producer");

		Thread consumer = new Thread(() -> {
			try {
				for (int i = 1; i <= 10; i++) {
					b.removeFromBuffer(); 
					Thread.sleep(250);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}, "Consumer");

		producer.start();
		consumer.start();
	}
}
