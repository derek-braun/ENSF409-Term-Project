package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Used for filling itemList, and traversing through the list when needed for many different
 * functionalities.
 * @author Ryan Ward
 *
 */
public class Inventory {
	
	/**
	 * List of items
	 */
	private ArrayList <Item> itemList = new ArrayList<Item>();
	
	/**
	 * Used to set variables
	 */
	Item newItem;
	
	/**
	 * Constructor of class Inventory, used to fill itemList from text file
	 */
	
	public Inventory(String fileName) {
		try {
			File file = new File(fileName);  // assumes ".txt" has been included in the input
			Scanner item = new Scanner(file);
			String itemInfo;
			String[] info = new String[5];
			Item itemToAdd;
			while(item.hasNextLine()) {
				itemInfo = item.nextLine();
				info = itemInfo.split(";");
				itemToAdd = new Item(Integer.parseInt(info[0]), info[1], Integer.parseInt(info[2]), Double.parseDouble(info[3]), Integer.parseInt(info[4])); 
				itemList.add(itemToAdd);
			}
			
		}catch(FileNotFoundException e) {
			System.out.println("File " + fileName + " not found!");
		}
	}
	
	
	
	/**
	 * Method used to set variables to new values.
	 * @param id
	 * @param name
	 * @param quantity
	 * @param price
	 * @param SupplierID
	 */
	public void addTool(int id, String name, int quantity, double price, int supplierID) {
		newItem = new Item(id, name, quantity, price, supplierID);
//		newItem.setID(id);
//		newItem.setName(name);
//		int newQuantity = newItem.getQuantity() + quantity;
//		newItem.setQuantity(newQuantity);
//		newItem.setPrice(price);
//		newItem.setSupplierID(SupplierID);
		itemList.add(newItem);
	}
	
	/**
	 * Used to remove tool from the list.
	 * @param name
	 */
	public void deleteTool(String name) {
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i).getName().equals(name)) {
				itemList.remove(i);
			}
		}
	}
	
	/**
	 * Used to search for an item by its id
	 * @param id
	 * @return Item
	 */
	public Item search(int id) {
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i).getID() == id)
				return itemList.get(i);
		}
		return null;
	}
	
	/**
	 * Used to search for an item by its name
	 * @param name
	 * @return Item
	 */
	public Item search(String name) {
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i).getName().equals(name))
				return itemList.get(i);
		}
		return null;
	}
	
	/**
	 * Used to check the quantity of a given item
	 * @param name
	 * @return quantity
	 */
	public int checkQuantity(String name) {
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i).getName().equals(name))
				return itemList.get(i).getQuantity();  //if this is below 40, call method to order to create an order line for the item
		}
		
		return 0;
	}
	
	/**
	 * Used to lower the quantity of an item.
	 * @param name
	 * @param ammount
	 */
	public void lowerQuantity(String name, int ammount) {
		//TODO Error checking for going too low
		for(int i = 0; i < itemList.size(); i++) {
			if(itemList.get(i).getName().equals(name)) {
				itemList.get(i).setQuantity(ammount - itemList.get(i).getQuantity());
			}
				
		}
		

	}
	
	/**
	 * Used to print itemList, displaying the tools in the inventory
	 */
	public void listTools() {
		for(int i = 0; i < itemList.size(); i++) {
			System.out.println(itemList.get(i).getName() + "  " + itemList.get(i).getID() + "  " + itemList.get(i).getPrice() + "  " + itemList.get(i).getQuantity() + "  " + itemList.get(i).getSupplierID());
		}
	}
	
	/**
	 * Getter for itemList
	 * @return itemList
	 */
	public ArrayList<Item> getItemList(){
		return itemList;
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i < itemList.size(); i++) {
			s += itemList.get(i).toString() + "%";
		}
		return s;
	}
}
