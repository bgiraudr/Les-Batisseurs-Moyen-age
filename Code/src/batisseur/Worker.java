package batisseur;

import util.DesignString;

public class Worker extends Card implements IWorker {

	private int cost;

	/**
	 * Generate a new Worker
	 * @param name the name of the worker
	 * @param wood the number of wood it product
	 * @param stone the number of stone it product
	 * @param knowledge the number of knowledge it product
	 * @param tile the number of tile it product
	 * @param cost the salary
	 */
	public Worker(String name, int stone, int wood, int knowledge, int tile, int cost) {
		super(name, stone, wood, knowledge, tile);
		if(cost >= 0) {
			this.cost = cost;
		} else {
			System.err.println("Worker : cost invalid");
		}
	}

	/**
	 * get the cost value of the worker
	 * @return the cost of the worker
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

	public String toString() {
		int rightBorder = 30;
		String topLine = "╭" + "─".repeat(rightBorder+2) + "╮\n";
		String botLine = "╰" + "─".repeat(rightBorder+2) + "╯\n";
		String transiLine = "├" + "─".repeat(rightBorder+2) + "┤\n";

		String top = DesignString.centerString(rightBorder, this.getName(), "│");
		String coinString = String.format("│ %-" + rightBorder + "s │\n", this.getCost() + " écus");
		String stoneString = String.format("│ %-" + rightBorder + "s │\n", this.getStone() + " pierres");
		String woodString = String.format("│ %-" + rightBorder + "s │\n", this.getWood() + " bois");
		String knowledgeString = String.format("│ %-" + rightBorder + "s │\n", this.getKnowledge() + " savoir");
		String tileString = String.format("│ %-" + rightBorder + "s │\n", this.getTile() + " tuiles");

		String ret = topLine + top + "\n" + transiLine + coinString + transiLine + stoneString + woodString + knowledgeString + tileString + botLine;

		return ret;
	}
}