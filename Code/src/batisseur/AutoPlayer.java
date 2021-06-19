package batisseur;

import java.util.Random;
import util.RandomInt;

public class AutoPlayer extends Player {

	private Random rand;
	private static Difficulty difficulty = Difficulty.EASY;

	/**
	 * Create an autoplayer using the name and the difficulty you want
	 * @param name
	 * @param board
	 * @param difficulty
	 */
	public AutoPlayer(String name, Board board) {
		super(name, board);
		this.rand = new Random();
	}

	/**
	 * do the player play
	 **/ 
	public void play() {
		// TODO - implement AutoPlayer.play
	}

	/**
	 * get the difficulty of the bot
	 * @return the difficulty
	 **/
	public Difficulty getDifficulty() {
		return difficulty;
	}

	/**
	 * set the difficulty of the bot
	 * @param newDifficulty the new difficulty
	 **/
	public void setDifficulty(Difficulty newDifficulty) {
		difficulty = newDifficulty;
	}
}