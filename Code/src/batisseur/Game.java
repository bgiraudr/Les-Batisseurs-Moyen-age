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
	 * @param playerName1
	 * @param playerName2
	 * @param playerName3
	 * @param playerName4
	 * @param gui
	 */
	public Game(String playerName1, String playerName2, String playerName3, String playerName4, boolean gui, Mode mode) {
		// TODO - implement Game.Game
	}

	/**
	 * create all the player depends of the mode
	 * @param playerName1
	 * @param playerName2
	 * @param playerName3
	 * @param playerName4
	 * @param mode
	 */
	public void createPlayers(String playerName1, String playerName2, String playerName3, String playerName4, Mode mode) {
		// TODO - implement Game.createPlayers
	}

	public void changeCurrent() {
		// TODO - implement Game.changeCurrent
	}

	public void saveGame() {
		// TODO - implement Game.saveGame
	}

	public Player getCurrent() {
		// TODO - implement Game.getCurrent
	}

}