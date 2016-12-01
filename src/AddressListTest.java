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
	}

	/**
	 * Test method for {@link AddressList#addToFront(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddToFront() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link AddressList#addToBack(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddToBack() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link AddressList#reverseToString()}.
	 */
	@Test
	public void testReverseToString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link AddressList#reverse()}.
	 */
	@Test
	public void testReverse() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link AddressList#sizeOf()}.
	 */
	@Test
	public void testSizeOf() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link AddressList#phoneNumberByName(java.lang.String)}.
	 */
	@Test
	public void testPhoneNumberByName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link AddressList#emailByName(java.lang.String)}.
	 */
	@Test
	public void testEmailByName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link AddressList#nameByPhoneNumber(java.lang.String)}.
	 */
	@Test
	public void testNameByPhoneNumber() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link AddressList#dobByName(java.lang.String)}.
	 */
	@Test
	public void testDobByName() {
		fail("Not yet implemented");
	}

}
