import java.util.ArrayList;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

/**
 * This class reads the music sheet stored in the super class Instrument, and uses the MIDISequencePlayer class to play
 * the "music". 
 * @author Jordan
 *
 */
public class MIDIInstrument extends Instrument {



	//plays out the music using the MIDISequencePlayer
	/**
	 * This method uses the music sheet from the super class, creates a MIDISequencePlayer object, choosing the instrument and 
	 * beats per minute. It then uses a loop to go through all of the notes/time until the last time that there is a note.
	 * It then uses a for each loop to go through the notes and add them to the MIDI object's queue of notes to be played.
	 * It then plays the queue using the MIDI class. This method catches exceptions throughout.
	 */
	public void play() {
		
		int endLoop = music.lastTime();
		MIDISequencePlayer player = null;
		int key = 0;
		int velocity = 100;
		int duration = 0;

		try {
			player = new MIDISequencePlayer(0, 120); //was 5, 120 but this is better
		} 
		catch (MidiUnavailableException e) {
			System.out.println("There was an error in the MIDI system.");
		}

		catch (InvalidMidiDataException e) {
			System.out.println("Invalid data entered.");

		}

		for(int i = 1; i <= endLoop; i++) {

			if(music.hasNotesAt(i)) {
				ArrayList<Note> notes = music.getNotesAt(i);

				for(Note n : notes) {
					key = n.getKey();
					duration = n.getDuration();
					try {
						player.addNote(key, velocity, i, duration);
					}
					catch(InvalidMidiDataException e){
						System.out.println("Invalid data");
					}


				}
			}
		}
		try {
			player.play();
		} 
		catch (InvalidMidiDataException e) {
			System.out.println("Invalid data");
		}

	
	}

}
