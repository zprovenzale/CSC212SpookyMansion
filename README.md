# CSC212P4 (Lab & Option for P5)

SpookyMansion and other Interactive Fiction to explore using and understanding Graphs.

## About TA Support:
There are no TA hours this Sunday, Monday or Tuesday, so this assignment will be more on-your-own (with support primarily done via Piazza). However, we've been spending recent classes discussing Java vocabulary, so internet resources like StackOverflow are going to be more and more useful to you.

## Learning Objectives
The learning objectives of this assignment are:
 - To continue practicing using Maps with Java.
 - To gain an understanding of Graphs.
 

```
You are in the grand entrance hall of a large building.
The front door is locked. How did you get here?
 - There are stairs leading down.
 - There are stairs leading up.
 - There is a red door.
> up
Something rustles in the rafters as you enter the attic. Creepy.
It's big up here.
 - There are stairs leading down.
 - There is more through an archway
> 
```

# Lab Challenges

## (Lab) Play SpookyMansion and Draw a "graph" for yourself
 - Import the starter code. (Don't forget the Maven step).
 - Play SpookyMansion, and sketch out the "game" on paper.
 - Finish the game by finding the "Crypt" place.
 - Include a scan (or clear cellphone photo) of your graph in your writeup.
 
## (Lab) Get a handle on the SpookyMansion Code
 - Add an Exit from the ``secretRoom`` to the ``basement`` (but not in the other direction).
 - Make the very long hallway even longer.
 - Modify the very long hallway messages to include a number scratched on the wall, so that players can tell how far they've come.
 - Add another room in the Attic and off of the Basement.
 - Note on your "map" the changes you've made to the game's "Graph".

## (Lab) Get a sense of the InteractiveFiction Code
 - Find the code in ``InteractiveFiction`` that handles quitting the game.
 - Allow users to quit with the word "escape" or just the letter "q".

## (Lab) Design your own version of FordHall
 - (8) Sketch out a graph of your FordHall game (include exits). Decide which room lets you "win".
     - Ford Hall has 3 floors, my office (256), our lab classroom (34?), and our lecture hall (240).
 - (12) create a FordHall class and implement your Places and Exits.

# Challenges for P5:

Remember that P5 will be due ***Due Date***: October 18, 2018.

Remember that we will have the Midterm opening on that day, so don't save it until the last minute!

## Reflection (=20)

As we will discuss in class, we will now be writing reflections for our programming assignments. This can be done in any software you like, provided you upload a PDF to moodle in addition to the zip file for the code.

Your reflection should identify any partners you worked with in Lab

I expect you to take notes as you do the assignment and turn in at least 10 bullet points for this reflection. They can be distributed across the two following categories as you wish.

### Lessons Learned

List things you learned or became more comfortable with with respect to data structures and Java. You may learn from the assignment directly, or perhaps from a particular Piazza post (even if it wasn't your question!)

### Challenges Remaining

List things that still challenge your understanding of data structures and Java.

## Program Compiles (=20)
This includes that your code should be professional. 
- Try to proofread your work like an essay! 
- Find all your ``println("stuff")`` statements and remove them, etc.
- Your code looks intentional: don't just fiddle with it until it works. Reason about it! Sketch out the python by hand and then try translating to Java.
- Delete commented out code or experiments that don't work out. Make your submission as small as it needs to be.
- Your code is your own. Respect the honor code.
- Working with others or helping them debug is acceptable - use your best judgment! Make sure that you know what you're working on.

## Commenting Code (only negative points here...)
 - Any methods or class-level variables left without a Javadoc comment (``/** */``) will result in the loss of a point.
 - Have comments explaining tricky code! (My video has my voice as a comment, so try to comment code you found tricky in it).

## Optional Suggested Challenges

### Implement Your Own Game (=24+?)
 - (8) Must have at least 8 Places.
 - (8) Must have at least 8 functional Exits.
 - (4) Must have a terminal place (a way to win the game).
 - (4) Have some one-way paths (the staircase collapses behind you)
 - Be creative?

### Implement SecretExit (=24)
 - (4) Create a class SecretExit that extends Exit.
 - (4) Put a method called "isSecret" on Exit that works for both classes.
 - (4) SecretExit should have a boolean hidden, that starts off as true.
 - (4) Make it so SecretExits are not printed to the user (in ``InteractiveFiction``) when hidden.
 - (4) When a user types "search", if there is a SecretExit in the room they are currently in, it should be made visible to them.
 - (4) Put a SecretExit from the ``basement`` to the ``secretRoom`` in SpookyMansion, so that the dumbwaiter is not the only solution to the game.
 
### Implement Keys and LockedExit (=28 or 12 if you also do SecretExit)
 - (4) Place must have a method that returns a list of items in a location (maybe just String?)
 - (4) There must be an action to ``pick up`` or ``take`` an item.
 - (4) Items are part of the description until they are taken from a Place.
 - (4) The player can no longer be represented by just a location. They need to know what key(s) if any they have.
 - (4 or 20) Implement a LockedExit that can only be chosen with the appropriate Key.
 
### Implement a new game with some other tool or switch or idea (=?)
 - Check with me to make sure it's not too hard :)

### (Reading, Loops) Implement ``chooseFromList`` on TextInput (=24)
  - This one will be very difficult if you don't know how to test it. I suggest putting a ``main`` into ``TextInput`` and trying it separate from the games first.
  - Read how "confirm" works. You can move my word-matching code from ``InteractiveFiction`` into this method.
  - (8) It should take a ``List<String>`` and return an int.
      - My word-matching code works over ``List<Exit>``. Change Exit objects to Strings in this method.
      - Try using ``input.indexOf(choice)`` if you have a String and want to return the index.
  - (6) It should be possible for a user to quit while selecting from a list. Return -1 from this method on quit, and use this "-1" output special in ``InteractiveFiction``.
  - (4) Use it for selecting exits. (Copy descriptions from a ``List<Exit>`` into a ``List<String>``, then find the index).
  - (4) Use it for selecting from your games ``[FordHall, SpookyMansion]`` etc.
