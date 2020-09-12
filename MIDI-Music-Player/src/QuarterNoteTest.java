import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This method tests the class QuarterNote to ensure that all methods are working properly
 * @author Jordan
 *
 */
public class QuarterNoteTest {

	/**
	 * Tests to make sure the superclass and subclass constructors are properly communicating.
	 * ie: we can get the expected key from the superclass after creating a subclass object.
	 */
	@Test
	public void testConstructor() {
		int expectedKey = 9;
		
		Note testKey = new QuarterNote(9);
		
		int actualKey = testKey.getKey();
		
		assertEquals(expectedKey, actualKey);
	}
	
	/**
	 * Tests to make sure the final variable getDuration is able to be accessed correctly
	 */
	@Test
	public void testGetDuration() {
		int expectedDuration = 4;
		
		Note testDuration = new QuarterNote(9);
		
		int actualDuration = testDuration.getDuration();
		
		assertEquals(expectedDuration, actualDuration);
	}
	
	/**
	 * Tests to make sure the toString method properly relays the correct information as a string
	 */
	@Test
	 public void testToString() {
		 String expected = "Q 9";
		 
		 Note testString = new QuarterNote(9);
		 
		 String actualString = testString.toString();
		 
		 assertEquals(expected, actualString);
	 }

}
