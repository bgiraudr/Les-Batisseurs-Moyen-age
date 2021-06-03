package batisseur;

public class Building extends Card {

	private int coin;
	private int point;

	/**
	 * Create a new building card
	 * @param name
	 * @param wood
	 * @param stone
	 * @param knowledge
	 * @param tile
	 * @param coin
	 * @param point
	 */
	public Building(String name, int wood, int stone, int knowledge, int tile, int coin, int point) {
		super(name, wood, stone, knowledge, tile);
	}

	public ArrayList<Worker> getWorkerOn() {
		// TODO - implement Building.getWorkerOn
	}

	public int getCoin() {
		return this.coin;
	}

	public int getPoint() {
		return this.point;
	}

}