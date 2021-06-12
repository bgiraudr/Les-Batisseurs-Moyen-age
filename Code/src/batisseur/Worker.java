package batisseur;

public class Worker extends Card {

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
	public Worker(String name, int wood, int stone, int knowledge, int tile, int cost) {
		super(name, wood, stone, knowledge, tile);
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

}