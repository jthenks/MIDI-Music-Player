import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * This class tests the methods of the sheet class to ensure it works properly
 * @author Jordan
 *
 */

public class SheetTest {

	
	//Then you can test if you can store and retrieve notes from the sheet, does the hasNotesAt method work, does the getNotesAt
	
	@Test
	/**
	 * tests the constructor method, ensures the map is being properly created by making sure it is not = null
	 */
	public void testConstructor() {
		
		Map<Integer, ArrayList<Note>> nullMap = new HashMap<>();
		Sheet testSheet = new Sheet("test.music");
		
		assertNotEquals(nullMap, testSheet.getMap());
		
	}
	
	
	/**
	 * tests to see if the hasNotesAt method returns true if there are notes at the specified time
	 */
	@Test
	//testing to make sure there are notes where there should be
	public void testHasNotesAt() {
		boolean expected = true;
		Sheet testSheet = new Sheet("test.music");
		boolean actual = testSheet.hasNotesAt(20);
		assertEquals(expected, actual);
		
		actual = testSheet.hasNotesAt(1);
		assertEquals(expected, actual);
	
		
		
		//tests to make sure there are no notes after all the notes should have finished playing
		expected = false;
		actual = testSheet.hasNotesAt(21);
		assertEquals(expected, actual);
		
		//tests to make sure there are no notes playing where there shouldn't be
		actual = testSheet.hasNotesAt(2);
		assertEquals(expected, actual);
		
		actual = testSheet.hasNotesAt(5);
		assertEquals(expected, actual);
		
		actual = testSheet.hasNotesAt(6);
		assertEquals(expected, actual);
		
		actual = testSheet.hasNotesAt(7);
		assertEquals(expected, actual);
		
		actual = testSheet.hasNotesAt(9);
		assertEquals(expected, actual);
		
		actual = testSheet.hasNotesAt(10);
		assertEquals(expected, actual);
		
		actual = testSheet.hasNotesAt(0);
		assertEquals(expected, actual);
		
		actual = testSheet.hasNotesAt(-1);
		assertEquals(expected, actual);
		
		
	}
	
	/**
	 * Tests to make sure the getNotesAt method properly returns an arrayList of all the notes
	 * that are supposed to be played at a given time. 
	 */
	@Test
	public void testGetNotesAt() {
		//tests time 20
		Note note1 = new QuarterNote(64);
		Note note2 = new QuarterNote(68);
		Note note3 = new QuarterNote(72);
		ArrayList<Note> expected  = new ArrayList<>();
		expected.add(note1);
		expected.add(note2);
		expected.add(note3);
		Sheet testSheet = new Sheet("test.music");
		ArrayList<Note> actual = testSheet.getNotesAt(20);
		assertEquals(expected.toString(), actual.toString());
		
		//tests time 16 
		Note note4 = new WholeNote(67);
		ArrayList<Note> expected2  = new ArrayList<>();
		expected2.add(note4);
		ArrayList<Note> actual2 = testSheet.getNotesAt(16);
		assertEquals(expected2.toString(), actual2.toString());
		
		//tests time 8
		Note note5 = new HalfNote(60);
		ArrayList<Note> expected3  = new ArrayList<>();
		expected3.add(note5);
		ArrayList<Note> actual3 = testSheet.getNotesAt(8);
		assertEquals(expected3.toString(), actual3.toString());
		
		//tests time at 4
		Note note6 = new QuarterNote(71);
		ArrayList<Note> expected4  = new ArrayList<>();
		expected4.add(note6);
		ArrayList<Note> actual4 = testSheet.getNotesAt(4);
		assertEquals(expected4.toString(), actual4.toString());
		
		//tests time at 3
		Note note7 = new QuarterNote(68);
		ArrayList<Note> expected5  = new ArrayList<>();
		expected5.add(note7);
		ArrayList<Note> actual5 = testSheet.getNotesAt(3);
		assertEquals(expected5.toString(), actual5.toString());
		
		//tests time at 1 
		Note note8 = new QuarterNote(64);
		ArrayList<Note> expected6  = new ArrayList<>();
		expected6.add(note8);
		ArrayList<Note> actual6 = testSheet.getNotesAt(1);
		assertEquals(expected6.toString(), actual6.toString());
		
	}
	
	
	/**
	 * method for testing the last time a note is played
	 */
	@Test
	public void testLastTime() {
		
		int expected = 20;
		Sheet testSheet = new Sheet("test.music");
		int actual = testSheet.lastTime();
		assertEquals(expected, actual);
		
		int notExpected = 19;
		assertNotEquals(notExpected, actual);
		
	}
	
	
	
	

}
