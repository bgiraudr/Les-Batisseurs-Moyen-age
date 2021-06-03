package batisseur;

import java.util.ArrayList;

public abstract class Player {

	private String name;
	private int point;
	private int action;
	private int coin;

	private ArrayList<Card> worker_cards;
	private ArrayList<Card> building_cards;
	private ArrayList<Card> started_buildings;
	private Board board;

	/**
	 * Generate a new player
	 * @param name
	 * @param board
	 */
	public Player(String name, Board board) {
		// TODO - implement Player.Player
	}

	public String getName() {
		return this.name;
	}

	/**
	 * open a building and add it to the arraylist
	 * @param building
	 */
	public void openBuilding(Card building) {
		// TODO - implement Player.openBuilding
	}

	/**
	 * hire a new worker
	 * @param worker
	 */
	public void hireWorker(Card worker) {
		// TODO - implement Player.hireWorker
	}

	public ArrayList<Card> getWorkerCards() {
		// TODO - implement Player.getWorkerCards
	}

	public ArrayList<Card> getBuildingsCards() {
		// TODO - implement Player.getBuildingsCards
	}

	/**
	 * make a worker work on a certain building
	 * @param building
	 * @param worker
	 */
	public void workerToBuilding(Card building, Card worker) {
		// TODO - implement Player.workerToBuilding
	}

	/**
	 * change action to some coins
	 * @param nbAction
	 */
	public void actionToCoins(int nbAction) {
		// TODO - implement Player.actionToCoins
	}

	/**
	 * buy action from coin
	 * @param nbAction
	 */
	public void buyAction(int nbAction) {
		// TODO - implement Player.buyAction
	}

	public int getPoint() {
		return this.point;
	}

	public int getAction() {
		return this.action;
	}

	public int getCoin() {
		return this.coin;
	}

	public abstract void play();
}