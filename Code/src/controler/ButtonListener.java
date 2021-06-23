/**
 * 
 * @author Benjamin Giraud-Renard
 **/

package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

import batisseur.*;
import view.menu.*;

public class ButtonListener implements ActionListener {

	private Fenetre fenetre;

	/*
	* create the listener for all the button or component
	*/
	public ButtonListener(Fenetre fenetre) {
		this.fenetre = fenetre;
	}

	/*
	* detect a click on a button
	*/
	public void actionPerformed(ActionEvent paramActionEvent) {

		//MENU PRINCIPAL//
		if(paramActionEvent.getSource() == this.fenetre.getMenuPrincipal().getNouvellePartie()) {
			switchTo("new1");
		}
		if(paramActionEvent.getSource() == this.fenetre.getMenuPrincipal().getCharger()) {
			switchTo("charger");
		}
		if(paramActionEvent.getSource() == this.fenetre.getMenuPrincipal().getRegle()) {
			try {
				Desktop desktop = Desktop.getDesktop();
				File file = new File("../data/files/regles.pdf");
				desktop.open(file);
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		if(paramActionEvent.getSource() == this.fenetre.getMenuPrincipal().getQuitter()) {
			System.exit(0);
		}

		//NOUVELLE PARTIE 1//
		if(paramActionEvent.getSource() == this.fenetre.getNouvellePartie().getRetour()) {
			switchTo("menu");
		}
		if(paramActionEvent.getSource() == this.fenetre.getNouvellePartie().getSuivant()) {
			this.fenetre.getChoixOrdi().updateButton(this.fenetre.getNouvellePartie().getNbPlayer(), this);
			switchTo("new2");
		}
		if(paramActionEvent.getSource() == this.fenetre.getNouvellePartie().getDeuxJoueur()) {
			this.fenetre.getNouvellePartie().getDeuxJoueur().setBorder(BorderFactory.createLineBorder(Color.RED, 4));
			this.fenetre.getNouvellePartie().getTroisJoueur().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
			this.fenetre.getNouvellePartie().getQuatreJoueur().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));

			this.fenetre.getNouvellePartie().getDeuxJoueur().setForeground(Color.RED);
			this.fenetre.getNouvellePartie().getTroisJoueur().setForeground(Color.WHITE);
			this.fenetre.getNouvellePartie().getQuatreJoueur().setForeground(Color.WHITE);
			this.fenetre.getNouvellePartie().setNbPlayer(2);
		}
		if(paramActionEvent.getSource() == this.fenetre.getNouvellePartie().getTroisJoueur()) {
			this.fenetre.getNouvellePartie().getDeuxJoueur().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
			this.fenetre.getNouvellePartie().getTroisJoueur().setBorder(BorderFactory.createLineBorder(Color.RED, 4));
			this.fenetre.getNouvellePartie().getQuatreJoueur().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));

			this.fenetre.getNouvellePartie().getDeuxJoueur().setForeground(Color.WHITE);
			this.fenetre.getNouvellePartie().getTroisJoueur().setForeground(Color.RED);
			this.fenetre.getNouvellePartie().getQuatreJoueur().setForeground(Color.WHITE);
			this.fenetre.getNouvellePartie().setNbPlayer(3);
		}
		if(paramActionEvent.getSource() == this.fenetre.getNouvellePartie().getQuatreJoueur()) {
			this.fenetre.getNouvellePartie().getDeuxJoueur().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
			this.fenetre.getNouvellePartie().getTroisJoueur().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
			this.fenetre.getNouvellePartie().getQuatreJoueur().setBorder(BorderFactory.createLineBorder(Color.RED, 4));

			this.fenetre.getNouvellePartie().getDeuxJoueur().setForeground(Color.WHITE);
			this.fenetre.getNouvellePartie().getTroisJoueur().setForeground(Color.WHITE);
			this.fenetre.getNouvellePartie().getQuatreJoueur().setForeground(Color.RED);
			this.fenetre.getNouvellePartie().setNbPlayer(4);
		}

		//NOUVELLE PARTIE 2//
		if(paramActionEvent.getSource() == this.fenetre.getChoixOrdi().getRetour()) {
			switchTo("new1");
		}
		if(paramActionEvent.getSource() == this.fenetre.getChoixOrdi().getCreer()) {
			this.fenetre.dispose();
			int nbp = this.fenetre.getNouvellePartie().getNbPlayer();
			int nbo = this.fenetre.getChoixOrdi().getNbOrdi();
			Mode mode = Mode.valueOf("H".repeat(nbp-nbo)+"A".repeat(nbo));
			Game game = new Game("P1","P2","P3","P4",mode, UI.GUI);
		}
		
		if(paramActionEvent.getSource() == this.fenetre.getChoixOrdi().getZeroOrdi()) {
			this.fenetre.getChoixOrdi().getZeroOrdi().setBorder(BorderFactory.createLineBorder(Color.RED, 4));
			this.fenetre.getChoixOrdi().getUnOrdi().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
			this.fenetre.getChoixOrdi().getDeuxOrdi().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
			this.fenetre.getChoixOrdi().getTroisOrdi().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));

			this.fenetre.getChoixOrdi().getZeroOrdi().setForeground(Color.RED);
			this.fenetre.getChoixOrdi().getUnOrdi().setForeground(Color.WHITE);
			this.fenetre.getChoixOrdi().getDeuxOrdi().setForeground(Color.WHITE);
			this.fenetre.getChoixOrdi().getTroisOrdi().setForeground(Color.WHITE);
			this.fenetre.getChoixOrdi().setNbOrdi(0);
		}
		if(paramActionEvent.getSource() == this.fenetre.getChoixOrdi().getUnOrdi()) {
			this.fenetre.getChoixOrdi().getZeroOrdi().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
			this.fenetre.getChoixOrdi().getUnOrdi().setBorder(BorderFactory.createLineBorder(Color.RED, 4));
			this.fenetre.getChoixOrdi().getDeuxOrdi().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
			this.fenetre.getChoixOrdi().getTroisOrdi().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));

			this.fenetre.getChoixOrdi().getZeroOrdi().setForeground(Color.WHITE);
			this.fenetre.getChoixOrdi().getUnOrdi().setForeground(Color.RED);
			this.fenetre.getChoixOrdi().getDeuxOrdi().setForeground(Color.WHITE);
			this.fenetre.getChoixOrdi().getTroisOrdi().setForeground(Color.WHITE);
			this.fenetre.getChoixOrdi().setNbOrdi(1);
		}
		if(paramActionEvent.getSource() == this.fenetre.getChoixOrdi().getDeuxOrdi()) {
			this.fenetre.getChoixOrdi().getZeroOrdi().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
			this.fenetre.getChoixOrdi().getUnOrdi().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
			this.fenetre.getChoixOrdi().getDeuxOrdi().setBorder(BorderFactory.createLineBorder(Color.RED, 4));
			this.fenetre.getChoixOrdi().getTroisOrdi().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));

			this.fenetre.getChoixOrdi().getZeroOrdi().setForeground(Color.WHITE);
			this.fenetre.getChoixOrdi().getUnOrdi().setForeground(Color.WHITE);
			this.fenetre.getChoixOrdi().getDeuxOrdi().setForeground(Color.RED);
			this.fenetre.getChoixOrdi().getTroisOrdi().setForeground(Color.WHITE);
			this.fenetre.getChoixOrdi().setNbOrdi(2);
		}
		if(paramActionEvent.getSource() == this.fenetre.getChoixOrdi().getTroisOrdi()) {
			this.fenetre.getChoixOrdi().getZeroOrdi().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
			this.fenetre.getChoixOrdi().getUnOrdi().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
			this.fenetre.getChoixOrdi().getDeuxOrdi().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
			this.fenetre.getChoixOrdi().getTroisOrdi().setBorder(BorderFactory.createLineBorder(Color.RED, 4));

			this.fenetre.getChoixOrdi().getZeroOrdi().setForeground(Color.WHITE);
			this.fenetre.getChoixOrdi().getUnOrdi().setForeground(Color.WHITE);
			this.fenetre.getChoixOrdi().getDeuxOrdi().setForeground(Color.WHITE);
			this.fenetre.getChoixOrdi().getTroisOrdi().setForeground(Color.RED);
			this.fenetre.getChoixOrdi().setNbOrdi(3);
		}

		//CHARGER MENU//
		if(paramActionEvent.getSource() == this.fenetre.getChargerPartie().getRetour()) {
			switchTo("menu");
		}
		if(paramActionEvent.getSource() == this.fenetre.getChargerPartie().getCreer()) {
			switchTo("menu");
		}
	}

	/*
	* switch to a different panel in the card layout
	*/
	private void switchTo(String pageValue) {
		this.fenetre.getCardLayout().show(this.fenetre.getContentPane(), pageValue);
	}
}