import static org.junit.Assert.*;

import org.junit.Test;

public class WholeNoteTest {

	/**
	 * Tests to make sure the superclass and subclass constructors are properly communicating
	 * ie: we can get the expected key from the superclass after creating a subclass object.
	 */
	@Test
	public void testConstructor() {
		int expectedKey = 7;
		
		Note testKey = new WholeNote(7);
		
		int actualKey = testKey.getKey();
		
		assertEquals(expectedKey, actualKey);
	}
	
	/**
	 * Tests to make sure the final variable getDuration is able to be accessed correctly
	 */
	@Test
	public void testGetDuration() {
		int expectedDuration = 16;
		
		Note testDuration = new WholeNote(7);
		
		int actualDuration = testDuration.getDuration();
		
		assertEquals(expectedDuration, actualDuration);
	}
	
	/**
	 * Tests to make sure the toString method properly relays the correct information as a string
	 */@Test
	 public void testToString() {
		 String expected = "W 7";
		 
		 Note testString = new WholeNote(7);
		 
		 String actualString = testString.toString();
		 
		 assertEquals(expected, actualString);
	 }

}
