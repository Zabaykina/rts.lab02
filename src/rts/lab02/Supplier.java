package rts.lab02;

import java.util.Random;

public class Supplier implements Runnable {

	private Store store;
	private Random random = new Random();


	public Supplier(Store store) {
		super();
		this.store = store;
	}

	@Override
	public void run() {
		try {
			while (true) {
				store.put(random.nextInt(10));
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

	}

}
