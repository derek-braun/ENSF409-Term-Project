package model;

/**
 * Class supplier, holds information about the supplier of the tools.
 *
 * @author Ryan Ward
 */
public class Supplier {
	
	/**
	 * Supplier id
	 */
	private int id;
	
	/**
	 * Name of the supplier
	 */
	private String companyName;
	
	/**
	 * Address of the supplier
	 */
	private String address;
	
	/**
	 * Name of the contact
	 */
	private String salesContact;
	
	/**
	 * Constructor of the class Supplier.
	 * @param id
	 * @param name
	 * @param address
	 * @param contact
	 */
	public Supplier(int id, String name, String address, String contact) {
		this.id = id;
		companyName = name;
		this.address = address;
		salesContact = contact;
	}
	
	/**
	 * Getter for supplier id
	 * @return id
	 */
	public int getID() {
		return id;
	}
	
	/**
	 * Setter for supplier id
	 * @param id
	 */
	public void setID(int id) {
		this.id = id;
	}
	
	/**
	 * Getter for the company name
	 * @return companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	
	/**
	 * Setter for the company name
	 * @param name
	 */
	public void setCompanyName(String name) {
		companyName = name;
	}
	
	/**
	 * Getter for the address of the supplier
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Setter for the address of the supplier
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Getter for the contact
	 * @return salesContact
	 */
	public String getContact() {
		return salesContact;
	}
	
	/**
	 * Setter for the contact
	 * @param contact
	 */
	public void setContact(String contact) {
		salesContact = contact;
	}

}
