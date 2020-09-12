import java.util.ArrayList;

/**
 * This class extends instrument. It reads the music sheet stored in instrument, and overrides the play method to 
 * print the music sheet to easily readable text.
 * @author Jordan
 *
 */
public class TextPrintInstrument extends Instrument {
	
	/**
	 * This method loops through the music until the time that the last note is to be played. During each loop, the program
	 * prints the current beat(time), and prints all notes that are to be played at that time using another loop.
	 */
	public void play() {
		
		int endLoop=music.lastTime();
		char type;
		
		for(int i = 1; i <= endLoop; i++) {
			
			System.out.println("Beat "+ i);
			
			if(music.hasNotesAt(i)) {
				ArrayList<Note> notes = music.getNotesAt(i);
				
				for(Note n : notes) {
					
					System.out.println("\t" + n.toString());
				}
			}
		
		}
		
	}

}
