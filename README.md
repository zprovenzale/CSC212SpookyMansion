# CSC212P4 SpookyMansion

SpookyMansion and other Interactive Fiction to explore using and understanding Graphs.

## Learning Objectives
The learning objectives of this assignment are:
 - To practice using Maps with Java.
 - To gain an understanding of Graphs.
 

```
You are in the grand entrance hall of a large building.
The front door is locked. How did you get here?
 [0] There are stairs leading down.
 [1] There are stairs leading up.
 [2] There is a red door.
> 1
Something rustles in the rafters as you enter the attic. Creepy.
It's big up here.
 [0] There are stairs leading down.
 [1] There is more through an archway
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
 - Allow users to quit with the word "escape" or just the letter "q". (They will still need to press enter).


# Challenges for P4:

Remember that P4 will be due ***Due Date***: February 21, 2018.

Remember that we will have P4 opening on that day, so don't save it until the last minute!

## Reflection (=20)

As we will discuss in class, we will now be writing reflections for our programming assignments. This can be done in any software you like, provided you upload a PDF to moodle in addition to the zip file for the code.

Your reflection should identify any partners you worked with in Lab

I expect you to take notes as you do the assignment and turn in at least 10 bullet points for this reflection. They can be distributed across the two following categories as you wish.

### Lessons Learned

List things you learned or became more comfortable with with respect to data structures and Java. You may learn from the assignment directly, or perhaps from a particular Piazza post (even if it wasn't your question!)

### Challenges Remaining

List things that still challenge your understanding of data structures and Java.

### Rubric and Reflection (=15)

You must include a PDF file in your submission that identifies the grade you expect on this assignment based on what you completed. 

In addition, you will write 10 statements of either:
 - Accomplishments: things that you understand much better now.
 - Challenges: things that you are still working on understanding.

I will provide direct feedback to your writing.

## Program Compiles (=15)
This includes that your code should be professional. 
- Try to proofread your work like an essay! 
- Find all your ``println("stuff")`` statements and remove them, etc.
- Your code looks intentional: don't just fiddle with it until it works. Reason about it! Sketch out the python by hand and then try translating to Java.
- Delete commented out code or experiments that don't work out. Make your submission as small as it needs to be.
- Your code is your own. Respect the honor code.
- Working with others or helping them debug is acceptable - use your best judgment! Make sure that you know what you're working on.
- Have comments explaining tricky code!

### Commenting Code (only negative points here...)
 - Any methods or class-level variables left without a Javadoc comment (``/** */``) will result in the loss of a point.
 - Have comments explaining tricky code! (My video has my voice as a comment, so try to comment code you found tricky in it).

## Optional Suggested Challenges

### Implement Your Own Game (=16+?)
Consider FordHall, or the Valentine's Challenge.
 - (4) Must have at least 8 Places.
 - (4) Must have at least 8 functional Exits.
 - (4) Must have a terminal place (a way to win the game).
 - (4) Have some one-way paths (the staircase collapses behind you)
 - Be creative?

### Implement SecretExit (=24)
 - (4) Create a class SecretExit that extends Exit.
 - (4) Put a method called "boolean isSecret()" on Exit that works for both classes. Exits are never secret, but SecretExits are until you ``search`` for them.
 - (4) SecretExit should have a private boolean hidden, that starts off as true.
 - (4) Make it so SecretExits are not printed to the user (in ``InteractiveFiction``) when hidden. Change ``Place.getVisibleExits()`` to return only the exits that are not secret.
 - (4) When a user types ``search``, if there is a SecretExit in the room they are currently in, it should be made visible to them. Make a ``void search()`` method on ``Exit`` and ``SecretExit`` that does nothing to ``Exit`` but reveals the ``SecretExit``.
 - (4) Put a SecretExit from the ``basement`` to the ``secretRoom`` in SpookyMansion, so that the dumbwaiter is not the only solution to the game. OR put a SecretExit in your custom game.
 
### Implement Keys and LockedExit (=32 or 16 if you also do SecretExit)
 - (4) Place must have a method that returns a list of items in a location (maybe just ``List<String>``; don't need an item class)
 - (4) There must be an action to ``take`` an item.
 - (4) Items are part of the description until they are taken from a ``Place``. See the ``getDescription`` method. It might be easier to create a new ``void printDescription()``
 - (4) The player can no longer be represented by just a location. They need to know what key(s) if any they have.
 - (4) Make a ``stuff`` command that prints out the users items or "You have nothing."
 - (4 or 20) Implement a ``LockedExit`` that can only be chosen with the appropriate Key.
 
### Create a time system in your game. (=16)
 - (8) Create a class ``GameTime``, that has an ``int hour`` as state, ranging from 0 to 23 (inclusive). Implement ``int getHour()`` and ``void increaseHour()`` and print out the hour like a 12 or 24-hour watch.
 - (4) Extend the game's concept of a player with a current time. Increment the hour every time the player moves. Print out the current time after a room description.
 - (4) Tell the player how many hours they spent in your game upon Game-Over. (Not the current time, so you'll need a new ``int`` on your ``GameTime`` class).

#### Implement Different Place Descriptions for Day and Night (=20)
 - (4) Make an action ``rest`` that advances the game 2 hours so that you can test your descriptions.
 - (4) Implement a boolean method called ``isNightTime()``
 - (4) Add GameTime as a parameter to the ``getDescription`` method on ``Place`` (maybe ``printDescription`` now).
 - (8) Create some places with descriptions based whether GameTime ``isNightTime()`` -- maybe specific Places need to be subclasses with their own custom ``printDescription``!

#### Implement NightExit and DayExit that are only available at a particular time. (=12)
 - (12) Challenge: I'm not breaking this down, shares some work with ``SecretExit``.
 
### Implement a new game with some other tool or switch or idea (=?)
 - Check with me to make sure it's not too hard :)
 
