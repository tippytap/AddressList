/**
 * AddressList.java - Maintains a list of Address records and methods to access them
 * @author erikmiller
 * @version 1.0
 */

public class AddressList {
	
	private ListNode head;

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
		 return isEmpty;
	 }
	 
	 /**
	  * Adds a node to the front of the list, before the head
	  * @param name String
	  * @param tel String
	  * @param email String
	  * @param address String
	  * @param dob String
	  * */
	 public void addToFront(String name, String tel, String email, String address, String dob){
		 if(head == null)
			 head = new ListNode(name, tel, email, address, dob);
		 else{
			 ListNode temp = head;
			 head = new ListNode(name, tel, email, address, dob);
			 head.setNext(temp);
		 }
		 rewind();
		 isEmpty = false;
	 }

	 /**
	  * Adds a node to the back of the list
	  * @param name String
	  * @param tel String
	  * @param email String
	  * @param address String
	  * @param dob String
	  * */
	 public void addToBack(String name, String tel, String email, String address, String dob){
		 currentNode = head;
		 if(currentNode == null)
			 addToFront(name, tel, email, address, dob);
		 else{
			 ListNode newNode = new ListNode(name, tel, email, address, dob);
			 traverseToEnd();
			 currentNode.setNext(newNode);
			 rewind();
		 }
	 }
	 
	 private void traverseToEnd(){
		 if(currentNode.getNext() == null){
			 return;
		 }
		 else{
			 currentNode = currentNode.getNext();
			 traverseToEnd();
		 }
	 }
	 
	 /**
	  * Lists string representations of all the list nodes in reverse order
	  * @return String
	  * */
	 public String reverseToString(){
		 String list = "";
		 ListNode prev = currentNode;
		 if(head != null){
			 if(currentNode.getNext() == null){
				 list += "";
			 }
			 else{
				 traverse();
				 list += reverseToString();
			 }
			 currentNode = prev;
			 list += nodeToString(currentNode);
		 }
		 return list;
	 }
	 
	 private String nodeToString(ListNode node){
		 String list = "";
		 list += "---------------------------\n";
		 list += currentNode.getName() + "\n";
		 list += currentNode.getTel() + "\n";
		 list += currentNode.getEmail() + "\n";
		 list += currentNode.getAddr() + "\n";
		 list += currentNode.getDob() + "\n";
		 list += "---------------------------\n";
		 return list;
	 }
	 
	 /**
	  * Returns the list in reverse order
	  * @return AddressList
	  * */
	 public AddressList reverse(){
		 AddressList addresses = new AddressList();
		 rewind();
		 reOrderNodes(addresses, head);
		 return addresses;
	 }
	 
	 private void reOrderNodes(AddressList list, ListNode node){
		 if(node != null){
			 if(node.getNext() == null){
				 list.addToFront(node.getName(), node.getTel(), node.getEmail(), node.getAddr(), node.getDob());
			 }
			 else{
				 list.addToFront(node.getName(), node.getTel(), node.getEmail(), node.getAddr(), node.getDob());
				 reOrderNodes(list, node.getNext());
			 }
		 }
			 
	 } 
	 /**
	  * Returns the number of list nodes
	  * @return int 
	  * */
	 public int sizeOf(){
		 if(head == null)
			 return 0;

		 if(currentNode.getNext() == null){
			 rewind();
			 return 1;
		 }
		 else{
			 currentNode = currentNode.getNext();
			 return 1 + sizeOf();
		 }
	 }
	 
	 /**
	  * Finds and retrieves a phone number record
	  * @param name String
	  * @return String
	  * */
	 public String phoneNumberByName(String name){
		 String tel = "";

		 if(currentNode.getNext() == null && 
				 !currentNode.getName().equals(name))
			 tel = "No matching data";
		 else if(currentNode.getName().equals(name)){
			 tel = currentNode.getTel();
			 rewind();
		 }
		 else{
			 traverse();
			 tel = phoneNumberByName(name);
		 }
		 
		 return tel;

	 }
	 
	 private void traverse(){
		 currentNode = currentNode.getNext();
	 }
	 
	 private void rewind(){
		 currentNode = head;
	 }
	 
	 /**
	  * Finds and retrieves an email record
	  * @param name String
	  * @return String
	  * */
	 public String emailByName(String name){
		 String email = "";

		 if(currentNode.getNext() == null && 
				 !currentNode.getName().equals(name)){
			 email = "No matching data";
			 rewind();
		 }
		 else if(currentNode.getName().equals(name)){
			 email = currentNode.getEmail();
			 rewind();
		 }
		 else{
			 traverse();
			 email = emailByName(name);
		 }
		 
		 return email;
	 }

	 /**
	  * Finds and retrieves a name record
	  * @param tel String
	  * @return String
	  * */
	 public String nameByPhoneNumber(String tel){
		 String name = "";
		 if(currentNode.getNext() == null && 
				 !currentNode.getTel().equals(tel)){
			 name = "No matching data";
			 rewind();
		 }
		 else if(currentNode.getTel().equals(tel)){
			 name = currentNode.getName();
			 rewind();
		 }
		 else{
			 traverse();
			 name = nameByPhoneNumber(tel);
		 }
		 
		 return name;
	 }

	 /**
	  * Finds and retrieves a date of birth record
	  * @param name String
	  * @return String
	  * */
	 public String dobByName(String name){
		 String dob = "";

		 if(currentNode.getNext() == null && 
				 !currentNode.getName().equals(name)){
			 dob = "No matching data";
			 rewind();
		 }
		 else if(currentNode.getName().equals(name)){
			 dob = currentNode.getDob();
			 rewind();
		 }
		 else{
			 traverse();
			 dob = dobByName(name);
		 }
		 
		 return dob;
	 }
	 /**
	  * Returns a string representation of all the list nodes in the list
	  * @return String
	  * */
	 public String toString(){
		 String list = "";
		 if(head != null){
			 if(currentNode.getNext() == null){
				 list += nodeToString(currentNode);
				 rewind();
			 }
			 else{
				 list += nodeToString(currentNode);
				 currentNode = currentNode.getNext();
				 list += toString();
			 }
		 }
		 return list;
	 }

}
