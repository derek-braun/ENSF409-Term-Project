
package control;

import java.io.IOException;
import java.net.Socket;

import model.Inventory;
import model.Item;

public class CustomerManager extends Manager {
	CustomerManager(Socket client,Inventory inv){
		super(client,inv);
	}

	
	public void removeFromCart(Item item) {
		order.removeFromOrder(item);
	}
	
	public String checkOut() {
		return ((CustomerOrder)order).checkout();
	}

	void addToCart(Item item, int ammount) {
		((CustomerOrder)order).addToOrder(item, ammount);
		
	}


	@Override
	Runnable runManager() {
		System.out.println("Running Customer Manager");
		while(true) {
			
			String input = null;
			System.out.println("Running C Manager");
			try {
				input = socketIn.readLine();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
			//CHEESE
			System.out.println(input);
			String[] command = input.split(" ");
			System.out.println("Command: " + command[0]);
			
			//Removes an item from cart using item ID as input
			if(command[0].equals("REMOVE_FROM_CART")) {
				int id = Integer.parseInt(command[1]); 
				removeFromCart(inventory.search(id));
			}else if(command[0].equals("ADD_TO_CART")) {
				int id = Integer.parseInt(command[1]);
				int ammount = Integer.parseInt(command[2]);
				addToCart(inventory.search(id),ammount);
			}else if(command[0].equals("SEARCH_ITEM")) {
				//System.out.println("Entering search");
				int id = Integer.parseInt(command[1]);
				String s = search(id).toString();
				System.out.println(s);
				sendString(s);
				//System.out.println("Exiting search");
			}else if(command[0].equals("PRINT_ORDER")) {
				sendString(order.toString());
			}else if(command[0].equals("CHECK_OUT")) {
				sendString(checkOut());
			}else if(command[0].equals("PRINT_INVENTORY")) {
				String s = inventory.toString();
				System.out.println(s);
				sendString(s);
			}
			
		}
		
	}
}
