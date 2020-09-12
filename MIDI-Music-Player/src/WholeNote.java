/**
 * This is a subclass of Note, upon creation it takes in a key that the note is to be played at. 
 * It also has a private final int which is the duration that a wholenote should be played for. 
 * It has methods to get the duration and convert the duration and key to string. 
 * @author Jordan
 *
 */

public class WholeNote extends Note {
	private final int DURATION = 16;
	
	/**
	 * constructor method, takes in a key that the note is to be played at. 
	 * @param key
	 */
	public WholeNote(int key) {
		super(key);
	}
	
	/**
	 * getter method, returns the duration that the note is to be played for. 
	 */
	public int getDuration() {
		
		return DURATION;
	}
	
	/**
	 * toString method, returns a string reflecting the duration and key in which the note should be played.
	 */
	public String toString(){
		
		return 'W' + " " + getKey();
		
	}

}
