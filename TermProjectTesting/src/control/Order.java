package control;
import java.util.ArrayList;
import java.util.Random;
import model.*;

abstract class Order{
	protected ArrayList<OrderLine> order;
	int orderID;
	Order(){
		order = new ArrayList<OrderLine>();
		generateID();
	}

	void removeFromOrder(Item itemToRemove) {
		order.remove(itemToRemove);
	}
	
	void generateID() {
		Random rand = new Random();
		orderID = rand.nextInt(9999);
	}
	
	public String toString() {
		//TODO actual time instead of the bs i'm doing now
		String s = "";
		s += "********************************************************************\n";
		s += "Order ID:        " +  orderID + "\n";
		s += "Date Ordered:    " + 	System.currentTimeMillis() + "ms + January ,1,1970 \n \n";
		for(int i = 0; i < order.size(); i++) {
			s += order.get(i).toString();
		}
		s += "********************************************************************";
		return s;
	}

}
