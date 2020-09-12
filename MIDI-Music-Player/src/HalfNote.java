/**
 * This is a subclass of Note, upon creation it takes in a key that the note is to be played at. 
 * It also has a private final int which is the duration that a halfnote should be played for. 
 * It has methods to get the duration and convert the duration and key to string. 
 * @author Jordan
 *
 */
public class HalfNote extends Note{
	
	private final int DURATION = 8;
	
	
	/**
	 * Constructor method. takes in the key that the note is to be played at. 
	 * @param key - the key the note is to be played at. 
	 */
	public HalfNote(int key) {
		super(key);
	}
	
	/**
	 * getter method. returns the duration the note is to be played (8)
	 */
	public int getDuration() {
		
		return DURATION;
	}
	
	/**
	 * toString method, returns a string which reflects the duration and key. 
	 */
	public String toString(){
		
		return 'H' + " " + getKey();
		
	}
}
