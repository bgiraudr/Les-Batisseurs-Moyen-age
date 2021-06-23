package batisseur;

import java.util.ArrayList;
import util.DesignString;

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

	/**
	 * Create the string when the building is under construction
	 * @return the string
	 **/
	public String toStringValue() {
		int rightBorder = 30;
		String topLine = "╭" + "─".repeat(rightBorder+2) + "╮\n";
		String botLine = "╰" + "─".repeat(rightBorder+2) + "╯\n";
		String transiLine = "├" + "─".repeat(rightBorder+2) + "┤\n";

		String top = DesignString.centerString(rightBorder, this.getName(), "│");
		String coinString = String.format("│ %-" + rightBorder + "s │\n", this.getCoin() + " écus");
		String pointString = String.format("│ %-" + rightBorder + "s │\n", this.getPoint() + " points");
		String nbWorkerString = String.format("│ %-" + rightBorder + "s │\n", this.workerOn.size() + " ouvriers");
		String stoneString = String.format("│ %-" + rightBorder + "s │\n", checkRessources()[0] + "/" + this.getStone() + " pierres");
		String woodString = String.format("│ %-" + rightBorder + "s │\n", checkRessources()[1] + "/" + this.getWood() + " bois");
		String knowledgeString = String.format("│ %-" + rightBorder + "s │\n", checkRessources()[2] + "/" + this.getKnowledge() + " savoir");
		String tileString = String.format("│ %-" + rightBorder + "s │\n", checkRessources()[3] + "/" + this.getTile() + " tuiles");

		String ret = topLine + top + "\n" + transiLine + coinString + pointString + nbWorkerString + transiLine + stoneString + woodString + knowledgeString + tileString + botLine;

		return ret;
	}

	/**
	 * Create the string for the building
	 * @return the string
	 **/
	public String toString() {
		int rightBorder = 30;
		String topLine = "╭" + "─".repeat(rightBorder+2) + "╮\n";
		String botLine = "╰" + "─".repeat(rightBorder+2) + "╯\n";
		String transiLine = "├" + "─".repeat(rightBorder+2) + "┤\n";

		String top = "";
		if(this.workerOn.size() == 0) {
			top = DesignString.centerString(rightBorder, this.getName(), "│");
		} else {
			top = DesignString.centerString(rightBorder, this.getName() + " EC", "│");
		}
		String coinString = String.format("│ %-" + rightBorder + "s │\n", this.getCoin() + " écus");
		String pointString = String.format("│ %-" + rightBorder + "s │\n", this.getPoint() + " points");
		String stoneString = String.format("│ %-" + rightBorder + "s │\n", this.getStone() + " pierres");
		String woodString = String.format("│ %-" + rightBorder + "s │\n", this.getWood() + " bois");
		String knowledgeString = String.format("│ %-" + rightBorder + "s │\n", this.getKnowledge() + " savoir");
		String tileString = String.format("│ %-" + rightBorder + "s │\n", this.getTile() + " tuiles");

		String ret = topLine + top + "\n" + transiLine + coinString + pointString + transiLine + stoneString + woodString + knowledgeString + tileString + botLine;

		return ret;
	}

}