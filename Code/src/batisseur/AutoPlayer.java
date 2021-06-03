package batisseur;

public class AutoPlayer extends Player {

	private Random rand;

	/**
	 * Create an autoplayer
	 * @param name
	 * @param board
	 * @param difficulty
	 */
	public AutoPlayer(String name, Board board, Difficulty difficulty) {
		super(name, board);
	}

	/**
	 * play a lap
	 **/ 
	public void play() {
		// TODO - implement AutoPlayer.play
	}

	/**
	 * generate a pseudo random number between to value (include)
	 * @param min
	 * @param max
	 */
	public int randInt(int min, int max) {
		// TODO - implement AutoPlayer.randInt
	}

}