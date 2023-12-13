package com.gamingroom;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {
	
	private static List<Team> teams = new ArrayList<Team>();
	
	/**
	 * Hide the default constructor to prevent creating empty instances.
	 */
	private Game() {
	}

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		this();
		this.id = id;
		this.name = name;
	}
	//Construct a new team instance

	public Team addTeam(String name) {
		//Creates local team instance
		Team team = null;
		
		//Iterates over the teams for existing name, returns existing team if it exists
		for (int i = 0; i < teams.size() - 1; i++) {
			//Looks through teams list to see if the name already exists
			if (teams.get(i).getName() == name) {
				team = teams.get(i);
			}
		}
		
		//If the team isn't found, makes a new team instance and adds it to the list of teams
		if (team == null) {
			Gameservice service = Gameservice.getInstance();
			
			//Reference Gameservice instance and then call getNextTeamId() to get the ID for the specific team
			team = new Team(service.getNextPlayerId(), name);
			teams.add(team);
		}
		//Returns new/existing team
		return team;
	}

	@Override
	public String toString() {
		
		return "Game [id=" + id + ", name=" + name + "]";
	}

}
