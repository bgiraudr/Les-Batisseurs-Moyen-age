package batisseur;

import java.util.ArrayList;

public class Building extends Card {

	private int coin;
	private int point;
	private ArrayList<Worker> workerOn;

	/**
	 * Create a new building card
	 * @param name the name of the card
	 * @param wood the number of wood to build
	 * @param stone the number of stone to build
	 * @param knowledge the number of knowledge to build
	 * @param tile the number of tile to build
	 * @param coin the number of coin you earn
	 * @param point the number of point you earn
	 */
	public Building(String name, int wood, int stone, int knowledge, int tile, int coin, int point) {
		super(name, wood, stone, knowledge, tile);
		if(coin >=0 && point >=0) {
			this.coin = coin;
			this.point = point;
			this.workerOn = new ArrayList<Worker>();
		} else {
			System.err.println("Building : coin or point invalid");
		}
	}

	/**
	 * get the worker on
	 * @return the arrayList containing all the worker assigned to the building
	 **/
	public ArrayList<Worker> getWorkerOn() {
		return this.workerOn;
	}

	/**
	 * add a worker on the building
	 * @param worker the worker you want to add on
	 **/
	public void addWorkerOn(Worker worker) {
		this.workerOn.add(worker);
	}

	/**
	 * remove a worker on the building
	 * @param worker the worker you want to remove from
	 **/
	public void removeWorkerOn(Worker worker) {
		this.workerOn.remove(worker);
	}

	/**
	 * get the coin you get when you finished the building
	 * @return the number of coin
	 **/
	public int getCoin() {
		return this.coin;
	}

	/**
	 * get the point you get when you finished the building
	 * @return the number of point
	 **/
	public int getPoint() {
		return this.point;
	}

	/**
	 * set a number of coin
	 * @param coin the new number of coin
	 **/
	public void setCoin(int coin) {
		this.coin = coin;
	}

	/**
	 * set a number of point
	 * @param point the new number of point
	 **/
	public void setPoint(int point) {
		this.point = point;
	}

}