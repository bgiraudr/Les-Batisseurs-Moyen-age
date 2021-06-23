package batisseur;

import java.io.Serializable;
import java.lang.Thread;
import util.DesignString;
import java.util.ArrayList;
import util.RWGame;
import java.util.Scanner;
import util.RandomInt;
import java.util.Random;

import view.ingame.*;

public class Game implements IGame, Serializable {

	private int nbPlayer;

	private Player player1;
	private Player player2;
	private Player player3;
	private Player player4;
	private Player current;
	private Board board;
	private Mode mode;

	private int tour;

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
		this.setRandomCurrent();
		this.tour = 1;
		if(gui == UI.GUI) {
			GameFrame view = new GameFrame(this);
		}
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

	public void setRandomCurrent() {
		int choix = RandomInt.randomInt(1,this.nbPlayer, new Random());
		switch(choix) {
			case 1:
				this.current = this.player1;
				break;
			case 2:
				this.current = this.player2;
				break;
			case 3:
				this.current = this.player3;
				break;
			case 4:
				this.current = this.player4;
				break;
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
		DesignString.printBorder(35,"Entre le nom de ta sauvegarde", "\033[0;92m");
		System.out.print("> ");
		Scanner scan = new Scanner(System.in);
		RWGame.writeGame("./data/saves/" + scan.next() + ".sav", this);
		System.exit(0);
	}

	/**
	 * get the current player
	 * @return the current Player
	 **/
	public Player getCurrent() {
		return this.current;
	}

	/**
	 * set the current player
	 * @param p the player
	 **/
	public void setCurrent(Player p) {
		this.current = p;
	}

	/**
	 * get the current tour
	 * @return the tour
	 **/
	public int getTour() {
		return this.tour;
	}

	/**
	 * set the tour value
	 * @param tour the new tour
	 **/
	public void setTour(int tour) {
		this.tour = tour;
	}

	/**
	 * contains the main loop
	 **/
	public void start() {
		this.tour = getTour();
		boolean buffer = false;
		while(!checkWin() && !this.board.checkEmpty()) {
			DesignString.printBorder(30,"C'est le tour numéro " + this.tour, "\033[0;92m");
			try {
				for(int i = 0; i < this.nbPlayer; i++) {
					DesignString.printBorder(50,"C'est au bâtisseur " + this.current.getName() + " de jouer !", "\033[93m");
					Thread.sleep(3000);
					this.current.play();
					this.current.setAction(3);
					DesignString.printBorder(40,"C'est la fin du tour du joueur !", "\033[0;92m");
					if(this.current.getPoint() >= 17 && !buffer) {
						DesignString.printBorder(40,this.current.getName() + " a terminé ! Dernier tour !", "\033[0;92m");
						buffer = true;
					}
					this.board.printPlayers();
					Thread.sleep(2000);
					changeCurrent();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.tour++;
		}
		end();
	}

	/**
	 * check if someone has over 17 points
	 * @return true if someone has won
	 **/
	public boolean checkWin() {
		boolean ret = false;

		int nbPointToWin = 17;
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
	 * when a player reached 17 points
	 **/
	public void end() {
		Player[] players = getAllPlayers();

		ArrayList<Player> ordreWinner = new ArrayList<Player>();
		ArrayList<Integer> calcul = new ArrayList<Integer>();
		ArrayList<Integer> calcultri = new ArrayList<Integer>();

		for(int i = 0; i < this.nbPlayer; i++) {
			calcul.add(players[i].getPoint() + (int)(players[i].getCoin()/10));
		}
		
		//point+coin sort
		int max = 0;
		int imax = 0;
		for(int j = 0; j < this.nbPlayer; j++) {
			max = 0;
			imax = 0;
			for(int i = 0; i < this.nbPlayer; i++) {
				if(calcul.get(i) >= max && !ordreWinner.contains(players[i])) {
					max = calcul.get(i);
					imax = i;
				}
			}
			ordreWinner.add(players[imax]);
			calcultri.add(max);
		}
		
		//point sort
		for(int i = 0; i < this.nbPlayer-1; i++) {
			if(calcultri.get(i) == calcultri.get(i+1)) {
				if(ordreWinner.get(i).getPoint() < ordreWinner.get(i+1).getPoint()) {
					Player temp = ordreWinner.get(i+1);
					ordreWinner.set(i+1, ordreWinner.get(i));
					ordreWinner.set(i, temp);
				}
			}
		}

		for(int i = 0; i < this.nbPlayer-1; i++) {
			if(ordreWinner.get(i).getPoint() == ordreWinner.get(i+1).getPoint()) {
				if(ordreWinner.get(i).getCoin() < ordreWinner.get(i+1).getCoin()) {
					Player temp = ordreWinner.get(i+1);
					ordreWinner.set(i+1, ordreWinner.get(i));
					ordreWinner.set(i, temp);
				}
			}
		}

		if(this.board.checkEmpty()) {
			DesignString.printBorder("Plus de cartes disponibles ! Fin de partie prématurée !");
		}

		DesignString.printBorder(35,"C'est l'heure des résultats !", "\033[0;92m");
		for(int i = 0; i < this.nbPlayer; i++) {
			System.out.println("À la place " + (i+1));
			System.out.println(ordreWinner.get(i));
		}

		DesignString.printBorder(30,"Bravo à tous !", "\033[0;92m");

	}

	/**
	 * get all the player in a list
	 * @return a list of all the players
	 **/
	public Player[] getAllPlayers() {
		Player[] p = {this.player1, this.player2, this.player3, this.player4};
		return p;
	}

	/**
	 * get the board
	 * @return the board
	 **/
	public Board getBoard() {
		return this.board;
	}

	/**
	 * get the nb player
	 * @return the nb player
	 **/
	public int getNbPlayer() {
		return this.nbPlayer;
	}
}