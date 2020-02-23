package edu.smith.cs.csc212.spooky;

import java.util.HashMap;
import java.util.Map;

/**
 * Hogwarts escape to Hogsmeade, the game.
 * @author zprov
 *
 */
public class Hogwarts implements GameWorld {
	private Map<String, Place> places = new HashMap<>();
	
	/**
	 * Where should the player start?
	 */
	@Override
	public String getStart() {
		return "greatHall";
	}
	
	/**
	 * This constructor builds the Hogwarts game.
	 */
	public Hogwarts() {
		Place greatHall = insert(
				Place.create("greatHall", "You are in the Great Hall in Hogwarts\n"
						+ "School of Witchcraft and Wizadry. Your parents did not\n"
						+ "sign your permission form to go to Hogsmeade, find a way\n"
						+ "to sneak out of the castle instead."));
		greatHall.addExit(new Exit("staircase", "There is a big archway"));
		greatHall.addExit(new Exit("smallHall", "There is a small archway"));
		
		Place smallHall = insert(
				Place.create("smallHall", "You are in a relatively small hallway"));
		smallHall.addExit(new Exit("greatHall", "There is an archway"));
		smallHall.addExit(new Exit("roomOfRequirement", "There is a golden door"));
		smallHall.addExit(new Exit("charms", "There is a gray door"));
		
		Place roomOfRequirement = insert(
				Place.create("roomOfRequirement", "You are in the Room of Requirement. What do you need most?"));
		roomOfRequirement.addExit(new Exit("armory", "An armory"));
		roomOfRequirement.addExit(new Exit("broomstick", "A broom cupboard"));
		roomOfRequirement.addExit(new Exit("owlery", "An owlery"));
		roomOfRequirement.addExit(new Exit("bathroom", "A bathroom"));
		roomOfRequirement.addExit(new Exit("hiddenRoom", "The room where everything is hidden"));
		
		Place armory = insert(
				Place.create("armory", "You are in an armory!"));
		armory.addStuff("Sword");
		armory.addStuff("Shield");
		armory.addExit(new Exit("smallHall", "There is a golden door"));
		Place broomstick = insert(
				Place.create("broomstick", "You are in a broom cupboard!"));
		broomstick.addStuff("Broomstick");
		broomstick.addExit(new Exit("smallHall", "There is a golden door"));
		Place owlery = insert(
				Place.create("owlery", "You are in an owlery!"));
		owlery.addStuff("owl");
		owlery.addExit(new Exit("smallHall", "There is a golden door"));
		Place bathroom = insert(
				Place.create("bathroom", "You are in a bathroom!"));
		bathroom.addExit(new Exit("smallHall", "There is a golden door"));
		Place hiddenRoom = insert(
				Place.create("hiddenRoom", "You are in the room where everything is hidden!"));
		hiddenRoom.addStuff("diadem");
		hiddenRoom.addExit(new Exit("smallHall", "There is a golden door"));
		
		Place charms = insert(
				Place.create("charms", "You are in Charms class! Professor Flitwick teaches\n"
						+ "you that the charm 'alohomora' unlocks doors! \n(Type and enter the "
						+ "word alohomora to use this charm)."));
		charms.addExit(new Exit("smallHall", "Go back through the gray door"));
		
		Place staircase = insert(
				Place.create("staircase", "You are on a high staircase"));
		staircase.addExit(new Exit("greatHall", "Go to the ground floor"));
		staircase.addExit(new Exit("corridor", "Go to the fourth floor."));
		staircase.addLockedExit(new LockedExit("northTower", "Go all the way to the top"));
		
		Place corridor = insert(
				Place.create("corridor", "You are in a corridor with a one\n"
						+ "eyed witch and several suits of armor that you "
						+ "see move in the corner of your eye."));
		corridor.addExit(new Exit("staircase", "There is an archway."));
		corridor.addExit(new Exit("gryffindor", "There is a painting of the fat lady"));
		corridor.addSecretExit(new SecretExit("passageway", "tap the one-eyed witch with your wand to open it, and enter!"));
		
		Place gryffindor = insert(
				Place.create("gryffindor", "You are in the Gryffindor common room!"));
		gryffindor.addExit(new Exit("corridor", "There is the portrait hole"));
		gryffindor.addExit(new Exit("alcove", "There is an alcove in the corner"));
		
		Place alcove = insert(
				Place.create("alcove", "Fred and George give you the Marauders\n"
						+ "map! if you enter 'search' you can check the map and\n"
						+ " may find secret exits!"));
		alcove.addExit(new Exit("gryffindor", "Go back to the common room"));
		alcove.addStuff("Marauders Map");
		
		Place passageway = insert(
				Place.terminal("passageway", "You are in a secret passageway that leads to Honeydukes in Hogsmeade!"
						+ "\n\n Congrats you win!"));
		
		Place northTower = insert(
				Place.create("northTower", "You are in North Tower, the Highest\n"
						+ "astronomy tower in Hogwarts. There is no roof or walls, \n"
						+ "only a railing."));
		northTower.addExit(new Exit("staircase", "There is an archway"));
		northTower.addFlyExit(new FlyExit("sky", "Fly off of North Tower"));
		
		Place sky = insert(
				Place.terminal("sky", "You are flying away to Hogsmeade.\n"
						+ "Congrats you win!"));
		
		//Make sure your graph makes sense!
		checkAllExitsGoSomewhere();	
	}
	
	/** This replaces a lot of typing. We always want to map from p.id
	 * to p.
	 * 
	 * @param p - the place.
	 * @return the place you gave us, so that you can store it in a variable
	 * 	 
	 */
	private Place insert(Place p) {
		places.put(p.getId(), p);
		return p;
	}
	
	/**
	 * This method checks to make sure the graph makes sense
	 */
	private void checkAllExitsGoSomewhere() {
		boolean missing = false;
		// For every place:
		for (Place p : places.values()) {
			// For every exit from that place:
			for (Exit x : p.getVisibleExits()) {
				// That exit goes to somewhere that exists!
				if (!places.containsKey(x.getTarget())) {
					// Don't leave immediately, but check everything all at once.
					missing = true;
					// Print every exit with a missing place:
					System.err.println("Found exit pointing at " + x.getTarget() + " which does not exist as a place.");
				}
			}
		}
		
		//crash if the map doesn't make sense
		if (missing) {
			throw new RuntimeException("You have some exits to nowhere!");
		}
	}
	
	/**
	 * Get a Place object by name.
	 */
	public Place getPlace(String id) {
		return this.places.get(id);
	}
}
