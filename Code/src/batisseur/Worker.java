package batisseur;

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

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String toString() {
		String top = "█   " + this.getName() + "   █";
		int rightBorder = top.length();
		String blackLine = "█".repeat(rightBorder);

		String coinString = goodString(this.getCost() + " écus", rightBorder, "█");
		String stoneString = goodString(this.getStone() + " pierres", rightBorder, "█");
		String woodString = goodString(this.getWood() + " bois", rightBorder, "█");
		String knowledgeString = goodString(this.getKnowledge() + " savoir", rightBorder, "█");
		String tileString = goodString(this.getTile() + " tuiles", rightBorder, "█");

		String ret = blackLine + "\n" + top + "\n" + blackLine + "\n" + coinString + blackLine + "\n" + stoneString + woodString + knowledgeString + tileString + blackLine + "\n";
		return ret;
	}
}