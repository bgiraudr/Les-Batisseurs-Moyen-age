package batisseur;

import java.util.ArrayList;
import java.util.Random;
import util.RandomInt;

import java.util.Scanner; 
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Board {

	private ArrayList<Card> worker_cards;
	private ArrayList<Card> building_cards;
	private ArrayList<Card> machine_cards;

	private Random rand;

	public Board() {
		this.rand = new Random();

		this.worker_cards = new ArrayList<Card>();
		this.building_cards = new ArrayList<Card>();
		this.machine_cards = new ArrayList<Card>();
		this.createWorkerCards("../data/ouvriers.txt");
		this.createBuildingCards("../data/batiments.txt");
		this.createMachineCards("../data/machines.txt");
	}

	/**
	 * create all the cards using the file
	 **/
	public void createWorkerCards(String fileName) {
		try {
			Scanner in = new Scanner(new FileReader(fileName));
			while(in.hasNext()) {
				String line = in.nextLine();
				line.trim();
				Scanner inLine = new Scanner(line).useDelimiter(":");
				String name = inLine.next();
				int cost = inLine.nextInt();
				int stone = inLine.nextInt();
				int wood = inLine.nextInt();
				int knowledge = inLine.nextInt();
				int tile = inLine.nextInt();

				this.worker_cards.add(new Worker(name, stone, wood, knowledge, tile, cost));
			}
			in.close();
		} catch(FileNotFoundException e) {
			System.err.println("createWorkerCards : " + fileName + " not found");
		}
	}

	/**
	 * create all the cards using the file
	 **/
	public void createBuildingCards(String fileName) {
		try {
			Scanner in = new Scanner(new FileReader(fileName));
			while(in.hasNext()) {
				String line = in.nextLine();
				line.trim();
				Scanner inLine = new Scanner(line).useDelimiter(":");
				String name = inLine.next();
				int coin = inLine.nextInt();
				int point = inLine.nextInt();
				int stone = inLine.nextInt();
				int wood = inLine.nextInt();
				int knowledge = inLine.nextInt();
				int tile = inLine.nextInt();

				this.building_cards.add(new Building(name, stone, wood, knowledge, tile, coin, point));
			}
			in.close();
		} catch(FileNotFoundException e) {
			System.err.println("createBuildingCards : " + fileName + " not found");
		}
	}

	/**
	 * create all the cards using the file
	 **/
	public void createMachineCards(String fileName) {
		try {
			Scanner in = new Scanner(new FileReader(fileName));
			while(in.hasNext()) {
				String line = in.nextLine();
				line.trim();
				Scanner inLine = new Scanner(line).useDelimiter(":");
				String name = inLine.next();
				int stoneConstruct = inLine.nextInt();
				int woodConstruct = inLine.nextInt();
				int knowledgeConstruct = inLine.nextInt();
				int tileConstruct = inLine.nextInt();
				int point = inLine.nextInt();
				int stone = inLine.nextInt();
				int wood = inLine.nextInt();
				int knowledge = inLine.nextInt();
				int tile = inLine.nextInt();

				this.machine_cards.add(new Machine(name, stone, wood, knowledge, tile, point, stoneConstruct, woodConstruct, knowledgeConstruct, tileConstruct));
			}
			in.close();
		} catch(FileNotFoundException e) {
			System.err.println("createBuildingCards : " + fileName + " not found");
		}
	}

	/**
	 * get all of the worker cards
	 * @return the arraylist containing the worker cards
	 **/
	public ArrayList<Card> getWorkerCards() {
		return this.worker_cards;
	}

	/**
	 * get all of the building cards
	 * @return the arraylist containing the building cards
	 **/
	public ArrayList<Card> getBuildingCards() {
		return this.building_cards;
	}

	/**
	 * get all of the machine cards
	 * @return the arraylist containing the building cards
	 **/
	public ArrayList<Card> getMachineCards() {
		return this.machine_cards;
	}

	public Card pickRandomCard(ArrayList<Card> array) {
		Card randCard = null;
		if(array != null) {
			int i = RandomInt.randomInt(0, array.size()-1, this.rand);
			randCard = array.get(i);
		} else {
			System.err.println("pickRandomCard : array null");
		}
		return randCard;
	}
}