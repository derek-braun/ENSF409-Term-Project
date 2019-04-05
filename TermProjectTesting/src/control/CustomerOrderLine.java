package control;

import model.Item;

public class CustomerOrderLine extends OrderLine{
	int numToBuy;
	
	
	CustomerOrderLine(Item itemToOrder, int numToBuy){
		super(itemToOrder);
	}
	
	void checkOut() {
		item.setQuantity(item.getQuantity()-numToBuy);
	}
	
	public String toString() {
		String s = "";
		s += "Item Name:       " + 	item.getName()+ "\n";
		s += "Ammount Bought: " +	numToBuy+ "\n";
		s += "Supplier:        " + 	item.getSupplierID()+ "\n \n";
		return s;
	}
}