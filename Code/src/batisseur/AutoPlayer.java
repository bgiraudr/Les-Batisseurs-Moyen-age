package batisseur;

import java.util.Random;
import util.RandomInt;
import util.DesignString;

public class AutoPlayer extends Player {

	private Random rand;
	private static Difficulty difficulty = Difficulty.EASY;

	/**
	 * Create an autoplayer using the name and the difficulty you want
	 * @param name the name of the player
	 * @param board the current board
	 */
	public AutoPlayer(String name, Board board) {
		super(name, board);
		this.rand = new Random();
	}

	/**
	 * do the player play
	 **/ 
	public void play() {
		this.initializeTurn();
		while(this.getAction() > 0) {
			int choix = RandomInt.randomInt(1,6, this.rand);
			if(choix == 1) {
				//add building, preference of Machine
				int max = 0;
				int maxi = 0;
				boolean find = false;
				for(int i = 0; i < this.getBoard().getFiveBuildingCards().size(); i++) {
					if(this.getBoard().getFiveBuildingCards().get(i) != null) {
						if(this.getBoard().getFiveBuildingCards().get(i) instanceof Machine) {
							maxi = i;
							find = true;
						}
						if(this.getBoard().getFiveBuildingCards().get(i).getPoint() > max && !find) {
							max = this.getBoard().getFiveBuildingCards().get(i).getPoint();
							maxi = i;
						}
					}
				}
				this.addBuilding(this.getBoard().getFiveBuildingCards().get(maxi));
				DesignString.printBorder("Ouverture d'un chantier");
			}
			else if(choix == 2 || choix == 3) {
				//add worker, preference of the lowest one
				int min = 999;
				int mini = 0;
				for(int i = 0; i < this.getBoard().getFiveWorkerCards().size(); i++) {
					if(this.getBoard().getFiveWorkerCards().get(i) != null) {
						if(this.getBoard().getFiveWorkerCards().get(i).getCost() < min && this.getBoard().getFiveWorkerCards().get(i).getCost() >= this.getCoin()) {
							min = this.getBoard().getFiveWorkerCards().get(i).getCost();
							mini = i;
						}
					}
				}
				if(this.getBoard().getFiveWorkerCards().get(mini).getCost() >= this.getCoin()) {
					DesignString.printBorder("Échange action vers écus");
					this.actionToCoins(RandomInt.randomInt(1,this.getAction(), this.rand));
					
				} else {
					DesignString.printBorder("Recrutement d'un ouvrier");
					this.hireWorker(this.getBoard().getFiveWorkerCards().get(mini));
					
				}
			}
			else if(choix == 4 || choix == 5 || choix == 6) {
				//worker to building. Preference to the started building. If it can't play, preference to action to coin
				IBuilding building = null;
				IWorker worker = null;
				if(this.getWorkerCards().size() > 0) {
					if(this.getStartedBuilding().size() > 0) {
						choix = RandomInt.randomInt(0,2,this.rand);
						if(choix%2 == 0) {
							int max = 0;
							int maxi = 0;
							for(int i = 0; i < this.getStartedBuilding().size(); i++) {
								if(this.getStartedBuilding().get(i) != null) {
									if(this.getStartedBuilding().get(i).getWorkerOn().size() > max) {
										max = this.getStartedBuilding().get(i).getWorkerOn().size();
										maxi = i;
									}
								}
							}
							building = this.getStartedBuilding().get(maxi);

							worker = this.getWorkerCards().get(RandomInt.randomInt(0,this.getWorkerCards().size()-1, this.rand));

							while(worker != null && worker.getCost() > this.getCoin() && this.getAction() > 0) {
								worker = this.getWorkerCards().get(RandomInt.randomInt(0,this.getWorkerCards().size()-1, this.rand));
								choix = RandomInt.randomInt(1,5,this.rand);
								if(choix == 1) {
									DesignString.printBorder("Échange action vers écus");
									this.actionToCoins(RandomInt.randomInt(1,this.getAction(), this.rand));
									
								}
							}
							if(this.getAction() >= this.getRemoveBuilding(building)) {
								DesignString.printBorder("Envoi d'un ouvrier sur un chantier");
								this.workerToBuilding(worker, building);
								
							}
						} else {
							building = this.getBuildingsCards().get(RandomInt.randomInt(0,this.getBuildingsCards().size()-1, this.rand));
							while(building == null) {
								building = this.getBuildingsCards().get(RandomInt.randomInt(0,this.getBuildingsCards().size()-1, this.rand));
							}
							worker = this.getWorkerCards().get(RandomInt.randomInt(0,this.getWorkerCards().size()-1, this.rand));
							while(worker != null && worker.getCost() > this.getCoin() && this.getAction() > 0) {
								worker = this.getWorkerCards().get(RandomInt.randomInt(0,this.getWorkerCards().size()-1, this.rand));
								choix = RandomInt.randomInt(1,5,this.rand);
								if(choix == 1) {
									DesignString.printBorder("Échange action vers écus");
									this.actionToCoins(RandomInt.randomInt(1,this.getAction(), this.rand));
									
								}
							}
							if(this.getAction() >= this.getRemoveBuilding(building)) {
								DesignString.printBorder("Envoi d'un ouvrier sur un chantier");
								this.workerToBuilding(worker, building);
								
							}
						}
					} else if(this.getBuildingsCards().size() > 0) {
						building = this.getBuildingsCards().get(RandomInt.randomInt(0,this.getBuildingsCards().size()-1, this.rand));
						while(building == null) {
							building = this.getBuildingsCards().get(RandomInt.randomInt(0,this.getBuildingsCards().size()-1, this.rand));
						}
						worker = this.getWorkerCards().get(RandomInt.randomInt(0,this.getWorkerCards().size()-1, this.rand));
						while(worker != null && worker.getCost() > this.getCoin() && this.getAction() > 0) {
							worker = this.getWorkerCards().get(RandomInt.randomInt(0,this.getWorkerCards().size()-1, this.rand));
							choix = RandomInt.randomInt(1,5,this.rand);
							if(choix == 1) {
								DesignString.printBorder("Échange action vers écus");
								this.actionToCoins(RandomInt.randomInt(1,this.getAction(), this.rand));
								
							}
						}
						if(this.getAction() >= this.getRemoveBuilding(building)) {
							DesignString.printBorder("Envoi d'un ouvrier sur un chantier");
							this.workerToBuilding(worker, building);
							
						}
					}
				}
			}
		}
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