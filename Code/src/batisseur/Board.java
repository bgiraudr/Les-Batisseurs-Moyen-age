package batisseur;

import java.util.ArrayList;
import java.util.Random;
import util.RandomInt;
import util.DesignString;

import java.util.Scanner; 
import java.io.FileReader;
import java.io.FileNotFoundException;

import java.io.Serializable;

public class Board implements Serializable {

	private ArrayList<Card> worker_cards;
	private ArrayList<Card> building_cards;
	private ArrayList<Card> machine_cards;

	public ArrayList<IWorker> five_worker_cards;
	public ArrayList<IBuilding> five_building_cards;

	private Game game;

	private Random rand;

	public Board(Game game) {
		this.rand = new Random();

		this.game = game;

		this.worker_cards = new ArrayList<Card>();
		this.building_cards = new ArrayList<Card>();
		this.machine_cards = new ArrayList<Card>();
		this.five_worker_cards = new ArrayList<IWorker>();
		this.five_building_cards = new ArrayList<IBuilding>();

		this.createWorkerCards("../data/cards/ouvriers.txt");
		this.createBuildingCards("../data/cards/batiments.txt");
		this.createMachineCards("../data/cards/machines.txt");

		this.generateBoardWorker();
		this.generateBoardBuilding();
	}

	public Game getGame() {
		return this.game;
	}

	/**
	 * create all the cards using the file
	 * @param fileName the source file
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
	 * @param fileName the source file
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
	 * @param fileName the source file
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

	public void removeWorkerCards(IWorker worker) {
		this.five_worker_cards.remove(worker);
	}

	/**
	 * pick a random card on an array
	 * @param array the arrayList of Card
	 * @return the arraylist containing the building cards
	 **/
	public Card pickRandomCard(ArrayList<Card> array) {
		Card randCard = null;
		if(!checkEmpty()) {
			if(array != null) {
				int i = RandomInt.randomInt(0, array.size()-1, this.rand);
				randCard = array.get(i);
			} else {
				System.err.println("pickRandomCard : array null");
			}
		}
		return randCard;
	}

	/**
	 * generate the five board workers
	 **/
	public void generateBoardWorker() {
		while(this.five_worker_cards.size() < 5) {
			Card card = pickRandomCard(this.worker_cards);
			this.worker_cards.remove(card);
			this.five_worker_cards.add((IWorker)card);
		}
	}

	public ArrayList<Card> getApprentiCard() {
		ArrayList<Card> ret = new ArrayList<Card>();
		for(Card card : this.worker_cards) {
			if(card.getName().equals("Apprenti")) {
				ret.add(card);
			}
		}
		return ret;
	}

	public Card generateInitApprenti() {
		Card card = pickRandomCard(this.worker_cards);
		this.worker_cards.remove(card);
		return card;
	}

	/**
	 * generate the five board buildings (include machine)
	 **/
	public void generateBoardBuilding() {
		while(this.five_building_cards.size() < 5) {
			Card card;
			int number = RandomInt.randomInt(1, this.building_cards.size() + this.machine_cards.size(), this.rand);
			if(number < this.machine_cards.size()) {
				card = pickRandomCard(this.machine_cards);
				this.machine_cards.remove(card);
			} else {
				card = pickRandomCard(this.building_cards);
				this.building_cards.remove(card);
			}
			this.five_building_cards.add((IBuilding)card);
		}
	}

	/**
	 * get all of the five worker cards on the board
	 * @return the arraylist containing the worker cards
	 **/
	public ArrayList<IWorker> getFiveWorkerCards() {
		return this.five_worker_cards;
	}

	/**
	 * get all of the five building cards on the board
	 * @return the arraylist containing the building cards
	 **/
	public ArrayList<IBuilding> getFiveBuildingCards() {
		return this.five_building_cards;
	}

	public boolean checkEmpty() {
		boolean ret = false;
		if(this.getWorkerCards().size() == 0 || this.getBuildingCards().size() == 0) {
			ret = true;
		}
		return ret;
	}

	public void printBoard() {
		int rightBorder = 34;

		DesignString.printBorder(190,"CHANTIERS", "\033[0;91m");

		for(int i = 0; i < this.five_building_cards.get(0).toString().lines().count(); i++) {
			if(i == 0) {
				for(int j = 0; j < 5; j++) {
					if(this.five_building_cards.get(j) != null) {
						String count = DesignString.centerString(rightBorder, String.format("~ " + (j+1) + " ~"));
						System.out.print("\033[93m" + count + "\t\033[0m");
					}
				}
				System.out.println();
			}
			for(IBuilding b : this.five_building_cards) {
				if(b != null) {
					String line = b.toString().substring(0+(rightBorder+1)*i, rightBorder+(rightBorder+1)*i);
					System.out.print(line + "\t");
				}
			}
			System.out.println();
		}

		System.out.println();
		DesignString.printBorder(190,"OUVRIERS","\033[0;91m");

		for(int i = 0; i < this.five_worker_cards.get(0).toString().lines().count(); i++) {
			if(i == 0) {
				for(int j = 0; j < 5; j++) {
					if(this.five_worker_cards.get(j) != null) {
						String count = DesignString.centerString(rightBorder, String.format("~ " + (j+1) + " ~"));
						System.out.print("\033[93m" + count + "\t\033[0m");
					}
				}
				System.out.println();
			}
			for(IWorker b : this.five_worker_cards) {
				if(b != null) {
					String line = b.toString().substring(0+(rightBorder+1)*i, rightBorder+(rightBorder+1)*i);
					System.out.print(line + "\t");
				}
			}
			System.out.println();
		}
	}

	public void printPlayers() {
		int rightBorder = 19;
		for(int i = 0; i < this.game.getAllPlayers()[0].toString().lines().count(); i++) {
			for(Player p : this.game.getAllPlayers()) {
				if(p != null) {
					String line = p.toString().substring(0+(rightBorder+1)*i, rightBorder+(rightBorder+1)*i);
					System.out.print(line + "\t");
				}
			}
			System.out.println();
		}
	}
}