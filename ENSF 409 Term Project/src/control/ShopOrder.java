package control;

import model.Item;

public class ShopOrder extends Order{

	ShopOrder(){
		super();
	}
	void addToOrder(Item toolToAdd){
		boolean notInList = true;
		for(int i = 0;  i < order.size(); i++) {
			if(order.get(i).getItem().equals(toolToAdd)) {
				notInList = false;
				break;
			}
		}
		if(notInList) {
			order.add(new ClientOrder(toolToAdd));
		}
	}
	
}
