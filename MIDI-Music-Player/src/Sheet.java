import java.util.*;
import java.io.*;

/**
 * This class reads the information off of a file, interprets it, then ads it all to a map. The map stores items by 
 * date (the key) and ArrayList, the body. The arraylist stores a list of all notes that are to be played during that time.
 * It also has methods that return if there are any notes to be played at a time, and which notes those are.
 * One method also tells us the last time that any note is played at, so that we know when to stop the instruments.
 * @author Jordan 
 *
 */
public class Sheet {

	Map<Integer, ArrayList<Note>> map;


	/**
	 * Constructor, takes in a filename in the form of a string. Reads the file, or gives an error message. It creates
	 * a map to store time, and an arrayList of Notes. It then creates 
	 * Note objects, and calls the addnote method to add these notes to the arraylists in the map. 
	 * @param fileName String - the name of the file the user wishes to play music from
	 */
	public Sheet(String fileName) {
		map = new HashMap<Integer, ArrayList<Note>>();

		/**
		 * Constructor method. It searches for a file of the name the user inputted, if not found, it gives an error message.
		 * this method uses a loop to go through the file, creates notes based on the char type, and adds notes to the map
		 * at the proper time (determined by the file).
		 */
		File inFile=new File(fileName);
		try(Scanner in = new Scanner(inFile)) {

			while(in.hasNext()) {
				int time=in.nextInt();
				String sType=in.next();
				char type=sType.charAt(0);
				int key= in.nextInt();
				Note tempNote = null;

				if(type=='Q') {
					tempNote = new QuarterNote(key);
				}
				else if(type=='H') {
					tempNote = new HalfNote(key);
				}
				else if(type=='W') {
					tempNote = new WholeNote(key);
				}
				else if(type=='E') {
					tempNote = new EighthNote(key);
				}
				else {
					System.out.println("Invalid type found on file");
				}
				addNote(time, tempNote);

			}

		}
		catch (FileNotFoundException e) {
			System.out.println("Error, file not found.");
		}


	}

	/**
	 * This method adds the note to the ArrayList that is connected to the specified time. 
	 * if no ArrayList exists yet, meaning this is the first note to be played at that time,
	 * this method creates an ArrayList and adds the note to it. 
	 * @param time - int: this is the time the note is to be linked with (played at) in the map.
	 * @param note - Note: This is the note that we created in the constructor.
	 */
	public void addNote(int time, Note note) {

		if(map.get(time) == null) {
			map.put(time, new ArrayList<Note>());
		}

		map.get(time).add(note);

	}

	/**
	 * This method uses a for each loop to scan the Map and determine what is the highest value of 
	 * time that a note is to played at. 
	 * @return int lastTime: returns the last time a note is to be played. 
	 */
	public int lastTime() {
		int lastTime = 0;

		for(int i: map.keySet()) {

			if(i>lastTime) {
				lastTime=i;
			}
		}
		return lastTime;
	}

	/**
	 * This method tells us if there are any Notes at a given time by searching the map. If the time is not found, 
	 * it means it has not been added to the map and therefore there are no notes at that time.
	 * @param time - int: This is the time that is to be checked for notes.
	 * @return boolean hasNotes: returns true if there are notes at the time, or false if not. 
	 */
	public boolean hasNotesAt(int time) {
		boolean hasNotes=true;

		if(map.get(time) == null) {
			hasNotes=false;
		}

		return hasNotes;
	}


	/**
	 * This method takes in a time, and returns a list of all notes that are to be played at that time.
	 * if there are no notes at that time, it gives an error message and returns null
	 * @param time - the time to be checked for all associated notes.
	 * @return ArrayList notes: returns a list of all notes to be played, or null if there are none.
	 */
	public ArrayList<Note> getNotesAt(int time){

		ArrayList<Note> notes;
		try {
			notes = map.get(time);
		}
		catch(NullPointerException e) {
			System.out.println("Invalid, no notes exist at this time");
			notes = null;
		}
		return notes;
	}

	/**
	 * getter method, for testing purposes
	 * @return the private map which contains the time that each note is to be played and an ArrayList of all 
	 * notes to be played.
	 */
	public Map<Integer, ArrayList<Note>> getMap() {
		return map;

	}

}
