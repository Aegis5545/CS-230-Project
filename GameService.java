package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	
	//Holds the next team identifier
	private static long nextTeamId = 1;
	
	//Holds the next player identifier
	private static long nextPlayerId = 1;
	
	//Makes sure the instance GameService is stored in service
	private static GameService service = null;
	
	//Empty Constructor
	private GameService() {}

	// Turns class into singleton
	// What this does is make sure only a single object gets created in a class
	//Since we'd want only one game running at a time, we'd want only single game objects
	private static GameService instance = new GameService();
	
	public static GameService getInstance() {
		return instance;
	}


	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// Iterator to look for if same game name exists
		for (Game existingGame : games) {
			if(existingGame.getName().equals(name)) {
				return existingGame;
			}
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// Uses iterator to look for an existing game with same Id
		for (Game existingGame : games) {
			if (existingGame.getId() == id) {
				game = existingGame;
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// Uses an iterator to look for an existing game with the same name
		for (Game existingGame : games) {
			if(existingGame.getName().equals(name)) {
				game = existingGame;
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	//Expands methods to return new teams and players
	//Returns nextTeamId
	public long getNextTeamId() {
		return nextTeamId++;
	}
	//Returns NextPlayerId
	pulic long getNextPlayerId() {
		return nextPlayerId++;
	}
}
