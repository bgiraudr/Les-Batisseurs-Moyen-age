package batisseur;

public class Machine extends Card {

	private int point;

	/**
	 * Create a new card machine
	 * @param name
	 * @param wood
	 * @param stone
	 * @param knowledge
	 * @param tile
	 * @param point
	 * @param woodConstruct
	 * @param stoneConstruct
	 * @param knowledgeConstruct
	 * @param tileConstruct
	 */
	public Machine(String name, int wood, int stone, int knowledge, int tile, int point, int woodConstruct, int stoneConstruct, int knowledgeConstruct, int tileConstruct) {
		super(name, wood, stone, knowledge, tile);
	}

	public int getPoint() {
		return this.point;
	}

}