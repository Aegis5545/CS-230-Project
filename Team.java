package com.gamingroom;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {
	private static List<Player> players = new ArrayList<Player>();
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Player addPlayer(String name) {
		Player tempPlayer = null;
		
		//creates a loop to search player list
		//Checks if the name is already added, then returns said name
		for (Player currPlayer : players) {
			if (currPlayer.name.equalsIgnoreCase(name)) {
		return currPlayer;
			}
		}
		//If player isn't found, made a new player and add it to list of teams
		if (player == null) {
			//Reference the GameService Singleton instance
			GameService service = GameService.getInstance();
			
			//Use GameService reference to call the getNextPlayerId() to get the ID for the player
			player = new Player(service.getNextPlayerId(), name);
			players.add(player);
		}
		
		return player;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}
