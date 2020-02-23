package edu.smith.cs.csc212.spooky;

import java.util.List;

/**
 * This is our main class for SpookyMansion.
 * It interacts with a GameWorld and handles user-input.
 * It can play any game, really.
 *
 * @author jfoley
 *
 */
public class InteractiveFiction {

	/**
	 * This method actually plays the game.
	 * @param input - a helper object to ask the user questions.
	 * @param game - the places and exits that make up the game we're playing.
	 * @return where - the place the player finished.
	 */
	static String runGame(TextInput input, GameWorld game) {
		// This is the current location of the player (initialize as start).
		Player player = new Player(game.getStart());

		// Play the game until quitting.
		// This is too hard to express here, so we just use an infinite loop with breaks.
		while (true) {
			// Print the description of where you are.
			Place here = game.getPlace(player.getPlace());
			
			System.out.println();
			System.out.println("... --- ...");
			if(player.hasBeenHereBefore()) {
				System.out.println("This place feels familiar...");
			}
			System.out.println(here.getDescription());
			
			player.rememberThisPlace();

			// Game over after print!
			if (here.isTerminalState()) {
				break;
			}

			// Show a user the ways out of this place.
			List<Exit> exits = here.getVisibleExits();

			for (int i=0; i<exits.size(); i++) {
				Exit e = exits.get(i);
				System.out.println(" "+i+". " + e.getDescription());
			}

			// Figure out what the user wants to do, for now, only "quit" is special.
			List<String> words = input.getUserWords("?");
			if (words.size() > 1) {
				System.out.println("Only give the system 1 word at a time!");
				continue;
			}

			// Get the word they typed as lowercase, and no spaces.
			// Do not uppercase action -- I have lowercased it.
			String action = words.get(0).toLowerCase().trim();

			if (action.equals("quit")) {
				if (input.confirm("Are you sure you want to quit?")) {
					// quit!
					break;
				} else {
					// go to the top of the game loop!
					continue;
				}
			}
			
			//stop game
			if (action.equals("escape") || action.equals("q")) {
				break;
			}
			
			//give a list of stuff
			
			if (action.equals("stuff")) {
				if(player.getStuff().size() > 0) {
					System.out.println(player.getStuff());
				} else {
					System.out.println("You have no stuff");
				}
			}
			
			if (action.equals("take")) {
				if (here.getStuff() != null) {
					player.addStuff(here.getStuff());
				} else {
					System.out.println("There is no list of Stuff!");
				}
			}
			
			if (player.getStuff().contains("Marauders Map")) {
				if (action.equals("search")) {
					here.search();
				}
			}
			
			if (player.getStuff().contains("Broomstick")) {
				here.hasBroom();
			}
			
			if (action.equals("alohomora")) {
				here.unlock();
			}
			
			if (action.equals("help")) {
				System.out.println("Enter 'escape' or 'q' or 'quit' to stop the game.\n"
						+ "Enter 'stuff' to see a list of your stuff."
						+ "Enter 'take' to take stuff from a place");
			}

			// From here on out, what they typed better be a number or a command!
			if (action.equals("help") == false && action.equals("stuff") == false
					&& action.equals("take") == false && action.equals("search") == false
					&& action.equals("alohomora") == false) {

				Integer exitNum = null;
				try {
					exitNum = Integer.parseInt(action);
				} catch (NumberFormatException nfe) {
					System.out.println("That's not something I understand! Try a number!");
					continue;
				}
	
				if (exitNum < 0 || exitNum >= exits.size()) {
					System.out.println("I don't know what to do with that number!");
					continue;
				}
	
				// Move to the room they indicated.
				Exit destination = exits.get(exitNum);
				if (destination.canOpen(player)) {
					player.moveTo(destination.getTarget());
				} else {
					System.out.println("You can't use this exit! if there is a door you need to unlock it\n"
							+ "with a spell, if there's not you need a broom in order to fly!");
				}
				}
			}

		return player.getPlace();
	}

	/**
	 * This is where we play the game.
	 * @param args
	 */
	public static void main(String[] args) {
		// This is a text input source (provides getUserWords() and confirm()).
		TextInput input = TextInput.fromArgs(args);

		// This is the game we're playing.
		//HI REMEMBER ME IM IMPORTANT
		GameWorld game = new Hogwarts();

		// Actually play the game.
		runGame(input, game);

		// You get here by typing "quit" or by reaching a Terminal Place.
		System.out.println("\n\n>>> GAME OVER <<<");
	}

}
