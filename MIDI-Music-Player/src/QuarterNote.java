/**
 * This is a subclass of Note, upon creation it takes in a key that the note is to be played at. 
 * It also has a private final int which is the duration that a quarternote should be played for. 
 * It has methods to get the duration and convert the duration and key to string. 
 * @author Jordan
 *
 */

public class QuarterNote extends Note {
	
	private final int DURATION = 4;
	
	/**
	 * constructor method, takes in the key at which the note is to be played
	 * @param key the key at which the note is to be played. 
	 */
	public QuarterNote(int key) {
		super(key);
	}
	
	/**
	 * getter method, returns the duration that the note is to be played. 
	 */
	public int getDuration() {
		
		return DURATION;
	}
	
	/**
	 * toString method, returns a string reflecting the duration and key in which the note should be played.
	 */
	public String toString(){
		
		return 'Q' + " " + getKey();
		
	}

}
