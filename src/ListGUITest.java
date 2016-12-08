import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ListGUITest {
	
	public static ListGUI gui;

	@Before
	public void setUp() throws Exception {
		gui = new ListGUI(true);
	}

	@Test
	public void testListGUI() {
		assertTrue(gui != null);
	}

	@Test
	public void testAddNewContact() {

		gui.addNewContact(
				"John Doe", 
				"555-555-5555", 
				"jdoe@email.com", 
				"123 Main St. Christiansburg, VA 24073", 
				"1987-02-04"
		);
		assertTrue(1 == gui.getSize());
	}

	@Test
	public void testRetrieveContact() throws Exception{
		gui.addNewContact(
				"John Doe", 
				"555-555-5555", 
				"jdoe@email.com", 
				"123 Main St. Christiansburg, VA 24073", 
				"1987-02-04"
		);
		String value = gui.retrieveContact("555-555-5555", "Name");
		assertEquals(value, "John Doe");
		value = gui.retrieveContact("John Doe", "Phone");
		assertEquals(value, "555-555-5555");
		value = gui.retrieveContact("John Doe", "Email");
		assertEquals(value, "jdoe@email.com");
		value = gui.retrieveContact("John Doe", "Date of Birth");
		assertEquals(value, "1987-02-04");
	}
	
	@Test
	public void testConcat(){
		String expected = "555-555-5555";
		String actual = gui.concat(new String[]{"555", "555", "5555"},  '-');
		assertEquals(expected, actual);
		expected = "555;666";
		actual = gui.concat(new String[]{"555", "666"}, ';');
		assertEquals(expected, actual);
		expected = "555";
		actual = gui.concat(new String[]{"555"}, ';');
		assertEquals(expected, actual);
	}

}
