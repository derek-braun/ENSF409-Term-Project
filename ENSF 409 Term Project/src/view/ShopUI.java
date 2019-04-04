package view;
import java.awt.Button;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ShopUI extends JFrame{
	private ManagerClient managerClient;
	
	public ShopUI(String serverName, int portNumber) {
		managerClient = new ManagerClient(serverName, portNumber);
		
	}
	
	private void searchItem(String name) {
		managerClient.requestSearch(name);
	}
	
	private void placeOrder(String id) {
		managerClient.requestPlaceOrder(id);
	}
	
	private void createNewSuppler() {
		managerClient.createNewSupplier();
	}
	
	private void createNewItem() {
		managerClient.createNewItem();
	}
	
	private void changeItemPrice() {
		managerClient.changeItemPrice();
	}
	
	private void viewOrder() {
		
	}
	
	private void addListener(ActionListener al, Button b) {
		
	}
}
