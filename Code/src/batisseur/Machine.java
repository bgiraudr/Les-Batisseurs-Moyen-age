package batisseur;

public class Machine extends Card {

	private int point;

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
	public Machine(String name, int wood, int stone, int knowledge, int tile, int point, int woodConstruct, int stoneConstruct, int knowledgeConstruct, int tileConstruct) {
		super(name, wood, stone, knowledge, tile);
	}

	/**
	 * get the number of point the machine product
	 * @return the number of point
	 **/
	public int getPoint() {
		return this.point;
	}

}