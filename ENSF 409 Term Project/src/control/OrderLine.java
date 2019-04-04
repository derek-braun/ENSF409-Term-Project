package control;
import model.Item;

abstract class OrderLine {
	Item item;
	
	OrderLine(Item itemToOrder){
		item = itemToOrder;
	}
	public Item getItem() {
		return item;
	}
	
	public abstract String toString();


}
