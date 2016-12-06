import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * AddressListTest.java - specifics here
 * @author erikmiller
 * @version 1.0
 */

/**
 * @author erikmiller
 *
 */
public class AddressListTest {

	public static AddressList addresses;
	public static final String[][] records = new String[][]{
		{
			"John Doe", "555-555-5555", "jdoe@email.com", "123 Main St. Christiansburg, VA 24073", "1987-02-04"
		},
		{
			"Jane Doe", "555-555-5444", "jane.doe@email.com", "222 Main St. Christiansburg, VA 24073", "1987-02-05"
		},
		{
			"Matt Doe", "555-555-5333", "mattd@email.com", "345 Main St. Christiansburg, VA 24073", "1987-02-06"
		}
	};
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		addresses = new AddressList();
	}

	/**
	 * Test method for {@link AddressList#AddressList()}.
	 */
	@Test
	public void testAddressList() {
		assertTrue(addresses != null);
	}

	/**
	 * Test method for {@link AddressList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(addresses.isEmpty());
		// TODO add test for when one of the add to methods are working
		//addresses.addToFront(name, tel, email, address, dob);
		//assertFalse(addresses.isEmpty());
	}

	/**
	 * Test method for {@link AddressList#addToFront(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddToFront() {
		addresses.addToFront(
				"John Doe", 
				"555-555-5555", 
				"jdoe@email.com", 
				"123 Main St. Christiansburg, VA 24073", 
				"1987-02-04"
		);
		assertFalse(addresses.isEmpty());
		addresses.addToFront(
				"Jane Doe", 
				"555-555-5444", 
				"jane.doe@email.com", 
				"222 Main St. Christiansburg, VA 24073", 
				"1987-02-05"
		);
		assertTrue(addresses.nameByPhoneNumber("555-555-5444").equals("Jane Doe"));
	}

	/**
	 * Test method for {@link AddressList#addToBack(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddToBack() {
		addresses.addToFront(
				"John Doe", 
				"555-555-5555", 
				"jdoe@email.com", 
				"123 Main St. Christiansburg, VA 24073", 
				"1987-02-04"
		);
		addresses.addToBack(
				"Jane Doe", 
				"555-555-5444", 
				"jane.doe@email.com", 
				"222 Main St. Christiansburg, VA 24073", 
				"1987-02-05"
		);
		addresses.addToBack(
				"Matt Doe", 
				"555-555-5333", 
				"mattd@email.com", 
				"333 Main St. Christiansburg, VA 24073", 
				"1987-02-06"
		);
		assertFalse(addresses.isEmpty());
		assertTrue(addresses.nameByPhoneNumber("555-555-5333").equals("Matt Doe"));
	}

	/**
	 * Test method for {@link AddressList#reverseToString()}.
	 */
	@Test
	public void testReverseToString() {
		String expected = 
				"---------------------------\n"
			  + "Matt Doe\n"
			  + "555-555-5333\n"
			  + "mattd@email.com\n"
			  + "345 Main St. Christiansburg, VA 24073\n"
			  + "1987-02-06\n"
			  + "---------------------------\n"
			  + "---------------------------\n"
			  + "Jane Doe\n"
			  + "555-555-5444\n"
			  + "jane.doe@email.com\n"
			  + "222 Main St. Christiansburg, VA 24073\n"
			  + "1987-02-05\n"
			  + "---------------------------\n"
			  + "---------------------------\n"
			  + "John Doe\n"
			  + "555-555-5555\n"
			  + "jdoe@email.com\n"
			  + "123 Main St. Christiansburg, VA 24073\n"
			  + "1987-02-04\n"
			  + "---------------------------\n";
		for(String[] record : records){
			addresses.addToBack(record[0], record[1], record[2], record[3], record[4]);
		}
		assertEquals(expected, addresses.reverseToString());
	}

	@Test
	public void testReverseToStringOneRecord(){
		
		addresses.addToBack(
				"John Doe", 
				"555-555-5555", 
				"jdoe@email.com", 
				"123 Main St. Christiansburg, VA 24073", 
				"1987-02-04"
		);
		
		String expected = 
				"---------------------------\n"
			  + "John Doe\n"
			  + "555-555-5555\n"
			  + "jdoe@email.com\n"
			  + "123 Main St. Christiansburg, VA 24073\n"
			  + "1987-02-04\n"
			  + "---------------------------\n";
		assertEquals(expected, addresses.reverseToString());
	}
	
	@Test
	public void testReverseToStringZeroRecords(){
		assertEquals("", addresses.reverseToString());
	}

	/**
	 * Test method for {@link AddressList#reverse()}.
	 */
	@Test
	public void testReverse() {
		for(String[] record : records){
			addresses.addToBack(record[0], record[1], record[2], record[3], record[4]);
		}
		addresses.reverse();
		fail("testReverse");
//		assertEquals(addresses.toString(), addresses.reverseToString());
	}

	/**
	 * Test method for {@link AddressList#sizeOf()}.
	 */
	@Test
	public void testSizeOf() {
		for(String[] record : records){
			addresses.addToBack(record[0], record[1], record[2], record[3], record[4]);
		}
		assertTrue(addresses.sizeOf() == 3);
		addresses.addToBack(
				"Mike Doe", 
				"555-555-2222", 
				"mdoe3@email.com", 
				"666 Main St. Christiansburg, VA 24073", 
				"1987-02-07"
		);
		assertTrue(addresses.sizeOf() == 4);
		

	}
	
	@Test
	public void testSizeOfOne(){
		
		AddressList adds = new AddressList();
		adds.addToFront(
				"Mike Doe", 
				"555-555-2222", 
				"mdoe3@email.com", 
				"666 Main St. Christiansburg, VA 24073", 
				"1987-02-07"
		);
		assertTrue(adds.sizeOf() == 1);

	}

	@Test
	public void testSizeOfZero(){
		
		assertTrue(addresses.sizeOf() == 0);

	}

	/**
	 * Test method for {@link AddressList#phoneNumberByName(java.lang.String)}.
	 */
	@Test
	public void testPhoneNumberByName() {
		for(String[] record : records){
			addresses.addToBack(record[0], record[1], record[2], record[3], record[4]);
		}
		String expected = "555-555-5555";
		assertEquals(expected, addresses.phoneNumberByName("John Doe"));
		expected = "Record not found";
		assertEquals(expected, addresses.phoneNumberByName("Jimmy Doe"));
	}

	/**
	 * Test method for {@link AddressList#emailByName(java.lang.String)}.
	 */
	@Test
	public void testEmailByName() {
		for(String[] record : records){
			addresses.addToBack(record[0], record[1], record[2], record[3], record[4]);
		}
		String expected = "jane.doe@email.com";
		assertEquals(expected, addresses.emailByName("Jane Doe"));
		addresses.addToBack(
				"Jane Doe", 
				"555-555-5444", 
				"jane.doe@email.com", 
				"222 Main St. Christiansburg, VA 24073", 
				"1987-02-05"
		);
		assertEquals(expected, addresses.emailByName("Jane Doe"));
		expected = "Record not found";
		assertEquals(expected, addresses.emailByName("Jimmy Doe"));
	}

	/**
	 * Test method for {@link AddressList#nameByPhoneNumber(java.lang.String)}.
	 */
	@Test
	public void testNameByPhoneNumber() {
		for(String[] record : records){
			addresses.addToBack(record[0], record[1], record[2], record[3], record[4]);
		}
		String expected = "Matt Doe";
		assertEquals(expected, addresses.nameByPhoneNumber("555-555-5333"));
		expected = "Record not found";
		assertEquals(expected, addresses.emailByName("Jimmy Doe"));
	}

	/**
	 * Test method for {@link AddressList#dobByName(java.lang.String)}.
	 */
	@Test
	public void testDobByName() {
		for(String[] record : records){
			addresses.addToBack(record[0], record[1], record[2], record[3], record[4]);
		}
		String expected = "1987-02-04";
		assertEquals(expected, addresses.dobByName("John Doe"));
		expected = "Record not found";
		assertEquals(expected, addresses.emailByName("Jimmy Doe"));
	}
	
	/**
	 * Test method for {@link AddressList#toString(java.lang.String)}.
	 */
	@Test
	public void testToString() {
		String expected = 
				"---------------------------\n"
			  + "John Doe\n"
			  + "555-555-5555\n"
			  + "jdoe@email.com\n"
			  + "123 Main St. Christiansburg, VA 24073\n"
			  + "1987-02-04\n"
			  + "---------------------------\n"
			  + "---------------------------\n"
			  + "Jane Doe\n"
			  + "555-555-5444\n"
			  + "jane.doe@email.com\n"
			  + "222 Main St. Christiansburg, VA 24073\n"
			  + "1987-02-05\n"
			  + "---------------------------\n"
			  + "---------------------------\n"
			  + "Matt Doe\n"
			  + "555-555-5333\n"
			  + "mattd@email.com\n"
			  + "345 Main St. Christiansburg, VA 24073\n"
			  + "1987-02-06\n"
			  + "---------------------------\n";
		for(String[] record : records){
			addresses.addToBack(record[0], record[1], record[2], record[3], record[4]);
		}
		assertEquals(expected, addresses.toString());
	}

	@Test
	public void testToStringOneRecord(){
		
		addresses.addToBack(
				"John Doe", 
				"555-555-5555", 
				"jdoe@email.com", 
				"123 Main St. Christiansburg, VA 24073", 
				"1987-02-04"
		);
		
		String expected = 
				"---------------------------\n"
			  + "John Doe\n"
			  + "555-555-5555\n"
			  + "jdoe@email.com\n"
			  + "123 Main St. Christiansburg, VA 24073\n"
			  + "1987-02-04\n"
			  + "---------------------------\n";
		assertEquals(expected, addresses.toString());
	}

	@Test
	public void testToStringZeroRecords(){
		assertEquals("", addresses.toString());
	}

}
