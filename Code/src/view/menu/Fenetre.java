/**
 * 
 * @author Benjamin Giraud-Renard
 **/

package view.menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import controler.*;
import javax.imageio.ImageIO;

public class Fenetre extends JFrame {

	private MenuPrincipal menuPrincipal;
	private NouvellePartie nouvellePartie;
	private ChoixOrdi choixOrdi;
	private ChargerPartie chargerPartie;
	private CardLayout cardLayout;

	private ButtonListener buttonListener;

	public Fenetre() {
		this.buttonListener = new ButtonListener(this);
		try {
			this.initComponents();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/*
	* init all the graphical components with a cardlayout
	*/
	private void initComponents() throws IOException {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setSize(1250,800);
		this.setTitle("Les bâtisseurs : Moyen-Age");
		this.setVisible(true);
		this.setIconImage(ImageIO.read(new File("./data/images/icon.png")));

		this.menuPrincipal = new MenuPrincipal(this.buttonListener);
		this.nouvellePartie = new NouvellePartie(this.buttonListener);
		this.choixOrdi = new ChoixOrdi(this.buttonListener);
		this.chargerPartie = new ChargerPartie(this.buttonListener);
		
		this.cardLayout = new CardLayout();
		this.setLayout(this.cardLayout);
		
		add(this.menuPrincipal,"menu");
		add(this.nouvellePartie, "new1");
		add(this.choixOrdi, "new2");
		add(this.chargerPartie, "charger");
	}

	public MenuPrincipal getMenuPrincipal() {
		return this.menuPrincipal;
	}

	public NouvellePartie getNouvellePartie() {
		return this.nouvellePartie;
	}

	public ChoixOrdi getChoixOrdi() {
		return this.choixOrdi;
	}

	public ChargerPartie getChargerPartie() {
		return this.chargerPartie;
	}

	public CardLayout getCardLayout() {
		return this.cardLayout;
	}
}