package view;
import java.awt.Button;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ShopUI extends JFrame{
	private ManagerClient managerClient;
	
	public ShopUI(String serverName, int portNumber) {
		managerClient = new ManagerClient(serverName, portNumber);
		managerClient.shopSession();
	}
	
	private void searchItem(String name) {
		managerClient.requestSearch(name);
	}
	
	private void placeOrder(String id) {
		managerClient.requestPlaceOrder(id);
	}
	
	private void createNewSuppler(String id, String name, String address, String contact) {
		managerClient.createNewSupplier(id, name, address, contact);
	}
	
	private void createNewItem(String id, String name, String quantity, String price, String supplier) {
		managerClient.createNewItem(id, name, quantity, price, supplier);
	}
	
	private void changeItemPrice(String price) {
		managerClient.changeItemPrice(price);
	}
	
	private void viewOrder() {
		
	}
	
	private void addListener(ActionListener al, Button b) {
		
	}
}
