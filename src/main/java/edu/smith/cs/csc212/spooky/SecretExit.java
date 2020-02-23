package edu.smith.cs.csc212.spooky;

public class SecretExit extends Exit {
	public SecretExit(String target, String description) {
		super(target, description);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * if hidden is true the exit can be used
	 */
	private boolean hidden = true;
	
	/**
	 * Makes it so this exit can be used
	 */
	@Override
	public void search() {
		this.hidden = false;
	}
	
	/**
	 * tells the game whether this exit can be used
	 */
	@Override
	public boolean isSecret() {
		return hidden;
	}
	

}
