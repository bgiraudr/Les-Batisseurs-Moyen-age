package batisseur;

public abstract class Card {

	private String name;
	private int wood;
	private int stone;
	private int knowledge;
	private int tile;

	/**
	 * Create a new card
	 * @param name
	 * @param wood
	 * @param stone
	 * @param knowledge
	 * @param tile
	 */
	public Card(String name, int wood, int stone, int knowledge, int tile) {
		// TODO - implement Card.Card
	}

	public int getWood() {
		return this.wood;
	}

	public int getStone() {
		return this.stone;
	}

	public int getKnowledge() {
		return this.knowledge;
	}

	public int getTile() {
		return this.tile;
	}

}