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
	void runManager() {
		while(true) {
			String input = null;
			try {
				input = socketIn.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//CHEESE
			String[] command = input.split("\n");
			String[] parameters = command[1].split(" ");
			if(command[0].equals("CREATE_ITEM")) {
				int id = Integer.parseInt(parameters[0]); 
				String name = parameters[1];
				int quantity = Integer.parseInt(parameters[2]);
				double price = Double.parseDouble(parameters[3]);
				int supplierID = Integer.parseInt(parameters[4]);
				addNewItem(id,name,quantity,price,supplierID);
				
			}
			else if(command[0].equals("CREATE_NEWSUPPLIER")) {
				int id = Integer.parseInt(parameters[0]);
				addNewSupplier(id, parameters[1], parameters[2], parameters[3]);
			}else if(command[0].equals("CHANGE_PRICE")) {
				int id = Integer.parseInt(parameters[0]);
				double change = Double.parseDouble(parameters[1]);
				changePrice(id, change);
			}else if(command[0].equals("SEARCH")) {
				int id = Integer.parseInt(parameters[0]);
				sendString(search(id).toString());
			}else if(command[0].equals("SEE_ORDER")) {
				sendString(order.toString());
			}
		}
		
	}
}
