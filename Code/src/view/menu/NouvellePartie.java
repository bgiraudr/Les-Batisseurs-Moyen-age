/**
 * 
 * @author Benjamin Giraud-Renard
 **/

package view.menu;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.util.*;

import java.io.*;

import batisseur.*;
import controler.*;

public class NouvellePartie extends JPanel {

    private JButton suivant;
    private JButton retour;

    private JButton deuxJoueur;
    private JButton troisJoueur;
    private JButton quatreJoueur;

    private JLabel labelJoueur;

    private JPanel mainPanel;

    private int nbPlayer;

    /*
    * create the main menu
    */
    public NouvellePartie(ButtonListener buttonListener) throws IOException {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setPreferredSize(new Dimension(1250, 800));
        this.setBackground(new Color(52,212,132));
        this.initComponents();
        this.setListener(buttonListener);
    }

    /*
    * init all the graphical components
    */
    private void initComponents() throws IOException {
        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new BoxLayout(this.mainPanel, BoxLayout.PAGE_AXIS));
        this.mainPanel.setAlignmentX(CENTER_ALIGNMENT);
        this.mainPanel.setOpaque(false);

        this.suivant = createFormatButton("Suivant", 30);
        this.retour = createFormatButton("Retour", 30);

        this.deuxJoueur = createFormatButton("2",150);
        this.troisJoueur = createFormatButton("3",150);
        this.quatreJoueur = createFormatButton("4",150);

        this.labelJoueur = new JLabel("Indiquez le nombre de joueur");
        this.labelJoueur.setFont(new Font("Candara", Font.BOLD, 60));
        this.labelJoueur.setForeground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.setAlignmentX(CENTER_ALIGNMENT);
        panel.setOpaque(false);


        panel.add(deuxJoueur);
        panel.add(Box.createRigidArea(new Dimension(30,0)));
        panel.add(troisJoueur);
        panel.add(Box.createRigidArea(new Dimension(30,0)));
        panel.add(quatreJoueur);

        //mainPanel.add(retour);
        mainPanel.add(retour);
        mainPanel.add(Box.createRigidArea(new Dimension(0,15)));
        mainPanel.add(suivant);
        mainPanel.add(labelJoueur);
        this.add(Box.createRigidArea(new Dimension(0,100)));
        this.add(mainPanel);
        this.add(Box.createRigidArea(new Dimension(0,50)));
        this.add(panel);
    }

    private JButton createFormatButton(String txt, int taille) {
        JButton button = new JButton(" " + txt + " ");
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFont(new Font("Candara", Font.BOLD, taille));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
        return button;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            BufferedImage bufimage = ImageIO.read(new File("./data/images/menu/fond.jpg"));
            g.drawImage(bufimage, 0,0,1500,900,null);
        } catch (IOException e) {
            System.out.println("Error : Pages : paintComponent() : " + e.getMessage());
        }
    }

    private void setListener(ButtonListener buttonListener) {
        this.suivant.addActionListener(buttonListener);
        this.retour.addActionListener(buttonListener);
        this.deuxJoueur.addActionListener(buttonListener);
        this.troisJoueur.addActionListener(buttonListener);
        this.quatreJoueur.addActionListener(buttonListener);
    }

    public JButton getSuivant() {
        return this.suivant;
    }

    public JButton getRetour() {
        return this.retour;
    }

    public JButton getDeuxJoueur() {
        return this.deuxJoueur;
    }

    public JButton getTroisJoueur() {
        return this.troisJoueur;
    }

    public JButton getQuatreJoueur() {
        return this.quatreJoueur;
    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    public void setNbPlayer(int nb) {
        this.nbPlayer = nb;
    }

    public int getNbPlayer() {
        return this.nbPlayer;
    }
}