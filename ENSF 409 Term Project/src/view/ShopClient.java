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
		socketOut.println("SEARCH" + "\n" + name);  //this string gets parsed in Manager to call the correct
		                                            //method
		socketOut.write("SEARCH_ITEM\n");
		socketOut.write(name);
	}
	
	protected String passResult(String result) {
		return result;
	}
}
