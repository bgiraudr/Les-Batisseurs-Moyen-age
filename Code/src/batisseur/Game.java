package batisseur;

import java.io.Serializable;
import java.lang.Thread;
import util.DesignString;

public class Game implements IGame, Serializable {

	private int nbPlayer;

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
	public Game(String playerName1, String playerName2, String playerName3, String playerName4, Mode mode, UI gui) {
		this.board = new Board(this);
		this.createPlayers(playerName1, playerName2, playerName3, playerName4, mode);
		this.current = this.player1;
		this.start();
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
		if(mode == Mode.HH) {
			this.player1 = new HumanPlayer(playerName1, this.board);
			this.player2 = new HumanPlayer(playerName2, this.board);
			this.player3 = null;
			this.player4 = null;
			this.nbPlayer = 2;
		}
		if(mode == Mode.HA) {
			this.player1 = new HumanPlayer(playerName1, this.board);
			this.player2 = new AutoPlayer(playerName2, this.board);
			this.player3 = null;
			this.player4 = null;
			this.nbPlayer = 2;
		}
		if(mode == Mode.HHH) {
			this.player1 = new HumanPlayer(playerName1, this.board);
			this.player2 = new HumanPlayer(playerName2, this.board);
			this.player3 = new HumanPlayer(playerName3, this.board);
			this.player4 = null;
			this.nbPlayer = 3;
		}
		if(mode == Mode.HHA) {
			this.player1 = new HumanPlayer(playerName1, this.board);
			this.player2 = new HumanPlayer(playerName2, this.board);
			this.player3 = new AutoPlayer(playerName3, this.board);
			this.player4 = null;
			this.nbPlayer = 3;
		}
		if(mode == Mode.HAA) {
			this.player1 = new HumanPlayer(playerName1, this.board);
			this.player2 = new AutoPlayer(playerName2, this.board);
			this.player3 = new AutoPlayer(playerName3, this.board);
			this.player4 = null;
			this.nbPlayer = 3;
		}
		if(mode == Mode.HHHH) {
			this.player1 = new HumanPlayer(playerName1, this.board);
			this.player2 = new HumanPlayer(playerName2, this.board);
			this.player3 = new HumanPlayer(playerName3, this.board);
			this.player4 = new HumanPlayer(playerName4, this.board);
			this.nbPlayer = 4;
		}
		if(mode == Mode.HHHA) {
			this.player1 = new HumanPlayer(playerName1, this.board);
			this.player2 = new HumanPlayer(playerName2, this.board);
			this.player3 = new HumanPlayer(playerName3, this.board);
			this.player4 = new AutoPlayer(playerName4, this.board);
			this.nbPlayer = 4;
		}
		if(mode == Mode.HHAA) {
			this.player1 = new HumanPlayer(playerName1, this.board);
			this.player2 = new HumanPlayer(playerName2, this.board);
			this.player3 = new AutoPlayer(playerName3, this.board);
			this.player4 = new AutoPlayer(playerName4, this.board);
			this.nbPlayer = 4;
		}
		if(mode == Mode.HAAA) {
			this.player1 = new HumanPlayer(playerName1, this.board);
			this.player2 = new AutoPlayer(playerName2, this.board);
			this.player3 = new AutoPlayer(playerName3, this.board);
			this.player4 = new AutoPlayer(playerName4, this.board);
			this.nbPlayer = 4;
		}
	}

	/**
	 * change the current player
	 **/
	public void changeCurrent() {
		if(this.nbPlayer == 2) {
			if(this.current == this.player1) {
				this.current = this.player2;
			}
			else if(this.current == this.player2) {
				this.current = this.player1;
			}
		}
		else if(this.nbPlayer == 3) {
			if(this.current == this.player1) {
				this.current = this.player2;
			}
			else if(this.current == this.player2) {
				this.current = this.player3;
			}
			else if(this.current == this.player3) {
				this.current = this.player1;
			}
		}
		else if(this.nbPlayer == 4) {
			if(this.current == this.player1) {
				this.current = this.player2;
			}
			else if(this.current == this.player2) {
				this.current = this.player3;
			}
			else if(this.current == this.player3) {
				this.current = this.player4;
			}
			else if(this.current == this.player4) {
				this.current = this.player1;
			}
		}
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
		int tour = 0;
		while(!checkWin()) {
			try {
				for(int i = 0; i < this.nbPlayer; i++) {
					DesignString.printBorder(50,"C'est au bâtisseur " + this.current.getName() + " de jouer !");
					Thread.sleep(3000);
					this.current.play();
					DesignString.printBorder(30,"C'est la fin du tour !", "\033[0;92m");
					Thread.sleep(3000);
					changeCurrent();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tour++;
		}
		end();
	}

	private boolean checkWin() {
		boolean ret = false;

		int nbPointToWin = 2;
		if(this.nbPlayer == 2) {
			if(this.player1.getPoint() >= nbPointToWin ||
				this.player2.getPoint() >= nbPointToWin) {
				ret = true;
			}
		}
		if(this.nbPlayer == 3) {
			if(this.player1.getPoint() >= nbPointToWin ||
				this.player2.getPoint() >= nbPointToWin ||
				this.player3.getPoint() >= nbPointToWin) {
				ret = true;
			}
		}
		if(this.nbPlayer == 4) {
			if(this.player1.getPoint() >= nbPointToWin ||
				this.player2.getPoint() >= nbPointToWin ||
				this.player3.getPoint() >= nbPointToWin ||
				this.player4.getPoint() >= nbPointToWin) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * when a player reached 13 points
	 **/
	public void end() {

	}

	public Player[] getAllPlayers() {
		Player[] p = {this.player1, this.player2, this.player3, this.player4};
		return p;
	}
}