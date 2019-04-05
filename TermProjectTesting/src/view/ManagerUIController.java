package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.AbstractButton;

public class ManagerUIController {
	protected ManagerClient managerClient;
	protected ShopUI shopUI;
	
	public ManagerUIController(String serverName, int portNumber) {
		managerClient = new ManagerClient(serverName, portNumber);
		shopUI = new ShopUI();
		shopUI.addListener(new OperationListener(), shopUI.listAllButton);
		shopUI.addListener(new OperationListener(), shopUI.searchButton);
		shopUI.addListener(new OperationListener(), shopUI.addItem);
		shopUI.addListener(new OperationListener(), shopUI.addSupplier);
		shopUI.addListener(new OperationListener(), shopUI.changePrice);
	}
	
	public static void main(String[] args) {
		ManagerUIController control = new ManagerUIController("localhost", 8099);
		control.shopSession();
	}
	
	public void shopSession() {
		while(true) {
			String input = null;
			String[] itemFormat = null;
			System.out.println("Running Client");
			try {
				input = managerClient.socketIn.readLine();
				System.out.println(input);
				switch(managerClient.operation) {
				case "SEARCH_ITEM":
					shopUI.itemList.clear();
					shopUI.itemList.addElement(input);
					break;
				case "PRINT_INVENTORY":
					shopUI.itemList.clear();
					itemFormat = input.split("%");
					for(int i = 0; i < itemFormat.length; i++) {
						shopUI.itemList.addElement(itemFormat[i]);
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
				managerClient.requestListAll();
				break;
			case "Search":
				new SearchWindow(managerClient);
				break;
			case "Add Item":
				new NewItemWindow(managerClient);
				break;
			case "Add Supplier":
				new NewSupplierWindow(managerClient);
				break;
			case "Change Price":
				new ChangePriceWindow(managerClient, (String) shopUI.list.getSelectedValue());
				break;
			default :
				System.out.println("Invalid command");
			}
		}
		
	}
	
	private void searchItem(String name) {
		managerClient.requestSearch(name);
	}
	
//	private void placeOrder(String id) {
//		managerClient.requestPlaceOrder(id);
//	}
	
	private void createNewSuppler(String id, String name, String address, String contact) {
		managerClient.createNewSupplier(id, name, address, contact);
	}
	
	private void createNewItem(String id, String name, String quantity, String price, String supplier) {
		managerClient.createNewItem(id, name, quantity, price, supplier);
	}
	
	private void changeItemPrice(String id, String price) {
		managerClient.changeItemPrice(id, price);
	}
	
	private void viewOrder() {
		
	}
}
