package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Holds information about each item in the inventory
 * @author Ryan Ward
 *
 */
public class Item {
	
	/**
	 * id of the item
	 */
	private int id;
	
	/**
	 * Name of the item
	 */
	private String name;
	
	/**
	 * Quantity in the inventory
	 */
	private int quantity;
	
	/**
	 * Price of the item
	 */
	private double price;
	
	/**
	 * ID of the supplier of the item
	 */
	int SupplierID;
	
	/**
	 * Constructor of class Item.
	 * @param id
	 * @param name
	 * @param quantity
	 * @param price
	 * @param SupplierID
	 */
	public Item(int id, String name, int quantity, double price, int SupplierID) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.SupplierID = SupplierID;
	}
	
	/**
	 * Getter for id.
	 * @return id
	 */
	public int getID() {
		return id;
	}
	
	/**
	 * Setter for id.
	 * @param id
	 */
	public void setID(int id) {
		this.id = id;
	}
	
	/**
	 * Getter for name.
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter for name.
	 * @param s
	 */
	public void setName(String s) {
		name = s;
	}
	
	/**
	 * Getter for quantity.
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Setter for quantity.
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Getter for price.
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Setter for price.
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Getter for SupplierID
	 * @return SupplierID
	 */
	public int getSupplierID() {
		return SupplierID;
	}
	
	/**
	 * Setter for SupplierID
	 * @param id
	 */
	public void setSupplierID(int id) {
		SupplierID = id;
	}
	
	/**
	 * toString method, responsible for combining some of the variables into a string.
	 */
	public String toString() {
		return "Item Name: " + this.name + "   ID: " + this.id + "   Price: " + this.price + "   Quantity: " + this.quantity + "   Supplier ID: " + this.SupplierID;
	}

}
