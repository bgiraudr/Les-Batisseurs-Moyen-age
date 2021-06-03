package batisseur;

public class Worker extends Card {

	private int cost;

	/**
	 * Generate a new Worker
	 * @param name
	 * @param wood
	 * @param stone
	 * @param knowledge
	 * @param tile
	 * @param cost
	 */
	public Worker(String name, int wood, int stone, int knowledge, int tile, int cost) {
		super(name, wood, stone, knowledge, tile);
	}

	public int getCost() {
		return this.cost;
	}

}