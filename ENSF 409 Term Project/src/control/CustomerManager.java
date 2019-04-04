
package control;

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
	void runManager() {
		// TODO Auto-generated method stub
		
	}
}
