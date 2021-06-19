package batisseur;

import java.util.Scanner;

public class HumanPlayer extends Player {

	private Scanner scan;

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

		while(this.getAction() > 0) {
			this.getBoard().printBoard();
			System.out.println(this);

			System.out.println("Que veux tu faire ?");
			System.out.println("1 - Recruter un ouvrier");
			System.out.println("2 - Ouvrir un chantier");
			System.out.println("3 - Faire travailler des ouvriers");
			System.out.println("4 - Échanger des écus contre des actions");
			System.out.println("5 - Échanger des actions contre des pièces");
			System.out.println();

			int input = this.scan.nextInt();

			if(input == 1) {
				System.out.println("Indiquez l'identifiant de l'ouvrier :");
				System.out.print("> ");
				int choix = this.scan.nextInt();
				while(choix > 5 || choix < 0) {
					System.out.println("Veuillez renseigner un chiffre entre 1 et 5");
					System.out.print("> ");
					choix = this.scan.nextInt();
				}
				this.hireWorker(this.getBoard().getFiveWorkerCards().get(choix-1));
			}
			if(input == 2) {
				System.out.println("Indiquez l'identifiant du bâtiment :");
				System.out.print("> ");
				int choix = this.scan.nextInt();
				while(choix > 5 || choix < 0) {
					System.out.println("Veuillez renseigner un chiffre entre 1 et 5");
					System.out.print("> ");
					choix = this.scan.nextInt();
				}
				this.addBuilding(this.getBoard().getFiveBuildingCards().get(choix-1));
			}
			if(input == 3) {
				System.out.println("a");
			}
			if(input == 4) {
				System.out.println("Combien d'action voulez-vous ?");
				int valeur = this.scan.nextInt();
				this.buyAction(valeur);
			}
			if(input == 5) {
				System.out.println("Contre combien d'action ?");
				int valeur = this.scan.nextInt();
				this.actionToCoins(valeur);
			}
		}

	}

}