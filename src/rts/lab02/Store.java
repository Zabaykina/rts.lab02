package rts.lab02;

import javax.swing.JTextArea;

public class Store {

	private JTextArea textArea;
	private int balance = 0;
	private final int capacity = 50;

	public Store(JTextArea textArea) {
		super();
		this.textArea = textArea;
		textArea.append("Емкость склада " + capacity + " единиц товара. ");
		textArea.append("На складе " + balance + " единиц товара. \n");
	}

	public synchronized void put(int quantity) {
		int available = capacity - balance;
		if (available >= quantity) {
			balance += quantity;
			textArea.append("Добавлено " + quantity + " единиц товара. ");
			textArea.append("На складе " + balance + " единиц товара. \n");
		} else {
			textArea.append("Добавить " + quantity
					+ " единиц товара нельзя. ");
			textArea.append("На складе " + balance + " единиц товара. \n");
		}
	}

	public synchronized void get(int quantity) {
		if (balance >= quantity) {
			balance -= quantity;
			textArea.append("Выдано " + quantity + " единиц товара. ");
			textArea.append("На складе " + balance + " единиц товара. \n");
		} else {
			textArea.append("Выдать " + quantity
					+ " единиц товара со склада нельзя. ");
			textArea.append("На складе " + balance + " единиц товара. \n");
		}
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getCapacity() {
		return capacity;
	}

}
