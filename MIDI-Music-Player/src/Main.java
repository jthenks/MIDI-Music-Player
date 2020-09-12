import java.util.*;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

/**
 * I transferred the song "Mary Had A Little Lamb" into the proper format (by ear, it's not perfect)
 * so that it could be played with this program.
 * 
 * This class runs the program. It prompts the user to input the name of a file that has music on it. The file is 
 * then converted to a sheet of music using the Sheet class, and played using whichever instrument class the user chooses.
 * There are exceptions for invalid inputs.  
 * @author Jordan
 *
 */

public class Main {

	public static void main(String[] args) {

		boolean valid = false;
		Scanner kb = new Scanner(System.in);
		Sheet sheet = null;

		while(valid == false) {

			System.out.println("Please enter the file name: ");
			String fileName=kb.nextLine();


			sheet = new Sheet(fileName);


			Instrument text = new TextPrintInstrument(); 
			Instrument midi = new MIDIInstrument();
			text.loadMusic(sheet);
			midi.loadMusic(sheet);



			System.out.println("Please enter your desired player type, 'text', 'MIDI' or 'both': ");
			String pType=kb.nextLine().toLowerCase();

			try {
				switch (pType) {
				case "text":

					text.play();
					valid= true;
					break;

				case "midi": 
					midi.play();
					valid= true;
					break;

				case "both":
					text.play();
					midi.play();
					valid= true;
					break;

				default: 
					System.out.println("Invalid input.");
				}
			}

			catch(NullPointerException n) {
				System.out.println("The program cannot run without a valid file.");
			}



		}
		System.out.println("Thank you for using the program.");
	}
}
