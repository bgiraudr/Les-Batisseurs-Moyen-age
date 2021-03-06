package batisseur;

import java.util.Scanner;
import util.ReadFile;
import java.util.InputMismatchException;
import util.RWGame;
import java.io.File;
import util.DesignString;
import java.io.IOException;
import java.awt.*;

import javax.swing.*;
import view.menu.*;

public class Batisseurs {

	private Mode mode;
	private Game gameplay;
	private UI gui;

	private static final String PATH_TITLE = "./data/files/titreBat.txt";
	private static final String PATH_MAIN_MENU = "./data/files/mainMenu.txt";
	private static final String SAVE_FOLDER = "./data/saves/";

	/**
	 * create and launch the game
	 */
	public Batisseurs() {
		this.gui = UI.TUI;
		this.menuAccueil();
	}

	/**
	 * create the main game with all the player
	 * @param playerName1 the first player name
	 * @param playerName2 the second player name 
	 * @param playerName3 the third player name 
	 * @param playerName4 the fourth player name 
	 * @param gui true if you want to play with the interface on
	 * @param mode the current mode
	 */
	private void createGame(String playerName1, String playerName2, String playerName3, String playerName4, Mode mode, UI gui) {
		this.gameplay = new Game(playerName1, playerName2, playerName3, playerName4, mode, gui);
		this.gameplay.start();
	}

	/**
	 * create the main menu
	 **/
	private void menuAccueil() {
		ReadFile.printFile(PATH_TITLE);
		System.out.println();
		ReadFile.printFile(PATH_MAIN_MENU);
		System.out.println();
		Scanner scan = new Scanner(System.in);

		int choix = 0;
		while(choix < 1 || choix > 5) {
			System.out.print("> ");
			choix = scan.nextInt();

			switch(choix) {
				case 1:
					configPartie();
					break;
				case 2:
					launchPartie();
					break;
				case 3:
					try {
						Desktop desktop = Desktop.getDesktop();
						File file = new File("./data/files/regles.pdf");
						desktop.open(file);
					} catch(IOException e) {
						e.printStackTrace();
					}
					break;
				case 4:
					this.gui = UI.GUI;
					DesignString.printBorder("/!\\ LA VERSION GRAPHIQUE N'EST PAS FONCTIONNELLE EN PARTIE");
					DesignString.printBorder("cependant vous pouvez en cr??er une et voir les cartes sur la table");
					DesignString.printBorder("aucune interaction n'a pu ??tre programm??e faute de temps");
					SwingUtilities.invokeLater(new Runnable() {
			            public void run() {
			                new Fenetre();
			            }
			        });
					break;
				case 5:
					System.out.println("?? la prochaine !");
					break;
				default:
					System.out.println("Veuillez saisir une valeur dans la liste");
					break;
			}
		}
	}

	/**
	 * config a game
	 **/
	private void configPartie() {
		try {
			Scanner scan = new Scanner(System.in);
			int choix = 0;
			System.out.println("Nombre de joueur ? (2 - 4)");
			System.out.print("> ");
			choix = scan.nextInt();
			while(choix < 2 || choix > 4) {
				System.out.println("Veuillez saisir une valeur entre 2 et 4");
				choix = scan.nextInt();
			}
			int nbJoueur = choix;

			System.out.println("Nombre d'ordi ? (0 - " + (nbJoueur-1) + ")");
			System.out.print("> ");
			choix = scan.nextInt();
			while(choix < 0 || choix > nbJoueur-1) {
				System.out.println("Veuillez saisir une valeur entre 0 et " + (nbJoueur-1));
				choix = scan.nextInt();
			}
			int nbOrdi = choix;

			Mode mode = Mode.valueOf("H".repeat(nbJoueur-nbOrdi)+"A".repeat(nbOrdi));

			String nom;
			String[] noms = new String[4];
			for(int i = 0; i < nbJoueur ; i++) {
				noms[i] = "Auto " + (i+1-(nbJoueur-nbOrdi));
			}
			for(int i = 0; i < nbJoueur-nbOrdi; i++) {
				System.out.println("Nom du joueur " + (i+1) + " ?");
				System.out.print("> ");
				nom = scan.next();
				while(nom == null) {
					System.out.println("Veuillez entrer un nom");
					nom = scan.next();
				}
				noms[i] = nom;
			}
			createGame(noms[0], noms[1], noms[2], noms[3], mode, this.gui);
		} catch(InputMismatchException e) {
			System.out.println("configPartie : Saisie invalide");
		}
	}

	/**
	 * launch a game from a savefile
	 **/
	private void launchPartie() {
		try {
			File saveFolder = new File(SAVE_FOLDER);
			String content[] = saveFolder.list();

			Scanner scan = new Scanner(System.in);

			System.out.println("???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
			System.out.println("???             Liste des sauvegardes             ???");
			System.out.println("???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
			for(String save : content) {
				String msg = String.format("??? %-" + 45  + "s ???", save.substring(0,save.length()-4));
				System.out.println(msg);
			}
			System.out.println("???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");

			DesignString.printBorder(35,"Entre le nom de ta sauvegarde", "\033[0;92m");
			System.out.print("> ");
			String saveFile = scan.next();
			Game game = RWGame.readGame(SAVE_FOLDER + saveFile + ".sav");
			this.gameplay = game;
			game.start();
		} catch(IOException e) {
			DesignString.printBorder(50,"ERREUR SAUVEGARDE", "\033[0;91m");
		}
	}

	/**
	 * get the current gameplay
	 * @return the game
	 **/
	public Game getGameplay() {
		return this.gameplay;
	}

}