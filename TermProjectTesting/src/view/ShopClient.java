package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ShopClient {
	protected PrintWriter socketOut;
	protected BufferedReader socketIn;
	protected Socket userSocket;
	protected String operation;
	
	public ShopClient(String serverName, int portNumber) {
		try {
			userSocket = new Socket(serverName, portNumber);
			socketIn = new BufferedReader(new InputStreamReader(userSocket.getInputStream()));
			socketOut = new PrintWriter((userSocket.getOutputStream()), true);
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}
	
	protected void shopSession() {
		while (true) {
			try {
				socketIn.close();
				socketOut.close();
			} catch (IOException e) {
				System.out.println("Closing error: " + e.getMessage());
			}
		}
	}
	
	protected void requestSearch(String name) {
		operation = "SEARCH_ITEM";
		socketOut.write("SEARCH_ITEM " + name + "\n");
		socketOut.flush();
	}
	
	protected void requestListAll() {
		operation = "PRINT_INVENTORY";
		socketOut.write("PRINT_INVENTORY\n");
		socketOut.flush();
	}
	
	protected String passResult(String result) {
		return result;
	}
}
