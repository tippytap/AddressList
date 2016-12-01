/**
 * AddressList.java - Maintains a list of Address records and methods to access them
 * @author erikmiller
 * @version 1.0
 */

public class AddressList {
	
	// keeps track of the beginning of the list
	private ListNode head;

	// keeps track of the last node added
	private ListNode currentNode;

	private boolean isEmpty;
	
	/**
	 * Creates a new address list
	 * */
	public AddressList(){
		isEmpty = true;
		head = null;
		currentNode = head;
	}
	
	 /**
	 This nested, private class represents a node of a singly linked list.
	 */
	 private class ListNode
	{
	 private String name;
	 private String tel; // Telephone number
	 private String email;
	 private String addr; // Address
	 private String dob; // Date of birth
	 private ListNode next; // Pointer to the next node

	 private ListNode(String name, String tel, String email, String addr, String dob)
	{
	 this.name = name;
	 this.tel = tel;
	 this.email = email;
	 this.addr = addr;
	 this.dob = dob;
	 } // end of the constructor

	 public String getName() { return name; }
	 public String getTel() { return tel; }
	 public String getEmail() { return email; }
	 public String getAddr() { return addr; }
	 public String getDob() {return dob; }

	 public void setName(String name) { this.name = name; }
	 public void setTel(String tel) { this.tel = tel; }
	 public void setEmail(String email) { this.email = email; }
	 public void setAddr(String addr) { this.addr = addr; }
	 public void setDob(String dob) { this.dob = dob; }

	 public ListNode getNext() { return next; }
	 public void setNext(ListNode link) { next = link; }
	 } // end of class ListNode

	// ======================================
	// Include your code here
	//======================================
	 
	 /**
	  * Tells if the list is empty or not
	  * @return boolean
	  * */
	 public boolean isEmpty(){
		 return this.isEmpty;
	 }
	 
	 /**
	  * Adds a node to the front of the list, before the head
	  * @param name String
	  * @param tel String
	  * @param email String
	  * @param address String
	  * @param dob String
	  * */
	 public void addToFront(String name, String tel, String email, String address, String dob){}

	 /**
	  * Adds a node to the back of the list, after the currentNode
	  * @param name String
	  * @param tel String
	  * @param email String
	  * @param address String
	  * @param dob String
	  * */
	 public void addToBack(String name, String tel, String email, String address, String dob){
		 
	 }

	 /**
	  * Lists string representations of all the list nodes in reverse order
	  * @return String
	  * */
	 public String reverseToString(){
		 return "";
	 }
	 
	 /**
	  * Returns the list in reverse order
	  * @return AddressList
	  * */
	 public AddressList reverse(){
		 return new AddressList();
	 }
	 
	 /**
	  * Returns the number of list nodes
	  * @return int 
	  * */
	 public int sizeOf(){
		 return -1;
	 }
	 
	 /**
	  * Finds and retrieves a phone number record
	  * @param name String
	  * @return String
	  * */
	 public String phoneNumberByName(String name){
		 return "";
	 }
	 
	 /**
	  * Finds and retrieves an email record
	  * @param name String
	  * @return String
	  * */
	 public String emailByName(String name){
		 return "";
	 }

	 /**
	  * Finds and retrieves a name record
	  * @param tel String
	  * @return String
	  * */
	 public String nameByPhoneNumber(String tel){
		 return "";
	 }

	 /**
	  * Finds and retrieves a date of birth record
	  * @param name String
	  * @return String
	  * */
	 public String dobByName(String name){
		 return "";
	 }
	 /**
	  * Returns a string representation of all the list nodes in the list
	  * @return String
	  * */
	 public String toString(){
		 return "";
	 }

}
