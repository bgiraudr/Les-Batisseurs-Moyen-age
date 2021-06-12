package batisseur;

import java.util.ArrayList;
import java.util.Random;
import util.RandomInt;

public class Board {

	private ArrayList<Card> worker_cards;
	private ArrayList<Card> building_cards;

	public Board() {

	}

	/**
	 * create all the cards using the file
	 **/
	public void createCards() {
		// TODO - implement Board.createCards
	}

	/**
	 * get the worker cards on the board
	 * @return the arraylist containing the worker cards on the board
	 **/
	public ArrayList<Card> getWorkerCards() {
		return this.worker_cards;
	}

	/**
	 * get the building cards on the board
	 * @return the arraylist containing the building cards on the board
	 **/
	public ArrayList<Card> getBuildingCards() {
		return this.building_cards;
	}
}