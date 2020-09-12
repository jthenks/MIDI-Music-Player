

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

/**
 * *IMPORTANT*: This class was not written by me. For this assignment, this class was
 * written and provided to us by professor Tyson Kendon. 
 * 
 * @author- Tyson Kendon
 * 
 * <p>Container to encapsulate all of the somewhat messy parts of the
 * JavaSound system. It provides a fairly clean interface to let you
 * add and play notes using the MIDI sequencer.</p> 
 * 
 * <p>MIDI has two tools, one is the sequencer and one is the synthesizer.
 * The synthesizer allows you to modify various waves to produce sounds,
 * and is beyond what we need here. The sequencer is based around a 
 * series of messages telling it what to do.</p>
 * 
 * <p>This class wraps contains all of the messages, and adds new
 * messages only when asked by the methods.</p>
 * 
 * <p><b>NOTE</b>: Currently the class cannot stop playing notes even after
 * it has finished playing all messages, so you must manually stop
 * the program running after playing.
 *  - If possible a less broken version 2 will be distributed when
 *  there's a moment.</p>
 * 
 * 
 */
public class MIDISequencePlayer {
	
	/**
	 * Object that will actually play the music.
	 */
	private Sequencer sequencer;
	
	/**
	 * Object that holds the messages the sequencer will receive.
	 */
	private Sequence sequence;
	
	/**
	 * Actual sequence of messages
	 */
	private Track track;
	
	/**
	 * 
	 * Creates a new MIDISequencePlayer with the given instrument.
	 * 
	 * <p>The instrument is set using the sequencer's internal system.
	 * You *should* have around 128 instruments organized according
	 * to this logic: 
	 * <a href="https://www.midi.org/specifications-old/item/gm-level-1-sound-set">midi.org</a>
	 * </p>
	 * 
	 * <p>I quite like 14 or 15.</p>
	 * 
	 * <p>The beats per minute (bpm) cover how fast the music should be
	 * played. A value between 100 and 200 is probably good.</p>
	 * 
	 * @param instrument the midi number for the instrument to be played
	 * @param beatsPerMinute how quickly the instrument should play
	 * @throws MidiUnavailableException 
	 * @throws InvalidMidiDataException 
	 */
	public MIDISequencePlayer(int instrument, int beatsPerMinute) throws MidiUnavailableException, InvalidMidiDataException {
		
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			sequence = new Sequence(Sequence.PPQ, 4);
			sequencer.setTempoInBPM(beatsPerMinute);
			track = sequence.createTrack();
			track.add(new MidiEvent(new ShortMessage(
					ShortMessage.PROGRAM_CHANGE, 1, instrument, 0), 0));
			
			 			
		
		
	}
	
	/**
	 * 
	 * Adds a note to the sequencers track.
	 * 
	 * <p>The note comes in two parts a start and a stop, and this method
	 * adds both messages to the system.</p>
	 * 
	 * @param midiKey the key or pitch to play at
	 * @param velocity how hard to play (100 is good)
	 * @param time the beat to start playing on
	 * @param length how many beats to play for
	 * @throws InvalidMidiDataException 
	 */
	public void addNote(int midiKey, int velocity, int time, int length) throws InvalidMidiDataException {
		
		ShortMessage start = new ShortMessage();
		ShortMessage stop = new ShortMessage();
		
			
			start.setMessage(ShortMessage.NOTE_ON, 1, midiKey, velocity);
			stop.setMessage(ShortMessage.NOTE_OFF, 1, midiKey, velocity);

			track.add(new MidiEvent(start, time));
			track.add(new MidiEvent(stop, time + length));
			
		
		
	}
	
	/**
	 * 
	 * Sets the current notes added to the sequencer and starts it
	 * playing.
	 * 
	 * NOTE: It is not able to stop playing at the moment so you
	 * must shut down the program manually.
	 * @throws InvalidMidiDataException 
	 * 
	 */
	public void play() throws InvalidMidiDataException {
		
			 
			sequencer.setSequence(sequence);
			
			sequencer.start();
			
			
			
				
	}
	
	/**
	 * 
	 * Stops the SequencePlayer midway through the playback.
	 * 
	 * NOTE: No it doesn't.
	 * 
	 */
	public void stop() {
		sequencer.stop();
	}

	/**
	 * 
	 * Turns the SequncePlayer off and closes all of its resources.
	 * 
	 * NOTE: Not it doesn't.
	 * 
	 */
	public void shutDown() {
		sequencer.close();
	}
	
}
