# Assignment 2

In this assignment you will build a ["Player Piano"](https://en.wikipedia.org/wiki/Player_piano) or self playing piano. 

Your piano will use the Java Sound system, which is a MIDI sequencers.

This assignment is intended to give you experience working with inheritance hierarchies and exception handling in Java, as well as reading and modifying code. 

## The Project

Your piano will read in music files and play those files back through an instrument.

You will have to create an instrument super class and two subclasses, one which plays notes through the MIDI system and one which simply prints the playback information to the console.

The music will be structured as a sequence of notes, notes will be represented by their own class, with each note representing a length of time it is played (a 'whole' note, a 'half' note, a 'quarter' note). Inside your program you will use a Map, to keep track of how long notes play. Notes are measured in terms of beats and so for our purposes, a whole note will play for 16 beats, a half note for 8 beats and a quarter note for 4 beats.

Each individual note should take a MIDI key value which is analogous to a key on a keyboard (here's a [translation](https://www.inspiredacoustics.com/en/MIDI_note_numbers_and_center_frequencies)).

You will read in musical data formatted as follows

```
1 Q 64
3 Q 68
4 Q 71
8 H 60
16 W 67
20 Q 64
20 Q 68
20 Q 72
```

Each line is a particular note defined by, the time it is to be played, the type and the key.

The type is mapped 'W' for whole note, 'H' for half note and 'Q' for quarter note.

Note that chords are possible with several notes playing at the same time.

... The music above sounds pretty bad. We'll try to put together some less awful examples later, but this covers all of the aspects. Additionally choosing instrument 14 "Tubular Bells" should help make things sound a little better.



## Putting Classes Together

You have been provided with a `MIDISequencePlayer` class which encapsulates the basic information and tools needed for the Java Music System. You will need to interact with it in three ways:
* Constructor - the constructor for the player requires two ints, one indicates which instrument to play (which should be a value less than 148 and one which indicates a "beats per minute" which indicates how fast should play. (values should probably be in the low hundreds).
* `addNote` - the addNote method adds a note to the player. The method needs to know which key to play (see the MIDI numbers reference above), how hard to play it (this is called the velocity and 100 seems to be an acceptable value), when to start playing it and how long to play it for.
* `play` - plays back all of the notes added at the times they were supposed to be played.

You will have to write three instrument classes:
* a super class, `Instrument` which is responsible for:
   * loading music through a `loadMusic(Sheet music)` method.
   * providing an abstract method `play()` which the subclasses will implement to play the music.
* a subclass for text output, `TextPrintInstrument` which overrides:
   * `play()` so that it prints out all of the times from the beginning to end of the music with which notes are to be played and when.
* a subclass for MIDI output, `MIDIInstrument` which overrides:
   * `play()` so that it plays out the music using the `MIDISequencePlayer`
   
You will need a `Sheet` class to contain the sheet music. This class needs to manage the times at which notes get played as well as which notes get played (like sheet music). My solution involved using a Map matching beat time (Integer) with an ArrayList of notes to be played, but you could also choose a 2D ArrayList or Array (we skipped over talking about that in lecture, I was planning to catch it in a later tutorial). It will need the following methods:
* A constructor which takes a file name and loads a set of notes into the `Sheet` from the file.
* `void addNote(int time, Note note)` which adds the note at the specified beat
* `int lastTime()` which returns the last time any note is played at (You'll want this for the instruments to see how long you need to loop)
* `boolean hasNotesAt(int time)` indicates for a given beat if there are notes to be played then
* `ArrayList<Note> getNotesAt(int time)` returns all of the notes to be played on a given beat

You will also need a `Note` class to fill the `Sheet`. We could probably just use a single note class, but we will actually create 4 using another inheritance hierarchy. So a Note could be a WholeNote, HalfNote or QuarterNote.

* The `Note` superclass needs to take and return key (for pitch see the translation above). It should also have an abstract method `getDuration` which will return how long the note should play. For each subclass it should be overridden:
   * `WholeNote` returns 16.
   * `HalfNote` returns 8.
   * `QuarterNote` returns 4.
* You will probably want a helper method which translates the written music in the file useful note information. 

Finally you will need a main class which can prompt for the file name and player type, load it and play it back.

## Exception Handling

The MIDISequencePlayer throws a number of exceptions from the underlaying MIDI system. You must handle these appropriately with try-catch blocks. You must similarly be prepared to handle exceptions coming from the file reading system.

We expect to see try catch blocks and helpful error messages.

## Testing

Testing should focus around your `Sheet` and `Note` classes. JUnit tests should probably include:

* Begin with tests to ensure that you can store different keys in different notes.
* Then test the subclasses all return the correct duration.
* Then you can test if you can store and retrieve notes from the sheet, does the `hasNotesAt` method work, does the `getNotesAt`

I would not bother to test the instrument side, the text is a little difficult and testing the MIDI output would be a serious undertaking.

## Documentation

For each of your classes and each of your *public* methods, you should include JavaDoc to document the module. 

For each class you should provide:
* A one sentence description of what the class is for
* A follow up (if necessary) for how the class should be used 
   * It is not very necessary for the `Note` class because it has very little internal state to worry about
   * It will be necessary for the `MIDIInstrument` class because the class is more complicated
* Any notes on problems or bugs with the class (See the `MIDISequencePlayer`).

For each method you should provide:
* A one sentence description of what the method is for
* A follow up (if necessary) for how the method should be used (again this will vary by method)
* Any notes on problems or bugs with the method
* A list of all of the parameters for the method (use the @param tag) explaining what each is for
* A description of any value returned by the method



## Grading

Your overall grade will be based on the functionality of the system. This will be adjusted by the quality of the code you write, the design of your classes and their relationships, the quality and coverage of your tests, and the quality of your documentation. The adjustments can move your grade up or down by up to one whole letter grade.

_All work done in this course must be your own:_

- It is acceptable to discuss the problems and algorithms to solve the problems.
- It is also acceptable to look up potential solutions from the Internet.
- It is **not** acceptable to copy code from another student in the class, or from sources on the Internet. When you are incorporating elements that are not your original ideas, you must reconstruct them. Additionally, you should cite where the idea is from.

This means that, for example. if you look up an algorithm on how to shuffle a deck (not that you should need to), you need to rewrite the entirety of the code yourself. This should include both your own stylistic choices and your own understanding of the algorithm. Copying and pasting the algorithm and changing the variable names does not count as reconstruction.

### Grading Guidelines

A system would receive a grade of **F** if:

- it cannot be compiled, or
- it compiles, but does not have enough functionality to give it a higher grade.

A system would receive a grade of **D** if:

- it has some functionality for loading music

A system would receive a grade of **C** if:

- it has some functionality for loading music and can print music playback out

A system would receive a grade of **B** if:

- it loads music properly, using Whole, Half and Quarter notes and can print music playback out

A system would receive a grade of **A** if:

- it loads music properly, using Whole, Half and Quarter notes and can play music through the `MIDISequenceDevice`

### Grading Adjustments

Each adjustment can move a grade up or down by a grade step. _For example, a B would become a B+, a B+ would become an A-._

#### For code quality:

- Good code quality will include:
  - Very few code style problems identified by our linter tools.
  - Well (and meaningfully) named classes, methods and variables.
  - Clear and to the point classes, methods and loops.
  - Line lengths limited to 80 chars.
- Poor code quality will include:
  - Many code style problems identified by our linter tools.
  - Poor or confusingly named classes, methods and variables.
  - Convoluted classes, methods and loops.
  - Long, difficult to read lines of code.

#### For class design:

- Good design will include:
  - High-cohesion classes and methods (each class and method should do 1 thing and 1 thing well).
  - Loose coupling between classes (classes should only share the minimum amount of information between themselves).
- Poor design will include:
  - Low-cohesion classes and methods (doing many different things).
  - Tight coupling between classes (classes sharing a lot of information and/or classes controlling other classes).

#### For testing:

- Good testing will include:
  - Tests covering important behaviours for important methods (the methods doing the actual work and calculations).
  - Clearly written tests, with expected output, set up, execution of actual output and comparison easy to see.
  - Testing must include all testable methods from your own code, but also from the `Card`, `CardHand` and `Deck` class.
    - Testing user input can be difficult, so consider that when structuring your classes.
- Poor testing will include:
  - Few tests covering important behaviours for important methods.
  - Poorly written tests.
  - Tests focused on unnecessary aspects of the system.

#### For documentation:

- Good documentation includes:
  - Meaningful JavaDoc documentation for every class and method which includes:
    - An explanation of the purpose of the module.
    - An explanation of the parameters of each method.
    - An explanation of the return value of each method.
- Poor documentation includes:
  - Missing or meaningless JavaDoc documentation.

### Bonus
- We are interested to see what additions you can make to the system. You should focus on the primary expectations above, but if you find you have extra time and want to do something interesting please do. We will consider all interesting additions to the player piano for a bonus to grade (at our discretion).



**NB:** Special thanks to Dr Tyson for preparing this assignment.
