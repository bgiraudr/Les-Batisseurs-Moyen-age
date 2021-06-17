package batisseur;

import java.util.ArrayList;

public abstract class Player {

	private String name;
	private int point;
	private int action;
	private int coin;

	private ArrayList<IWorker> worker_cards;
	private ArrayList<IBuilding> building_cards;
	private ArrayList<IBuilding> started_buildings;
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

			this.action = 3; //default value
			this.coin = 10; //default value for a new player

			this.worker_cards = new ArrayList<IWorker>();
			this.building_cards = new ArrayList<IBuilding>();
			this.started_buildings = new ArrayList<IBuilding>();
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
	 * add a building to your cards from the top 5
	 * @param building the building to add
	 **/
	public void addBuilding(IBuilding building) {
		if(building != null && this.board.getFiveBuildingCards().contains(building)) {
			if(action > 0) {
				this.building_cards.add(building);
				this.board.getFiveBuildingCards().remove(building);
				this.board.generateBoardBuilding();
				removeAction(1);
			} else {
				System.err.println("addBuilding : you have 0 action left");
			}
		}
	}

	/**
	 * remove a building from your cards
	 * @param building the building to remove
	 **/
	public void removeBuilding(IBuilding building) {
		if(building != null && this.building_cards.contains(building)) {
			this.building_cards.remove((Card)building);
		}
	}

	/**
	 * open a building and add it to the arraylist
	 * @param building
	 */
	public void openBuilding(IBuilding building) {
		this.started_buildings.add(building);
	}

	/**
	 * hire a new worker from the 5 on the top
	 * @param worker
	 */
	public void hireWorker(IWorker worker) {
		if(this.coin-worker.getCost() >= 0 && worker != null) {
			if(this.action > 0) {
				if(this.board.getFiveWorkerCards().contains(worker)) {
					this.worker_cards.add(worker);
					this.coin -= worker.getCost();
					removeAction(1);
					this.board.removeWorkerCards(worker);
					this.board.generateBoardWorker();
				} else {
					System.err.println("hireWorker : The worker you want isn't on the board");
				}
			} else {
				System.err.println("hireWorker : you have 0 action left");
			}
		} else {
			System.err.println("hireWorker : You have too few coin ! " + worker.getCost() + " is needed and you have " + this.coin);
		}
	}

	/**
	 * get all the worker cards of the player
	 * @return all the worker cards of the player
	 **/
	public ArrayList<IWorker> getWorkerCards() {
		return this.worker_cards;
	}

	/**
	 * get all the building cards of the player
	 * @return all the building cards of the player
	 **/
	public ArrayList<IBuilding> getBuildingsCards() {
		return this.building_cards;
	}

	/**
	 * get all the started building cards of the player
	 * @return all the building cards of the player
	 **/
	public ArrayList<IBuilding> getStartedBuilding() {
		return this.started_buildings;
	}

	/**
	 * make a worker work on a certain building
	 * @param building
	 * @param worker
	 */
	public void workerToBuilding(IWorker worker, IBuilding building) {
		if(this.worker_cards.contains(worker) && this.building_cards.contains(building)) {
			building.addWorkerOn(worker);
			this.worker_cards.remove(worker);
			if(!this.started_buildings.contains(building)) {
				openBuilding(building);
			}
			finishBuilding(building);
		} else {
			System.err.println("workerToBuilding : you don't own this worker or building");
		}
		
	}

	public void finishBuilding(IBuilding building) {
		if(building.isConstruct()) {
			this.coin += building.getCoin();
			this.point += building.getPoint();
			this.started_buildings.remove(building);
			for(IWorker workerOn : building.getWorkerOn()) {
				this.worker_cards.add(workerOn);
			}
			System.out.println(((Card)building).getName() + " is finished ! Well done");
		}
	}

	/**
	 * change action to some coins
	 * @param nbAction
	 */
	public void actionToCoins(int nbAction) {
		if(this.action - nbAction >= 0) {
			if(nbAction == 1) {
				this.coin += 1;
			} else if(nbAction == 2) {
				this.coin += 3;
			} else if(nbAction == 3) {
				this.coin += 6;
			}
			this.action -= nbAction;
		} else {
			System.err.println("actionToCoins : you have 0 action left");
		}
	}

	/**
	 * buy action from coin
	 * @param nbAction
	 */
	public void buyAction(int nbAction) {
		if(this.coin >= nbAction * 5) {
			this.action += nbAction;
			this.coin -= nbAction*5;
		} else {
			System.err.println("buyAction : You have too few coin ! " + nbAction*5 + " is needed and you have " + this.coin);
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

	public String toString() {
		return "[ " + this.name + " ] " + this.coin + " - " + this.point + " - " + this.action;
	}
}