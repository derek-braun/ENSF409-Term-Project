package control;

import java.io.IOException;
import java.util.ArrayList;

import model.Inventory;
import model.Supplier;

public class ShopServer extends Server{
	protected ArrayList<Supplier> sup;
	public ShopServer(int portNum, Inventory i, ArrayList<Supplier> s) {
		super(portNum, i);
		sup = s;
	}
	
	@Override
	public void commuicateWtihClient() throws IOException{
		try {
			while(true) {
				pool.execute(new ShopManager(serverSocket.accept(),inv,sup).runManager());
				System.out.println("Connected to ShopOwner");
			}
		}catch(Exception e) {
			e.printStackTrace();
			pool.shutdown();
		}
	}

}
