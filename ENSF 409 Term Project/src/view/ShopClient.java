package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ShopClient {
	private PrintWriter socketOut;
	private BufferedReader socketIn;
	private Socket userSocket;
	
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
		
	}
	
	protected void requestSearch(String name) {
		
	}
}
