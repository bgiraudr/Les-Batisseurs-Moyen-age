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

public class ChargerPartie extends JPanel {

    private JButton creer;
    private JButton retour;

    private JLabel labelPartie;

    private JPanel mainPanel;

    private static final String SAVE_FOLDER = "./data/saves/";

    /*
    * create the main menu
    */
    public ChargerPartie(ButtonListener buttonListener) throws IOException {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setPreferredSize(new Dimension(1250, 800));
        this.setBackground(new Color(52,212,132));
        this.initComponents(buttonListener);
        this.setListener(buttonListener);
    }

    /*
    * init all the graphical components
    */
    private void initComponents(ButtonListener buttonListener) throws IOException {
        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new BoxLayout(this.mainPanel, BoxLayout.PAGE_AXIS));
        this.mainPanel.setAlignmentX(CENTER_ALIGNMENT);
        this.mainPanel.setOpaque(false);

        this.creer = createFormatButton("Charger partie", 30);
        this.retour = createFormatButton("Retour", 30);

        this.labelPartie = new JLabel("Listes des parties");
        this.labelPartie.setFont(new Font("Candara", Font.BOLD, 60));
        this.labelPartie.setForeground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setAlignmentX(CENTER_ALIGNMENT);
        panel.setOpaque(false);

        String[] saves = getAllSave();
        for(String s : saves) {
            JButton j = createFormatButton(s.substring(0,s.length()-4), 40);
            panel.add(j);
            panel.add(Box.createRigidArea(new Dimension(0,20)));
            j.addActionListener(buttonListener);
        }

        JScrollPane jsp = new JScrollPane(panel);
        jsp.getViewport().setBackground(Color.BLACK);

        JPanel p2 = new JPanel(new GridLayout(1,3));
        p2.setOpaque(false);
        p2.add(new JLabel(""));
        p2.add(jsp);
        p2.add(new JLabel(""));

        mainPanel.add(retour);
        mainPanel.add(Box.createRigidArea(new Dimension(0,15)));
        mainPanel.add(creer);
        mainPanel.add(labelPartie);
        this.add(Box.createRigidArea(new Dimension(0,100)));
        this.add(mainPanel);
        this.add(Box.createRigidArea(new Dimension(0,30)));
        this.add(p2);
        this.add(Box.createRigidArea(new Dimension(0,30)));
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
        this.creer.addActionListener(buttonListener);
        this.retour.addActionListener(buttonListener);
    }

    public JButton getCreer() {
        return this.creer;
    }

    public JButton getRetour() {
        return this.retour;
    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    public String[] getAllSave() {
        File saveFolder = new File(SAVE_FOLDER);
        String content[] = saveFolder.list();
        return content;
    }
}