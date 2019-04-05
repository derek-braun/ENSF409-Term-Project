package view;

public class CustomerClient extends ShopClient{

	public CustomerClient(String serverName, int portNumber) {
		super(serverName, portNumber);
	}
	
	//test
	protected void requestPlaceOrder(String id) {
		socketOut.write("CUSTOMER_ORDER\n");
		socketOut.write(id);
	}
}
