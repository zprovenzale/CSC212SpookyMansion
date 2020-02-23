package edu.smith.cs.csc212.spooky;

public class LockedExit extends Exit {
	public LockedExit(String target, String description) {
		super(target, description);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * if lock is true the exit can be used
	 */
	private boolean lock = false;
	
	/**
	 * Makes it so this exit can be used
	 */
	@Override
	public void unlock() {
		this.lock = true;
	}
	
	/**
	 * tells the game whether this exit can be used
	 */
	@Override
	public boolean canOpen(Player player) {
		return lock;
	}
}
