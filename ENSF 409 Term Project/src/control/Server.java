package control;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.*;

abstract class Server implements Runnable{
	protected ServerSocket serverSocket;
	protected Socket aSocket;
	protected ExecutorService pool;
	protected Inventory inv;

	public Server(int portNum, Inventory i) {
		inv = i;
		try {
			serverSocket = new ServerSocket(portNum);
			pool = Executors.newCachedThreadPool();
		}catch(IOException e) {
			
		}
	}
	
	abstract public void commuicateWtihClient() throws IOException;
		
	public static ArrayList<Supplier> readSupplier(String input){
		//REPLACE STRING FOR TESTING
		String fileName = input;
		FileReader fr;
		BufferedReader br;
		ArrayList<Supplier> theArray = new ArrayList<Supplier>();
		String[] components;
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String s;
			while((s = br.readLine()) != null) {
				components = s.split(";");
				Supplier a = new Supplier(Integer.parseInt(components[0]),components[1],components[2],components[3]);
				theArray.add(a);
			}
			fr.close();
			br.close();
		}catch(Exception e) {
			System.err.println(input + " not found");
		}
		return theArray;
	}
	
	public void run(){
		try {
			commuicateWtihClient();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) throws IOException{
		Inventory i = null;
		i = new Inventory("items.txt");
		ArrayList<Supplier> s = readSupplier("suppliers.txt");
		//MultiTreaded server
		ShopServer server = new ShopServer(8099,i,s);
		Thread t = new Thread(server);
		CustomerServer server2 = new CustomerServer(1337,i);
		Thread t2 = new Thread(server2);
		t.start();
		t2.start();
		System.out.println("Servers are now running");
	}
	
}
