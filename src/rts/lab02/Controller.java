package rts.lab02;

import javax.swing.JTextArea;

public class Controller {

	private Store store;
	private Thread consumer;
	private Thread supplier;

	public Controller(JTextArea textArea) {
		super();
		store = new Store(textArea);	
	}

	/**
	 * Создание потоков поставщика и потребителя
	 */
	public void start() {
		consumer = new Thread(new Consumer(store));
		supplier = new Thread(new Supplier(store));
		
		supplier.start();
		consumer.start();
	}

	/**
	 * Прерывание потков поставщика и потребителя
	 */
	public void stop() {
		supplier.interrupt();
		consumer.interrupt();
	}

}
