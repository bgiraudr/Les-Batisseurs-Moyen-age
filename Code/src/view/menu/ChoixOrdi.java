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

public class ChoixOrdi extends JPanel {

    private JButton creer;
    private JButton retour;

    private JButton zeroOrdi;
    private JButton unOrdi;
    private JButton deuxOrdi;
    private JButton troisOrdi;

    private JLabel labelOrdi;

    private JPanel mainPanel;

    private int nbPlayer;
    private int nbOrdi;

    /*
    * create the main menu
    */
    public ChoixOrdi(ButtonListener buttonListener) throws IOException {
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

        this.creer = createFormatButton("Créer partie", 30);
        this.retour = createFormatButton("Retour", 30);

        this.zeroOrdi = createFormatButton("0",150);
        this.unOrdi = createFormatButton("1",150);
        this.deuxOrdi = createFormatButton("2",150);
        this.troisOrdi = createFormatButton("3",150);

        this.labelOrdi = new JLabel("Indiquez le nombre d'ordinateur");
        this.labelOrdi.setFont(new Font("Candara", Font.BOLD, 60));
        this.labelOrdi.setForeground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.setAlignmentX(CENTER_ALIGNMENT);
        panel.setOpaque(false);

        panel.add(zeroOrdi);
        panel.add(Box.createRigidArea(new Dimension(30,0)));
        panel.add(unOrdi);
        if(this.nbPlayer >= 3) {
            panel.add(Box.createRigidArea(new Dimension(30,0)));
            panel.add(deuxOrdi);
        }
        if(this.nbPlayer >= 4) {
            panel.add(Box.createRigidArea(new Dimension(30,0)));
            panel.add(troisOrdi);
        }

        mainPanel.add(retour);
        mainPanel.add(Box.createRigidArea(new Dimension(0,15)));
        mainPanel.add(creer);
        mainPanel.add(labelOrdi);
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
        this.creer.addActionListener(buttonListener);
        this.retour.addActionListener(buttonListener);
        this.zeroOrdi.addActionListener(buttonListener);
        this.unOrdi.addActionListener(buttonListener);
        this.deuxOrdi.addActionListener(buttonListener);
        this.troisOrdi.addActionListener(buttonListener);
    }

    public JButton getCreer() {
        return this.creer;
    }

    public JButton getRetour() {
        return this.retour;
    }

    public JButton getZeroOrdi() {
        return this.zeroOrdi;
    }

    public JButton getUnOrdi() {
        return this.unOrdi;
    }

    public JButton getDeuxOrdi() {
        return this.deuxOrdi;
    }

    public JButton getTroisOrdi() {
        return this.troisOrdi;
    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }

    public void updateButton(int nb, ButtonListener buttonListener) {
        try {
            this.nbPlayer = nb;
            this.removeAll();
            this.validate();
            this.initComponents();
            this.setListener(buttonListener);
            this.revalidate();
            this.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setNbOrdi(int nb) {
        this.nbOrdi = nb;
    }

    public int getNbOrdi() {
        return this.nbOrdi;
    }
}