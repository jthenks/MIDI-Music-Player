/**
 * This class is a superclass of instruments. It takes in and holds sheet music. It also has an abstract method 
 * play which plays the music. 
 * @author Jordan
 *
 */
public abstract class Instrument {
	
	protected Sheet music;
	
	/**
	 * This method takes in and stores a sheet of music.
	 * @param music- the sheet of music
	 */
	public void loadMusic(Sheet music) {
		this.music=music;
	}
	
	/**
	 * abstract method, this method plays the music in whichever format the subclass uses.
	 */
	public abstract void play();

}
