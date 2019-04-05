package view;

public class ManagerClient extends ShopClient{

	public ManagerClient(String serverName, int portNumber) {
		super(serverName, portNumber);
	}
	
	protected void createNewItem(String id, String name, String quantity, String price, String supplier) {
		socketOut.write("CREATE_ITEM " + id + " " + name + " " + quantity + " " + price + " " + supplier + "\n");
		socketOut.flush();
	}
	
	protected void createNewSupplier(String id, String name, String address, String contact) {
		socketOut.write("CREATE_SUPPLIER " + id + " " + name + " " + address + " " + contact + "\n");
		socketOut.flush();
	}
	
	protected void changeItemPrice(String id, String price) {
		socketOut.write("CHANGE_PRICE " + id + " " + price + "\n");
		socketOut.flush();
	}
	
//	protected void requestPlaceOrder(String id) {
//		socketOut.write("MANAGER_ORDER\n");
//		socketOut.write(id);
//	}
}
