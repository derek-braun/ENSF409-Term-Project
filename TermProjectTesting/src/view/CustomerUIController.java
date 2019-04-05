package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractButton;

public class CustomerUIController {
	protected CustomerClient customerClient;
	protected CustomerUI customerUI;
	
	public CustomerUIController(String serverName, int portNumber) {
		customerClient = new CustomerClient(serverName, portNumber);
		customerUI = new CustomerUI();
		customerUI.addListener(new OperationListener(), customerUI.searchButton);
		customerUI.addListener(new OperationListener(), customerUI.listAllButton);
		customerUI.addListener(new OperationListener(), customerUI.addItem);
		customerUI.addListener(new OperationListener(), customerUI.removeItem);
		customerUI.addListener(new OperationListener(), customerUI.order);
	}
	
	public static void main(String[] args) {
		CustomerUIController control = new CustomerUIController("localhost", 8099);
		control.shopSession();
	}
	
	public void shopSession() {
		while(true) {
			String input = null;
			String[] itemFormat = null;
			System.out.println("Running Client");
			try {
				input = customerClient.socketIn.readLine();
				System.out.println(input);
				switch(customerClient.operation) {
				case "SEARCH_ITEM":
					customerUI.itemList.clear();
					customerUI.itemList.addElement(input);
					break;
				case "PRINT_INVENTORY":
					customerUI.itemList.clear();
					itemFormat = input.split("%");
					for(int i = 0; i < itemFormat.length; i++) {
						customerUI.itemList.addElement(itemFormat[i]);
					}
					break;
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
//		try {
//			managerClient.socketIn.close();
//			managerClient.socketOut.close();
//		} catch (IOException e) {
//			System.out.println("Closing error: " + e.getMessage());
//		}
	}
	
	class OperationListener implements ActionListener{
		protected String[] inputText;

		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonLabel = ((AbstractButton) e.getSource()).getText();
			System.out.println(buttonLabel);
			inputText = new String[10];
			
			switch(buttonLabel) {
			case "List Items":
				customerClient.requestListAll();
				break;
			case "Search":
				new SearchWindow(customerClient);
				break;
			case "Add":
				customerUI.cartList.addElement(customerUI.list.getSelectedValue());
				break;
			case "Remove":
				customerUI.cartList.removeElement(customerUI.list.getSelectedValue());
				break;
			case "Order":
				customerUI.cartList.clear();
				break;
			default :
				System.out.println("Invalid command");
			}
		}
		
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
}
