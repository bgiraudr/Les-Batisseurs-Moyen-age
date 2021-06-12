package batisseur;

import java.util.ArrayList;

public abstract class Player {

	private String name;
	private int point;
	private int action;
	private int coin;

	private ArrayList<Worker> worker_cards;
	private ArrayList<Building> building_cards;
	private ArrayList<Building> started_buildings;
	private Board board;

	/**
	 * Generate a new player
	 * @param name
	 * @param board
	 */
	public Player(String name, Board board) {
		if(name != null && board != null) {
			this.name = name;
			this.board = board;

			this.action = 3;

			this.worker_cards = new ArrayList<Worker>();
			this.building_cards = new ArrayList<Building>();
			this.started_buildings = new ArrayList<Building>();
		}
	}

	/**
	 * get the name of the player
	 * @return the name
	 **/
	public String getName() {
		return this.name;
	}

	/**
	 * add a building to your cards
	 * @param building the building to add
	 **/
	public void addBuilding(Building building) {
		if(building != null) {
			this.building_cards.add(building);
		}
	}

	/**
	 * remove a building from your cards
	 * @param building the building to remove
	 **/
	public void removeBuilding(Building building) {
		if(building != null) {
			this.building_cards.remove(building);
		}
	}

	/**
	 * open a building and add it to the arraylist
	 * @param building
	 */
	public void openBuilding(Building building) {
		this.started_buildings.add(building);
		this.building_cards.remove(building);
	}

	/**
	 * hire a new worker
	 * @param worker
	 */
	public void hireWorker(Worker worker) {
		if(this.coin-worker.getCost() >= 0) {
			this.worker_cards.add(worker);
			this.coin -= worker.getCost();
		}
	}

	/**
	 * get all the worker cards of the player
	 * @return all the worker cards of the player
	 **/
	public ArrayList<Worker> getWorkerCards() {
		return this.worker_cards;
	}

	/**
	 * get all the building cards of the player
	 * @return all the building cards of the player
	 **/
	public ArrayList<Building> getBuildingsCards() {
		return this.building_cards;
	}

	/**
	 * get all the started building cards of the player
	 * @return all the building cards of the player
	 **/
	public ArrayList<Building> getStartedBuilding() {
		return this.started_buildings;
	}

	/**
	 * make a worker work on a certain building
	 * @param building
	 * @param worker
	 */
	public void workerToBuilding(Worker worker, Building building) {
		if(this.started_buildings.contains(building)) {
			building.addWorkerOn(worker);
		}
	}

	/**
	 * change action to some coins
	 * @param nbAction
	 */
	public void actionToCoins(int nbAction) {
		if(nbAction == 1) {
			this.coin += 1;
		} else if(nbAction == 2) {
			this.coin += 3;
		} else if(nbAction == 3) {
			this.coin += 6;
		}
		this.action -= nbAction;
	}

	/**
	 * buy action from coin
	 * @param nbAction
	 */
	public void buyAction(int nbAction) {
		if(this.coin >= nbAction * 5) {
			this.action += nbAction;
			this.coin -= nbAction*5;
		}
	}

	/**
	 * get the player's point
	 * @return the number of point of the player
	 **/
	public int getPoint() {
		return this.point;
	}

	/**
	 * get the player's number of action
	 * @return the number of action of the player
	 **/
	public int getAction() {
		return this.action;
	}

	/**
	 * get the player's coin
	 * @return the number of coin of the player
	 **/
	public int getCoin() {
		return this.coin;
	}

	/**
	 * set a new name
	 * @param name the new name
	 **/
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * add some point to the player
	 * @param point the number of point you need to add
	 **/
	public void addPoint(int point) {
		this.point += point;
	}

	/**
	 * add some coin to the player
	 * @param coin the number of coin you need to add
	 **/
	public void addCoin(int coin) {
		this.coin += coin;
	}

	/**
	 * set a new number action
	 * @param nbAction the new number of action
	 **/
	public void setAction(int nbAction) {
		this.action = nbAction;
	}

	/**
	 * set a new number coin
	 * @param nbCoin the new number of coin
	 **/
	public void setCoin(int nbCoin) {
		this.coin = nbCoin;
	}

	/**
	 * remove action
	 * @param nbAction the number of action you want to remove
	 **/
	public void removeAction(int nbAction) {
		if(this.action - nbAction >= 0) {
			this.action -= nbAction;
		} else {
			System.err.println("removeAction : too many action to remove");
		}
	}

	//play
	public abstract void play();
}