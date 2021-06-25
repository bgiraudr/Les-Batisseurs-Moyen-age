package batisseur;

import java.util.Scanner;
import util.DesignString;
import java.lang.NumberFormatException;
import java.lang.Thread;

public class HumanPlayer extends Player {

	private transient Scanner scan;

	/**
	 * Create a new Human player
	 * @param name the name of the player
	 * @param board the current board
	 */
	public HumanPlayer(String name, Board board) {
		super(name, board);
		this.scan = new Scanner(System.in);
	}

	/**
	 * play
	 **/
	public void play() {

		//when a file is loaded, you must recreate the transient scanner
		if(this.scan == null) {
			this.scan = new Scanner(System.in);
		}

		this.initializeTurn();

		this.getBoard().printBoard();
		System.out.println();
		boolean continuer = true;
		while(this.getAction() > 0 && continuer) {
			DesignString.printBorder(25,"ACTIONS : " + this.getAction(), "\033[0;93m");
			DesignString.printBorder(25,"ÉCUS : " + this.getCoin(), "\033[0;93m");
			System.out.println("╭───────────────────────────────────────────────╮");
			System.out.println("│              Que veux tu faire ?              │");
			System.out.println("├───────────────────────────────────────────────┤");
			System.out.println("│ 1 - Ouvrir un chantier                        │");
			System.out.println("│ 2 - Recruter un ouvrier                       │");
			System.out.println("│ 3 - Voir vos ouvriers                         │");
			System.out.println("│ 4 - Voir vos chantiers                        │");
			System.out.println("│ 5 - Voir l'avancement sur vos chantiers       │");
			System.out.println("│ 6 - Faire travailler des ouvriers             │");
			System.out.println("│ 7 - Échanger des écus contre des actions      │");
			System.out.println("│ 8 - Échanger des actions contre des écus      │");
			System.out.println("│ 9 - Afficher les profils                      │");
			System.out.println("│ 10 - Quitter et sauvegarder                   │");
			System.out.println("│ 11 - Quitter                                  │");
			System.out.println("╰───────────────────────────────────────────────╯");
			System.out.println();
			System.out.print("> ");

			String input = this.scan.next();

			if(input.equals("1")) {
				this.getBoard().printBoard();
				System.out.println();

				System.out.println("Indiquez l'identifiant du bâtiment :");
				System.out.println("Veuillez renseigner un chiffre entre 1 et 5 ou R pour revenir en arrière");
				System.out.print("> ");
				String choix = "";
				boolean valid = false;

				while(!valid) {
					choix = this.scan.next();
					try {
						if(Integer.parseInt(choix) < 6 && Integer.parseInt(choix) > 0) {
							valid = true;
						} else {
							System.out.println("Saisie incorrecte");
							System.out.print("> ");
						}
					} catch (NumberFormatException e) {
						if(choix.equals("R")) {
							valid = true;
						} else {
							System.out.println("Saisie incorrecte");
							System.out.print("> ");
						}
					}
				}
				if(!choix.equals("R")) {
					DesignString.printBorder(25,"Succès !", "\033[1;92m");
					DesignString.printBorder(25,"Vous perdez une action", "\033[0;91m");
					this.addBuilding(this.getBoard().getFiveBuildingCards().get(Integer.parseInt(choix)-1));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if(input.equals("2")) {
				this.getBoard().printBoard();
				System.out.println();

				System.out.println("Indiquez l'identifiant de l'ouvrier");
				System.out.println("Veuillez renseigner un chiffre entre 1 et 5 ou R pour revenir en arrière");
				System.out.print("> ");
				String choix = "";
				boolean valid = false;

				while(!valid) {
					choix = this.scan.next();
					try {
						if(Integer.parseInt(choix) < 6 && Integer.parseInt(choix) > 0) {
							valid = true;
						} else {
							System.out.println("Saisie incorrecte");
							System.out.print("> ");
						}
					} catch (NumberFormatException e) {
						if(choix.equals("R")) {
							valid = true;
						} else {
							System.out.println("Saisie incorrecte");
							System.out.print("> ");
						}
					}
				}
				if(!choix.equals("R")) {
					DesignString.printBorder(25,"Succès !", "\033[1;92m");
					DesignString.printBorder(25,"Vous perdez une action", "\033[0;91m");
					DesignString.printBorder(25,"Vous perdez " + this.getBoard().getFiveWorkerCards().get(Integer.parseInt(choix)-1).getCost() + " écus", "\033[0;91m");
					this.hireWorker(this.getBoard().getFiveWorkerCards().get(Integer.parseInt(choix)-1));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if(input.equals("3")) {
				if(this.getWorkerCards().size() > 5) {
					int i = 0;
					DesignString.printBorder(50,"Vous avez " + this.getWorkerCards().size() + " ouvriers");

					String choix = "";
					while(!choix.equals("R")) {
						this.printWorkers(i);
						DesignString.printBorder(70,"Pour naviguer, indiquez Q ou D. R pour quitter cette page.");
						System.out.print("> ");
						choix = this.scan.next();
						if(choix.equals("D") || choix.equals("d")) {
							if(i+5 < this.getWorkerCards().size()) {
								i+=5;
							}
						}
						if(choix.equals("Q") || choix.equals("q")) {
							if(i-5 >= 0) {
								i-=5;
							} else {
								i = 0;
							}
						}
					}
				} else {
					this.printWorkers(0);
				}
			}
			if(input.equals("4")) {
				if(this.getBuildingsCards().size() > 5) {
					int i = 0;
					DesignString.printBorder(70,"Vous avez " + this.getBuildingsCards().size() + " bâtiments");

					String choix = "";
					while(!choix.equals("R")) {
						this.printBuildings(i);
						DesignString.printBorder(70,"Pour naviguer, indiquez Q ou D. R pour quitter cette page.");
						System.out.print("> ");
						choix = this.scan.next();
						if(choix.equals("D") || choix.equals("d")) {
							if(i+5 < this.getBuildingsCards().size()) {
								i+=5;
							}
						}
						if(choix.equals("Q") || choix.equals("q")) {
							if(i-5 >= 0) {
								i-=5;
							} else {
								i = 0;
							}
						}
					}
				} else {
					this.printBuildings(0);
				}
			}
			if(input.equals("5")) {
				if(this.getStartedBuilding().size() > 5) {
					int i = 0;
					DesignString.printBorder(70,"Vous avez " + this.getStartedBuilding().size() + " bâtiments commencés");

					String choix = "";
					while(!choix.equals("R")) {
						this.printStartedBuilding(i);
						DesignString.printBorder(70,"Pour naviguer, indiquez Q ou D. R pour quitter cette page.");
						System.out.print("> ");
						choix = this.scan.next();
						if(choix.equals("D") || choix.equals("d")) {
							if(i+5 < this.getStartedBuilding().size()) {
								i+=5;
							}
						}
						if(choix.equals("Q") || choix.equals("q")) {
							if(i-5 >= 0) {
								i-=5;
							} else {
								i = 0;
							}
						}
					}
				} else {
					this.printStartedBuilding(0);
				}
			}
			if(input.equals("6")) {
				DesignString.printBorder(70,"Veuillez regarder vos cartes avant de faire cette action");
				DesignString.printBorder(70,"Veuillez indiquer le numéro du bâtiment. R pour revenir en arrière");
				String choix = "";
				boolean valid = false;
				IBuilding b = null;
				IWorker w = null;
				try {
					while(!valid) {
						System.out.print("> ");
						choix = this.scan.next();
						if(Integer.parseInt(choix) > 0 && Integer.parseInt(choix) <= this.getBuildingsCards().size()) {
							valid = true;
						} else {
							System.out.println("Saisie incorrecte");
						}
					}
					valid = false;
					b = this.getBuildingsCards().get(Integer.parseInt(choix)-1);

					DesignString.printBorder(70,"Veuillez indiquer le numéro de l'ouvrier. R pour revenir en arrière");
					while(!valid) {
						System.out.print("> ");
						choix = this.scan.next();
						if(Integer.parseInt(choix) > 0 && Integer.parseInt(choix) <= this.getWorkerCards().size()) {
							valid = true;
						} else {
							System.out.println("Saisie incorrecte");
						}
					}
					w = this.getWorkerCards().get(Integer.parseInt(choix)-1);
				} catch (NumberFormatException e) {
					System.out.println("Saisie incorrecte.");
				}

				if(!choix.equals("R")) {
					int ancien = this.getAction();
					this.workerToBuilding(w,b);
					if(this.getAction() < ancien) {
						DesignString.printBorder(25,"Succès !", "\033[1;92m");
						DesignString.printBorder(25,"Vous perdez " + (this.getRemoveBuilding(b)-1) + " action", "\033[0;91m");
					} else {
						DesignString.printBorder(35,"Pas assez d'écus ou d'action", "\033[1;91m");
					}
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
			if(input.equals("7")) {
				DesignString.printBorder(100, "Vous avez " + this.getCoin() + " écus. Avec ça, vous pouvez acheter jusqu'à " + (int)(this.getCoin() / 5) + " actions. (5 écus = 1 action)", "\033[0;93m");
				System.out.print("> ");
				String valeur = this.scan.next();
				try {
					int val = Integer.parseInt(valeur);
					int ancien = this.getAction();
					this.buyAction(val);
					if(ancien < this.getAction()) {
						DesignString.printBorder(25,"Succès !", "\033[1;92m");
					}
				} catch (NumberFormatException e) {
					System.out.println("Saisie incorrecte.");
				}
			}
			if(input.equals("8")) {
				DesignString.printBorder(75, "1 action -> 1 écu ; 2 actions -> 3 écus ; 3 actions -> 6 écus", "\033[0;93m");
				System.out.print("> ");
				String valeur = this.scan.next();
				try {
					int val = Integer.parseInt(valeur);
					int ancien = this.getCoin();
					this.actionToCoins(val);
					if(ancien < this.getCoin()) {
						DesignString.printBorder(25,"Succès !", "\033[1;92m");
					}
				} catch (NumberFormatException e) {
					System.out.println("Saisie incorrecte.");
				}
			}
			if(input.equals("9")) {
				DesignString.printBorder(80,"JOUEURS", "\033[0;91m");
				this.getBoard().printPlayers();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if(input.equals("10")) {
				this.getBoard().getGame().saveGame();
				continuer = false;
			}
			if(input.equals("11")) {
				System.exit(0);
			}
		}
	}
}