package view;
import java.awt.Button;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CustomerUI extends JFrame{
	private CustomerClient customerClient;
	
	public CustomerUI(String serverName, int portNumber) {
		customerClient = new CustomerClient(serverName, portNumber);
	}
	
	private void searchItem(String name) {
		customerClient.requestSearch(name);
	}
	
	private void placeOrder(String id) {
		customerClient.requestPlaceOrder(id);
	}
	
	private void addToCart() {

	}
	
	private void removeFromCart() {
		
	}
	
	private void viewOrder() {
		
	}
	
	private void addListener(ActionListener al, Button b) {
		
	}
}
