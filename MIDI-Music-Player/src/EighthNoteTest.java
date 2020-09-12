import static org.junit.Assert.*;

import org.junit.Test;

/*
 * This class tests the EighthNote class to ensure all of its methods are working properly.
 */
public class EighthNoteTest {


	/**
	 * Tests to make sure the superclass and subclass constructors are properly communicating.
	 * ie: we can get the expected key from the superclass after creating a subclass object.
	 */
	@Test
	public void testConstructor() {
		int expectedKey = 15;
		
		Note testKey = new HalfNote(15);
		
		int actualKey = testKey.getKey();
		
		assertEquals(expectedKey, actualKey);
	}
	
	/**
	 * Tests to make sure the final variable getDuration is able to be accessed correctly
	 */
	@Test
	public void testGetDuration() {
		int expectedDuration = 2;
		
		Note testDuration = new EighthNote(15);
		
		int actualDuration = testDuration.getDuration();
		
		assertEquals(expectedDuration, actualDuration);
	}
	
	/**
	 * Tests to make sure the toString method properly relays the correct information as a string
	 */@Test
	 public void testToString() {
		 String expected = "E 15";
		 
		 Note testString = new EighthNote(15);
		 
		 String actualString = testString.toString();
		 
		 assertEquals(expected, actualString);
	 }

}