package edu.smith.cs.csc212.spooky;

public class FlyExit extends Exit {
	public FlyExit(String target, String description) {
		super(target, description);
	}
	
	/**
	 * if canFly is true the exit can be used
	 */
	private boolean canFly = false;
	
	/**
	 * Makes it so this exit can be used
	 */
	@Override
	public void hasBroom() {
		this.canFly = true;
	}
	
	/**
	 * tells the game whether this exit can be used
	 */
	@Override
	public boolean canOpen(Player player) {
		return canFly;
	}
}

