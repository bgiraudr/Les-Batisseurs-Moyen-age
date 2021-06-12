package batisseur;

public class Game implements IGame {

	private Player player1;
	private Player player2;
	private Player player3;
	private Player player4;
	private Player current;
	private Board board;
	private Mode mode;

	/**
	 * create the main game with all the player
	 * @param playerName1 the first player name
	 * @param playerName2 the second player name 
	 * @param playerName3 the third player name 
	 * @param playerName4 the fourth player name 
	 * @param gui true if you want to play with the interface on
	 * @param mode the current mode
	 */
	public Game(String playerName1, String playerName2, String playerName3, String playerName4, boolean gui, Mode mode) {
		// TODO - implement Game.Game
	}

	/**
	 * create all the player depends of the mode
	 * @param playerName1 the first player name
	 * @param playerName2 the second player name 
	 * @param playerName3 the third player name 
	 * @param playerName4 the fourth player name 
	 * @param mode the current mode
	 */
	public void createPlayers(String playerName1, String playerName2, String playerName3, String playerName4, Mode mode) {
		// TODO - implement Game.createPlayers
	}

	/**
	 * change the current player
	 **/
	public void changeCurrent() {
		// TODO - implement Game.changeCurrent
	}

	/**
	 * save the game
	 **/
	public void saveGame() {
		// TODO - implement Game.saveGame
	}

	/**
	 * get the current player
	 * @return the current Player
	 **/
	public Player getCurrent() {
		return this.current;
	}

	/**
	 * contains the main loop
	 **/
	public void start() {

	}

	/**
	 * when a player reached 13 points
	 **/
	public void end() {

	}

	/**
	 * print the rules
	 **/
	public void print_rules() {

	}

}