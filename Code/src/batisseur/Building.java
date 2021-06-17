package batisseur;

import java.util.ArrayList;

public class Building extends Card implements IBuilding {

	private int coin;
	private int point;
	private ArrayList<IWorker> workerOn;

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
	public Building(String name, int stone, int wood, int knowledge, int tile, int coin, int point) {
		super(name, stone, wood, knowledge, tile);
		if(coin >=0 && point >=0) {
			this.coin = coin;
			this.point = point;
			this.workerOn = new ArrayList<IWorker>();
		} else {
			System.err.println("Building : coin or point invalid");
		}
	}

	/**
	 * get the worker on
	 * @return the arrayList containing all the worker assigned to the building
	 **/
	public ArrayList<IWorker> getWorkerOn() {
		return this.workerOn;
	}

	/**
	 * add a worker on the building
	 * @param worker the worker you want to add on
	 **/
	public void addWorkerOn(IWorker worker) {
		if(worker instanceof Machine) {
			if(((Machine)(worker)).isConstruct()) {
				this.workerOn.add(worker);
			} else {
				System.err.println("addWorkerOn : the current Machine is broken");
			}
		} else {
			this.workerOn.add(worker);
		}
		
	}

	/**
	 * remove a worker on the building
	 * @param worker the worker you want to remove from
	 **/
	public void removeWorkerOn(IWorker worker) {
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

	public boolean isConstruct() {
		boolean ret = true;
		int[] value = checkRessources();
		int i = 0;
		while(ret && i < value.length) {
			if(value[i] > 0) {
				ret = false;
			}
			i++;
		}
		return ret;
	}

	public int[] checkRessources() {
		int[] ret = new int[4];
		int sumStone = 0;
		int sumWood = 0;
		int sumKnowledge = 0;
		int sumTile = 0;
		for(IWorker worker : this.workerOn) {
			sumStone += ((Card)worker).getStone();
			sumWood += ((Card)worker).getWood();
			sumKnowledge += ((Card)worker).getKnowledge();
			sumTile += ((Card)worker).getTile();
		}
		ret[0] = this.getStone() - sumStone;
		ret[1] = this.getWood() - sumWood;
		ret[2] = this.getKnowledge() - sumKnowledge;
		ret[3] = this.getTile() - sumTile;
		return ret;
	}

	public String toString() {
		String top = "█  " + this.getName() + "  █";
		int rightBorder = top.length();
		String blackLine = "█".repeat(rightBorder);
		String coinString = goodString(this.getCoin() + " écus", rightBorder, "█");
		String pointString = goodString(this.getPoint() + " points", rightBorder, "█");
		String stoneString = goodString(this.getStone() + " pierres", rightBorder, "█");
		String woodString = goodString(this.getWood() + " bois", rightBorder, "█");
		String knowledgeString = goodString(this.getKnowledge() + " savoir", rightBorder, "█");
		String tileString = goodString(this.getTile() + " tuiles", rightBorder, "█");

		String ret = blackLine + "\n" + top + "\n" + blackLine + "\n" + coinString + pointString + blackLine + "\n" + stoneString + woodString + knowledgeString + tileString + blackLine + "\n";
		return ret;
	}

}