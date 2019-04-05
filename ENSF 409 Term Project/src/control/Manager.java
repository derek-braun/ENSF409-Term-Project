package control;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import model.*;

abstract class Manager implements Runnable {

	protected Order order;
	protected Inventory inventory;
	protected Socket aSocket;
	protected BufferedReader socketIn;
	protected PrintWriter socketOut;
	Manager(Socket client, Inventory inv){
		aSocket = client;
		inventory = inv;
		try {
			socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOut = new PrintWriter(aSocket.getOutputStream());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	abstract Runnable runManager();
	
	public Item search(String name) {
		return inventory.search(name);
	}
	
	public Item search(int ID) {
		return inventory.search(ID);
	}
	
	public String seeOrder() {
		return order.toString();
	}
	
	public void sendString(String message) {
		socketOut.println(message);
		socketOut.flush();
	}
	
	public void run() {
		runManager();
	}

}
