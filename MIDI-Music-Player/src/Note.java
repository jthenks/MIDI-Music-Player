/**
 * This class is an abstract superclass, when a subclass of note is created, they take in an
 *  int key, the key that the note is to be played at. This class has a getKey method which returns the key
 *  and a getDuration and toString methods which will be overridden. 
 * @author Jordan
 *
 */
public abstract class Note {
	
	private int key;
	
	/**
	 * Constructor. 
	 * @param key Takes in the musical key of the note to be played. 
	 */
	public Note(int key){
		this.key=key;
	}

	/**
	 * getter method, returns the musical key of the note
	 * @return
	 */
	public int getKey() {
		return key;
	}
	
	/**
	 * abstract method, overridden by each sub class. 
	 * @return the duration the note is to be played
	 */
	public abstract int getDuration();
	
	
	/**
	 * helper method, overridden by each sub class. Puts the duration and key to string to easily be printed. 
	 */
	public abstract String toString();
}
