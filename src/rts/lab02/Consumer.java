package rts.lab02;

import java.util.Random;

public class Consumer implements Runnable {

	private Store store;
	private Random random = new Random();
	
	public Consumer(Store store) {
		super();
		this.store = store;
	}

	@Override
	public void run() {
		try {
			while (true) {
				store.get(random.nextInt(10));
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
