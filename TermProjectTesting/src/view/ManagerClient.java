package view;

public class ManagerClient extends ShopClient{

	public ManagerClient(String serverName, int portNumber) {
		super(serverName, portNumber);
	}
	
	protected void createNewItem(String id, String name, String quantity, String price, String supplier) {
		socketOut.write("CREATE_ITEM\n");
		socketOut.write(id + " " + name + " " + quantity + " " + price + " " + supplier);
	}
	
	protected void createNewSupplier(String id, String name, String address, String contact) {
		socketOut.write("CREATE_SUPPLIER\n");
		socketOut.write(id + " " + name + " " + address + " " + contact);
	}
	
	protected void changeItemPrice(String price) {
		socketOut.write("CHANGE_PRICE\n");
		socketOut.write(price);
	}
	
	protected void requestPlaceOrder(String id) {
		socketOut.write("MANAGER_ORDER\n");
		socketOut.write(id);
	}
}
