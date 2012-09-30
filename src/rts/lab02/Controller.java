package rts.lab02;

import java.util.Random;

import javax.swing.JTextArea;

public class Controller {

	private Store store;
	private Thread consumer;
	private Thread supplier;

	public Controller(JTextArea textArea) {
		super();
		store = new Store(textArea);	
	}

	public void start() {
		consumer = new Thread(new Consumer(store));
		supplier = new Thread(new Supplier(store));
		
		supplier.start();
		consumer.start();
	}

	public void stop() {
		supplier.interrupt();
		consumer.interrupt();
	}

}
