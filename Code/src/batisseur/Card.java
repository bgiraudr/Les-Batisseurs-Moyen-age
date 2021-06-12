package batisseur;

public abstract class Card {

	private String name;
	private int wood;
	private int stone;
	private int knowledge;
	private int tile;

	/**
	 * Create a new card
	 * @param name the name
	 * @param wood the number of wood
	 * @param stone the number of stone
	 * @param knowledge the number of knowledge
	 * @param tile the number of tile
	 */
	public Card(String name, int wood, int stone, int knowledge, int tile) {
		if(name != null) {
			this.name = name;
			this.wood = wood;
			this.stone = stone;
			this.knowledge = knowledge;
			this.tile = tile;
		} else {
			System.err.println("Card : name null");
		}
	}

	/**
	 * get the wood value of the card
	 * @return the wood
	 **/
	public int getWood() {
		return this.wood;
	}

	/**
	 * get the stone value of the card
	 * @return the stone
	 **/
	public int getStone() {
		return this.stone;
	}

	/**
	 * get the knowledge value of the card
	 * @return the knowledge
	 **/
	public int getKnowledge() {
		return this.knowledge;
	}

	/**
	 * get the tile value of the card
	 * @return the tile
	 **/
	public int getTile() {
		return this.tile;
	}

	/**
	 * get the name of the card
	 * @return the name
	 **/
	public String getName() {
		return this.name;
	}

}