package control;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import model.*;

public class ShopManager extends Manager {

	ArrayList<Supplier> suppliers;
	ShopManager(Socket client, Inventory inv, ArrayList<Supplier> sup){
		super(client, inv);
		suppliers = sup;
		System.out.println("new Shop Manager");
	}
	
	void addNewItem(int id, String name, int quantity, double price, int supplierID){
		inventory.addTool(id, name, quantity, price, supplierID);
	}
	
	void addNewSupplier(int id, String companyName, String address, String salseContact) {
		suppliers.add(new Supplier(id, companyName, address, salseContact));
	}
	
	void changePrice(String name, double change) {
		inventory.search(name).setPrice(change);
	}
	
	void changePrice(int id, double change) {
		inventory.search(id).setPrice(change);
	}

	@Override
	Runnable runManager() {
		System.out.println("Running Manager");
		while(true) {
			String input = null;
			try {
				input = socketIn.readLine();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
			//CHEESE
			System.out.println(input);
			String[] command = input.split(" ");
			System.out.println("Command: " + command[0]);
			if(command[0].equals("CREATE_ITEM")) {
				int id = Integer.parseInt(command[1]); 
				String name = command[2];
				int quantity = Integer.parseInt(command[3]);
				double price = Double.parseDouble(command[4]);
				int supplierID = Integer.parseInt(command[5]);
				addNewItem(id,name,quantity,price,supplierID);
				
			}
			else if(command[0].equals("CREATE_SUPPLIER")) {
				int id = Integer.parseInt(command[1]);
				addNewSupplier(id, command[2], command[3], command[4]);
			}else if(command[0].equals("CHANGE_PRICE")) {
				int id = Integer.parseInt(command[1]);
				double change = Double.parseDouble(command[2]);
				changePrice(id, change);
			}else if(command[0].equals("SEARCH_ITEM")) {
				//System.out.println("Entering search");
				int id = Integer.parseInt(command[1]);
				String s = search(id).toString();
				System.out.println(s);
				sendString(s);
				//System.out.println("Exiting search");
			}else if(command[0].equals("MANAGE_ORDER")) {
				sendString(order.toString());
			}else if(command[0].equals("PRINT_INVENTORY")) {
				String s = inventory.toString();
				System.out.println(s);
				sendString(s);
			}
		}
		
	}
}
