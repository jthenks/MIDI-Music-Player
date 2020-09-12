import static org.junit.Assert.*;

import org.junit.Test;

/*
 * This class tests the HalfNote class to ensure all of its methods are working properly.
 */
public class HalfNoteTest {


	/**
	 * Tests to make sure the superclass and subclass constructors are properly communicating.
	 * ie: we can get the expected key from the superclass after creating a subclass object.
	 */
	@Test
	public void testConstructor() {
		int expectedKey = 5;
		
		Note testKey = new HalfNote(5);
		
		int actualKey = testKey.getKey();
		
		assertEquals(expectedKey, actualKey);
	}
	
	/**
	 * Tests to make sure the final variable getDuration is able to be accessed correctly
	 */
	@Test
	public void testGetDuration() {
		int expectedDuration = 8;
		
		Note testDuration = new HalfNote(5);
		
		int actualDuration = testDuration.getDuration();
		
		assertEquals(expectedDuration, actualDuration);
	}
	
	/**
	 * Tests to make sure the toString method properly relays the correct information as a string
	 */@Test
	 public void testToString() {
		 String expected = "H 5";
		 
		 Note testString = new HalfNote(5);
		 
		 String actualString = testString.toString();
		 
		 assertEquals(expected, actualString);
	 }

}
