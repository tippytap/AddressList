/**
 * AddressList.java - specifics here
 * @author erikmiller
 * @version 1.0
 */

public class AddressList {
	
	private ListNode head;
	private ListNode currentNode;
	private boolean isEmpty;
	
	public AddressList(){
		isEmpty = true;
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

	 public boolean isEmpty(){
		 return this.isEmpty;
	 }
	 
	 public void addToFront(String name, String tel, String email, String address, String dob){}

	 public void addToBack(String name, String tel, String email, String address, String dob){
		 
	 }

	 public String reverseToString(){
		 return "";
	 }
	 
	 public AddressList reverse(){
		 return new AddressList();
	 }
	 
	 public int sizeOf(){
		 return -1;
	 }
	 
	 public String phoneNumberByName(String name){
		 return "";
	 }
	 
	 public String emailByName(String name){
		 return "";
	 }

	 public String nameByPhoneNumber(String tel){
		 return "";
	 }

	 public String dobByName(String name){
		 return "";
	 }

}
