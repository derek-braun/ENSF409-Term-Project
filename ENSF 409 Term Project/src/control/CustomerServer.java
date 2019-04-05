package control;

import java.io.IOException;

import model.Inventory;

public class CustomerServer extends Server {

	public CustomerServer(int portNum, Inventory i) {
		super(portNum, i);
	}

	@Override
	public void commuicateWtihClient() throws IOException{
		try {
			while(true) {
				pool.execute(new CustomerManager(serverSocket.accept(),inv).runManager());
				System.out.println("Connected to customer");
			}
		}catch(Exception e) {
			e.printStackTrace();
			pool.shutdown();
		}
	}
}
