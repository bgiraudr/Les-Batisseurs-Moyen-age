package batisseur;

import java.util.Random;
import util.RandomInt;

public class AutoPlayer extends Player {

	private Random rand;
	private Difficulty difficulty;

	/**
	 * Create an autoplayer using the name and the difficulty you want
	 * @param name
	 * @param board
	 * @param difficulty
	 */
	public AutoPlayer(String name, Board board, Difficulty difficulty) {
		super(name, board);
		this.difficulty = difficulty;
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
		return this.difficulty;
	}

	/**
	 * set the difficulty of the bot
	 * @param difficulty the new difficulty
	 **/
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
}