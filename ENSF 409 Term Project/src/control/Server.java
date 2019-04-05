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

public class Server {
	private ServerSocket serverSocket;
	private Socket aSocket;
	private ExecutorService pool;
	private Inventory inv;
	private ArrayList<Supplier> sup;
	public Server(int portNum, Inventory i,ArrayList<Supplier> s) {
		inv = i;
		sup = s;
		try {
			serverSocket = new ServerSocket(portNum);
			pool = Executors.newCachedThreadPool();
		}catch(IOException e) {
			
		}
	}
	
	public void commuicateWtihClient() throws IOException{
		try {
			while(true) {
				//System.out.println("Trying to connect");
				//System.out.println(serverSocket.getLocalPort());
				if(serverSocket.getLocalPort() == 8099) {
					//System.out.println("Waiting for leet user");
					ShopManager sman = new ShopManager(serverSocket.accept(),inv,sup);
					pool.execute(sman.runManager());
				}else {
					new CustomerManager(serverSocket.accept(),inv);
				}
				System.out.println("Connected to client");


				//pool.execute();
			}
		}catch(Exception e) {
			e.printStackTrace();
			pool.shutdown();
		}
	}
	
	public static void main(String[] args) throws IOException{
		Inventory i = null;
		i = new Inventory("items.txt");
		ArrayList<Supplier> s = readSupplier("suppliers.txt");
		Server server = new Server(8099,i,s);
		//Server server2 = new Server(3000,i,s);
		System.out.println("Server is now running");
		server.commuicateWtihClient();
		//server2.commuicateWtihClient();
		
	}
	
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
}
