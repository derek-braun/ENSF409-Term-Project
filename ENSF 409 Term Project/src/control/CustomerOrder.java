package control;

import model.Item;

public class CustomerOrder extends Order{
	
	CustomerOrder(){
		super();
	}
	void addToOrder(Item itemToBuy, int ammount) {
		boolean notInList = true;
		for(int i = 0;  i < order.size(); i++) {
			if(order.get(i).getItem().equals(itemToBuy)) {
				notInList = false;
				break;
			}
		}
		if(notInList) {
			order.add(new CustomerOrderLine(itemToBuy, ammount));
		}
	}
	
	String checkout() {
		for(int i = 0; i < order.size(); i++) {
			((CustomerOrderLine) order.get(i)).checkOut();;
		}
		return this.toString();
		
	}
}
