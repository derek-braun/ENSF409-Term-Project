package control;

import model.Item;

public class ClientOrder extends OrderLine{

	ClientOrder(Item itemToOrder) {
		super(itemToOrder);
		genAmmount();
	}

	int numToOrder;
	
	private void genAmmount() {
		numToOrder = 50-item.getQuantity();
	}
	
	public String toString() {
		genAmmount();
		String s = "";
		s += "Item Name:       " + 	item.getName()+ "\n";
		s += "Ammount Ordered: " +	numToOrder+ "\n";
		s += "Supplier:        " + 	item.getSupplierID()+ "\n \n";
		return s;
	}
}
