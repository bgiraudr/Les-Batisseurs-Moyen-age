package batisseur;

import java.util.ArrayList;

public class Machine extends Card implements IWorker, IBuilding {

	private int point;
	private ArrayList<Card> workerOn;
	private int cost;

	private int woodConstruct;
	private int stoneConstruct;
	private int knowledgeConstruct;
	private int tileConstruct;

	/**
	 * Create a new card machine
	 * @param name the name of the card
	 * @param wood the wood value the machine require to be created
	 * @param stone the stone value the machine require to be created
	 * @param knowledge the knowledge value the machine require to be created
	 * @param tile the tile value the machine require to be created
	 * @param point the number of point the machine will product
	 * @param woodConstruct the wood value the machine will product
	 * @param stoneConstruct the stone value the machine will product
	 * @param knowledgeConstruct the knowledge value the machine will product
	 * @param tileConstruct the tile value the machine will product
	 */
	public Machine(String name, int stone, int wood, int knowledge, int tile, int point, int stoneConstruct, int woodConstruct, int knowledgeConstruct, int tileConstruct) {
		super(name, stone, wood, knowledge, tile);
		if(point >= 0 && woodConstruct >= 0 && stoneConstruct >= 0 && knowledgeConstruct >= 0 && tileConstruct >= 0) {
			this.point = point;
			this.cost = 0;
			this.woodConstruct = woodConstruct;
			this.stoneConstruct = stoneConstruct;
			this.knowledgeConstruct = knowledgeConstruct;
			this.tileConstruct = tileConstruct;
			this.workerOn = new ArrayList<Card>();
		}
	}

	/**
	 * get the worker on
	 * @return the arrayList containing all the worker assigned to the building
	 **/
	public ArrayList<Card> getWorkerOn() {
		return this.workerOn;
	}

	/**
	 * add a worker on the building
	 * @param worker the worker you want to add on
	 **/
	public void addWorkerOn(IWorker worker) {
		this.workerOn.add((Card)worker);
	}

	/**
	 * remove a worker on the building
	 * @param worker the worker you want to remove from
	 **/
	public void removeWorkerOn(IWorker worker) {
		this.workerOn.remove((Card)worker);
	}

	/**
	 * get the point you get when you finished the building
	 * @return the number of point
	 **/
	public int getPoint() {
		return this.point;
	}

	/**
	 * set a number of point
	 * @param point the new number of point
	 **/
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * get the cost value of the worker
	 * @return the cost of the machine
	 **/
	public int getCost() {
		return this.cost;
	}

	/**
	 * set the cost value of the worker
	 * @param cost the new cost
	 **/
	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getWoodConstruct() {
		return this.woodConstruct;
	}

	public int getStoneConstruct() {
		return this.stoneConstruct;
	}

	public int getKnowledgeConstruct() {
		return this.knowledgeConstruct;
	}

	public int getTileConstruct() {
		return this.tileConstruct;
	}

	public boolean checkConstruct() {
		boolean ret = false;
		for(Card worker : this.workerOn) {
			if(worker.getStone() >= this.getStone() &&
				worker.getWood() >= this.getWood() &&
				worker.getKnowledge() >= this.getKnowledge() &&
				worker.getTile() >= this.getTile()) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * get the buff of a machine
	 * @return a list of String containing the information about the buff the machine gives
	 * [number, title]
	 **/
	private String[] getMachineBuff() {
		String ret[] = new String[2];
		if(this.stoneConstruct > 0) {
			ret[0] = this.stoneConstruct + "";
			ret[1] = "pierres";
		}
		if(this.woodConstruct > 0) {
			ret[0] = this.woodConstruct + "";
			ret[1] = "bois";
		}
		if(this.knowledgeConstruct > 0) {
			ret[0] = this.knowledgeConstruct + "";
			ret[1] = "savoir";
		}
		if(this.tileConstruct > 0) {
			ret[0] = this.tileConstruct + "";
			ret[1] = "tuiles";
		}
		return ret;
	}

	public String toString() {
		String top = "█  " + this.getName() + "  █";
		int rightBorder = top.length();
		String blackLine = "█".repeat(rightBorder);

		String buffString = goodString("+" + getMachineBuff()[0] + " " + getMachineBuff()[1], rightBorder, "█");
		String pointString = goodString(this.getPoint() + " points", rightBorder, "█");
		String stoneString = goodString(this.getStone() + " pierres", rightBorder, "█");
		String woodString = goodString(this.getWood() + " bois", rightBorder, "█");
		String knowledgeString = goodString(this.getKnowledge() + " savoir", rightBorder, "█");
		String tileString = goodString(this.getTile() + " tuiles", rightBorder, "█");

		String ret = blackLine + "\n" + top + "\n" + blackLine + "\n" + buffString + pointString + blackLine + "\n" + stoneString + woodString + knowledgeString + tileString + blackLine + "\n";
		return ret;
	}
}