import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * ListGUI.java - specifics here
 * @author erikmiller
 * @version 1.0
 */

public class ListGUI {

	private final JTextField name = new JTextField(),
					   email = new JTextField(),
					   addr = new JTextField(),
					   area = new JTextField(),
					   firstTel = new JTextField(),
					   secondTel = new JTextField();
	
	private JLabel nameL, emailL, addrL, telL, dobL;
	
	private final JLabel sizeL = new JLabel(), errorL = new JLabel();

	@SuppressWarnings("unchecked")
	private final JComboBox 
	year = new JComboBox(new String[]{
		"Year",
		"1987",
		"1988",
		"1989",
		"1990",
		"1991",
		"1992",
		"1993",
		"1994",
		"1995",
		"1996"
	}), 
	day = new JComboBox(new String[]{
		"Month",
		"01",
		"02",
		"03",
		"04",
		"05",
		"06",
		"07",
		"08",
		"09",
		"10",
		"11",
		"12",
		"13",
		"14",
		"15",
		"16",
		"17",
		"18",
		"19",
		"20",
		"21",
		"22",
		"23",
		"24",
		"25",
		"26",
		"27",
		"28",
		"29",
		"30",
		"31"
	}), 
	month = new JComboBox(new String[]{
		"Day",
		"01",
		"02",
		"03",
		"04",
		"05",
		"06",
		"07",
		"08",
		"09",
		"10",
		"11",
		"12"
	});
	
	@SuppressWarnings("unchecked")
	private final JComboBox retrieveBy = new JComboBox(new String[]{
			"Name by Phone",
			"Phone by Name",
			"Date of birth by Name",
			"Email by Name"
	});
	
	private final JTextArea output = new JTextArea();
	
	private JScrollPane scroll;
	
	private JFrame frame;
	
	private JPanel mainPanel, outputPanel;
	
	private JButton addContact,
					retrieveContact;
	
	private final Dimension textD = new Dimension(200, 20);
	private final Dimension vSpace = new Dimension(0, 20);
	
	private AddressList addresses;
	
	private ActionListener reverseListListener = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			addresses = addresses.reverse();
		}
		
	};
	
	private ActionListener printListListener = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			output.setText(addresses.toString());
		}
		
	};

	private ActionListener printReverseListListener = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			output.setText(addresses.reverseToString());
		}
		
	};
	
	private ActionListener retrieveButtonListener = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				String method = retrieveBy.getSelectedItem().toString();
				switch(method){
				case "Name by Phone":
					String phone = concat(new String[]{
							area.getText(),
							firstTel.getText(),
							secondTel.getText()
					}, '-');
					output.setText(retrieveContact(
						validateText(phone), method
					));
					break;
				case "Phone by Name":
					output.setText(retrieveContact(validateText(name.getText()), method));
					break;
				case "Email by Name":
					output.setText(retrieveContact(validateText(name.getText()), method));
					break;
				case "Date of birth by Name":
					output.setText(retrieveContact(validateText(name.getText()), method));
					break;
				}
			}
			catch(InvalidEntryException invalid){
				errorL.setText(invalid.getMessage());
			}
			catch(ContactNotFoundException notFound){
				errorL.setText(notFound.getMessage());
			}
		}
		
	};
	
	private ActionListener addButtonListener = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			try{
				errorL.setText("");
				String nameText = validateText(name.getText());
				String phoneText = validateText(concat(new String[]{
						area.getText(),
						firstTel.getText(),
						secondTel.getText()
				}, '-'));
				String emailText = validateText(email.getText());
				String addressText = addr.getText();
				String dobText = validateText(concat(new String[]{
						validateCombo(year.getSelectedItem().toString()),
						validateCombo(month.getSelectedItem().toString()),
						validateCombo(day.getSelectedItem().toString())
				}, '-'));
				addNewContact(nameText, phoneText, emailText, addressText, dobText);
				setSizeLabel();
			}
			catch(Exception err){
				errorL.setText(err.getMessage());
			}
		}
		
	};
	
	/**
	 * Instantiates a ListGUI
	 * @param boolean debug
	 * */
	public ListGUI(boolean debug){
		addresses = new AddressList();
		if(!debug){
			
			mainPanel = new JPanel();
			mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
			outputPanel = new JPanel();

			addComp();

			frame = new JFrame();
			frame.getContentPane().add(mainPanel);
			frame.pack();
			frame.setVisible(true);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	
	private void addComp(){
		addError();
		addSize();
		addName();
		addEmail();
		addAddress();
		addTel();
		addDob();
		addRegister();
		addContact();
		addLookup();
		addPrint();
		addOutput();

	}
	
	private void addError(){
		JPanel errorPanel = new JPanel();
		errorPanel.add(errorL);
		errorL.setText("");
		mainPanel.add(errorPanel);
	}
	
	private void addSize(){
		mainPanel.add(Box.createRigidArea(vSpace));
		sizeL.setText("Size: " + addresses.sizeOf());
		mainPanel.add(sizeL);
	}
	
	private void addName(){
		JPanel namePanel = new JPanel();
		namePanel.add(nameL = new JLabel("Name*:"));
		namePanel.add(name);
		mainPanel.add(namePanel);
		name.setPreferredSize(textD);
		mainPanel.add(Box.createRigidArea(vSpace));
	}
	
	private void addEmail(){
		JPanel emailPanel = new JPanel();
		emailPanel.add(emailL = new JLabel("Email*:"));
		emailPanel.add(email);
		mainPanel.add(emailPanel);
		email.setPreferredSize(textD);
		mainPanel.add(Box.createRigidArea(vSpace));
	}
	
	private void addAddress(){
		JPanel addressPanel = new JPanel();
		addressPanel.add(addrL = new JLabel("Address:"));
		addressPanel.add(addr);
		addr.setPreferredSize(textD);
		mainPanel.add(addressPanel);
		mainPanel.add(Box.createRigidArea(vSpace));
	}
	
	private void addTel(){
		JPanel tel = new JPanel();
		tel.add(telL = new JLabel("Phone*:"));
		Dimension telD = new Dimension(40, 20);
		area.setPreferredSize(telD);
		firstTel.setPreferredSize(telD);
		secondTel.setPreferredSize(new Dimension(60, 20));
		tel.add(area);
		tel.add(firstTel);
		tel.add(secondTel);
		mainPanel.add(tel);
		mainPanel.add(Box.createRigidArea(vSpace));
	}
	
	private void addDob(){
		JPanel dobPanel = new JPanel();
		dobPanel.add(dobL = new JLabel("Date of birth*:"));
		dobPanel.add(year);
		dobPanel.add(month);
		dobPanel.add(day);
		mainPanel.add(dobPanel);
	}
	
	private void addRegister(){
		JPanel registeredPanel = new JPanel();
		JLabel registeredFields = new JLabel("* fields are required");
		registeredPanel.add(registeredFields);
		mainPanel.add(registeredPanel);
	}
	
	private void addContact(){
		JPanel addContactPanel = new JPanel();
		addContactPanel.add(addContact = new JButton("Add Contact"));
		addContact.addActionListener(addButtonListener);
		mainPanel.add(addContactPanel);
	}
	
	private void addLookup(){
		JPanel lookupPanel = new JPanel();
		JLabel lookupL = new JLabel("Look up");
		lookupPanel.add(lookupL);
		lookupPanel.add(retrieveBy);
		lookupPanel.add(retrieveContact = new JButton("Retrieve"));
		retrieveContact.addActionListener(retrieveButtonListener);
		mainPanel.add(lookupPanel);
	}
	
	private void addPrint(){
		JPanel printPanel = new JPanel();
		JButton printListButton = new JButton("Show all contacts");
		printListButton.addActionListener(printListListener);
		JButton printReverseListButton = new JButton("Show all contacts in reverse");
		printReverseListButton.addActionListener(printReverseListListener);
		printPanel.add(printListButton);
		printPanel.add(printReverseListButton);
		JButton reverseListButton = new JButton("Reverse list");
		printPanel.add(reverseListButton);
		reverseListButton.addActionListener(reverseListListener);
		mainPanel.add(printPanel);
	}
	
	private void addOutput(){
		JPanel outputPanel = new JPanel();
		scroll = new JScrollPane(output);
		scroll.setPreferredSize(new Dimension(300, 300));
		outputPanel.setLayout(new BorderLayout());
		outputPanel.add(scroll, BorderLayout.CENTER);
		mainPanel.add(outputPanel);
	}
	
	private void setSizeLabel(){
		sizeL.setText("Size: " + addresses.sizeOf());
	}
	
	/**
	 * Adds a new contact to the AddressList
	 * @param name String
	 * @param tel String
	 * @param email String
	 * @param addr String
	 * @param dob String
	 * */
	
	public void addNewContact(String name, String tel, String email, String addr, String dob){
		addresses.addToBack(name, tel, email, addr, dob);
	}
	
	/**
	 * Returns the size of the AddressList
	 * @return int
	 * */
	public int getSize(){
		return addresses.sizeOf();
	}
	
	/**
	 * Concatenates strings from an array into one string with a character in between
	 * @param strings String[]
	 * @param delim char
	 * @return String
	 * */
	
	public String concat(String[] strings, char delim){
		String result = "";
		for(String str : strings){
			if(!str.equals(strings[strings.length - 1]))
				result += str + delim;
			else
				result += str;
		}
		return result;
	}
	
	private class InvalidEntryException extends Exception{
		private String message;
		public InvalidEntryException(String message){
			this.message = message;
		}
		public String getMessage(){
			return message;
		}
	}
	private class ContactNotFoundException extends Exception{
		private String message;
		public ContactNotFoundException (String message){
			this.message = message;
		}
		public String getMessage(){
			return message;
		}
	}
	
	/**
	 * Makes sure a selected item is not Month, Day, or Year
	 * @param entry String
	 * @return String
	 * */
	public String validateCombo(String entry) throws InvalidEntryException {
		if(entry.equals("Year") || entry.equals("Month") || entry.equals("Day"))
			throw new InvalidEntryException("Please choose a valid date of birth");
		return entry;
	}
	
	/**
	 * Makes sure a string is not empty or null before adding to the list
	 * @param entry string
	 * @return String
	 * */
	public String validateText(String entry) throws InvalidEntryException{
		if(entry == null || entry.equals("")){
			throw new InvalidEntryException("Please enter required field(s)");
		}
		return entry;
	}
	
	/**
	 * Finds the contact information specified in the key based on a particular search method
	 * @param key String
	 * @param method String 
	 * @return String
	 * */
	public String retrieveContact(String key, String method) throws ContactNotFoundException{
		if(addresses.isEmpty()) 
			throw new ContactNotFoundException("No contacts");
		String value = "";
		switch(method){
		case "Name by Phone":
			value = addresses.nameByPhoneNumber(key);
			break;
		case "Phone by Name":
			value = addresses.phoneNumberByName(key);
			break;
		case "Email by Name":
			value = addresses.emailByName(key);
			break;
		case "Date of birth by Name":
			value = addresses.dobByName(key);
			break;
		}
		if(value.equals("No matching data"))
			throw new ContactNotFoundException(value);
		return value;
	}
	
	/**
	 * The main method
	 * @param args String[]
	 * */
	public static void main(String[] args){
		new ListGUI(false);
	}
}
