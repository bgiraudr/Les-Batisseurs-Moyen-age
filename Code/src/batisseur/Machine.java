package batisseur;

import java.util.ArrayList;
import util.DesignString;

public class Machine extends Card implements IWorker, IBuilding {

	private int point;
	private ArrayList<IWorker> workerOn;
	private int cost;
	private int coin;

	private int woodConstruct;
	private int stoneConstruct;
	private int knowledgeConstruct;
	private int tileConstruct;

	private boolean isWorker;

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
			this.coin = 0;
			this.woodConstruct = woodConstruct;
			this.stoneConstruct = stoneConstruct;
			this.knowledgeConstruct = knowledgeConstruct;
			this.tileConstruct = tileConstruct;
			this.workerOn = new ArrayList<IWorker>();
			this.isWorker = false;
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
		this.workerOn.add(worker);
	}

	/**
	 * remove a worker on the building
	 * @param worker the worker you want to remove from
	 **/
	public void removeWorkerOn(IWorker worker) {
		this.workerOn.remove(worker);
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

	public int getCoin() {
		return this.coin;
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

	/**
	 * get the wood the machine will product
	 * @return the wood construct value
	 **/
	public int getWoodConstruct() {
		return this.woodConstruct;
	}

	/**
	 * get the stone the machine will product
	 * @return the stone construct value
	 **/
	public int getStoneConstruct() {
		return this.stoneConstruct;
	}

	/**
	 * get the knowledge the machine will product
	 * @return the knowledge construct value
	 **/
	public int getKnowledgeConstruct() {
		return this.knowledgeConstruct;
	}

	/**
	 * get the tile the machine will product
	 * @return the tile construct value
	 **/
	public int getTileConstruct() {
		return this.tileConstruct;
	}

	/**
	 * check if the building is finished
	 * @return true if the building is finished
	 **/
	public boolean isConstruct() {
		boolean ret = true;
		int[] value = checkRessources();
		int[] neededValue = {this.getStone(), this.getWood(), this.getKnowledge(), this.getTile()};
		int i = 0;
		while(ret && i < value.length) {
			if(value[i] < neededValue[i]) {
				ret = false;
			}
			i++;
		}
		if(ret) {
			this.isWorker = true;
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

	/**
	 * get the progress that the building is missing
	 * @return an array containing the progress that the building is missing
	 **/
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
		ret[0] = sumStone;
		ret[1] = sumWood;
		ret[2] = sumKnowledge;
		ret[3] = sumTile;
		return ret;
	}

	public String toStringValue() {
		int rightBorder = 30;
		String topLine = "╭" + "─".repeat(rightBorder+2) + "╮\n";
		String botLine = "╰" + "─".repeat(rightBorder+2) + "╯\n";
		String transiLine = "├" + "─".repeat(rightBorder+2) + "┤\n";

		String top = DesignString.centerString(rightBorder, this.getName() + " Ϣ", "│");
		String buffString = String.format("│ %-" + rightBorder + "s │\n", "+" + getMachineBuff()[0] + " " + getMachineBuff()[1]);
		String pointString = String.format("│ %-" + rightBorder + "s │\n", this.getPoint() + " points");
		String nbWorkerString = String.format("│ %-" + rightBorder + "s │\n", this.workerOn.size() + " ouvriers");
		String stoneString = String.format("│ %-" + rightBorder + "s │\n", checkRessources()[0] + "/" + this.getStone() + " pierres");
		String woodString = String.format("│ %-" + rightBorder + "s │\n", checkRessources()[1] + "/" + this.getWood() + " bois");
		String knowledgeString = String.format("│ %-" + rightBorder + "s │\n", checkRessources()[2] + "/" + this.getKnowledge() + " savoir");
		String tileString = String.format("│ %-" + rightBorder + "s │\n", checkRessources()[3] + "/" + this.getTile() + " tuiles");

		String ret = topLine + top + "\n" + transiLine + buffString + pointString + nbWorkerString + transiLine + stoneString + woodString + knowledgeString + tileString + botLine;

		return ret;
	}

	public String toString() {
		int rightBorder = 30;
		String topLine = "╭" + "─".repeat(rightBorder+2) + "╮\n";
		String botLine = "╰" + "─".repeat(rightBorder+2) + "╯\n";
		String transiLine = "├" + "─".repeat(rightBorder+2) + "┤\n";

		String top = "";
		String ret = null;

		if(this.workerOn.size() == 0) {
			top = DesignString.centerString(rightBorder, this.getName() + " Ϣ", "│");
		} else {
			top = DesignString.centerString(rightBorder, this.getName() + " Ϣ EC", "│");
		}
		if(!this.isWorker) {
			String buffString = String.format("│ %-" + rightBorder + "s │\n", "+" + getMachineBuff()[0] + " " + getMachineBuff()[1]);
			String pointString = String.format("│ %-" + rightBorder + "s │\n", this.getPoint() + " points");
			String stoneString = String.format("│ %-" + rightBorder + "s │\n", this.getStone() + " pierres");
			String woodString = String.format("│ %-" + rightBorder + "s │\n", this.getWood() + " bois");
			String knowledgeString = String.format("│ %-" + rightBorder + "s │\n", this.getKnowledge() + " savoir");
			String tileString = String.format("│ %-" + rightBorder + "s │\n", this.getTile() + " tuiles");

			ret = topLine + top + "\n" + transiLine + buffString + pointString + transiLine + stoneString + woodString + knowledgeString + tileString + botLine;
		} else {
			String coinString = String.format("│ %-" + rightBorder + "s │\n", this.getCost() + " écus");
			String stoneString = String.format("│ %-" + rightBorder + "s │\n", this.stoneConstruct + " pierres");
			String woodString = String.format("│ %-" + rightBorder + "s │\n", this.woodConstruct + " bois");
			String knowledgeString = String.format("│ %-" + rightBorder + "s │\n", this.knowledgeConstruct + " savoir");
			String tileString = String.format("│ %-" + rightBorder + "s │\n", this.tileConstruct + " tuiles");

			ret = topLine + top + "\n" + transiLine + coinString + transiLine + stoneString + woodString + knowledgeString + tileString + botLine;
		}

		return ret;
	}
}