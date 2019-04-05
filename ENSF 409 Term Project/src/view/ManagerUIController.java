package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.AbstractButton;

public class ManagerUIController {
	protected ManagerClient managerClient;
	protected ShopUI shopUI;
	
	public ManagerUIController(String serverName, int portNumber) {
		managerClient = new ManagerClient(serverName, portNumber);
		shopUI = new ShopUI();
		shopUI.addListener(new OperationListener(), shopUI.viewOrder);
		shopUI.addListener(new OperationListener(), shopUI.searchButton);
	}
	
	public static void main(String[] args) {
		ManagerUIController control = new ManagerUIController("localhost", 9090);
	}
	
	public void shopSession() {
		String input = "";
		String response = "";
		String display = null;
		try {
			response = managerClient.socketIn.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while (true) {
			try {
				while (!(display = managerClient.socketIn.readLine()).equals("END"))
			        response  += display += ("\n");
				System.out.println(response);
				response = "";
				display = managerClient.socketIn.readLine();
				if(display.equals("QUIT")) {
					break;
				}
				
			} catch (IOException e) {
				System.out.println("Sending error: " + e.getMessage());
			}
		}
		try {
			managerClient.socketIn.close();
			managerClient.socketOut.close();
		} catch (IOException e) {
			System.out.println("Closing error: " + e.getMessage());
		}
	}
	
	class OperationListener implements ActionListener{
		protected String[] inputText;

		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonLabel = ((AbstractButton) e.getSource()).getText();
			System.out.println(buttonLabel);
			inputText = new String[10];
			
			switch(buttonLabel) {
			case "View":
				break;
			case "Search":
				new SearchWindow(managerClient);
				break;
			default :
				System.out.println("Invalid command");
			}
		}
		
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
}
