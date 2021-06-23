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

public class MenuPrincipal extends JPanel {

    private JButton nouvellePartie;
    private JButton charger;
    private JButton regles;
    private JButton quitter;

    private BufferedImage logo;

    private JPanel mainPanel;
    private Font font;

    /*
    * create the main menu
    */
    public MenuPrincipal(ButtonListener buttonListener) throws IOException {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setPreferredSize(new Dimension(1250, 800));
        this.setBackground(new Color(52,212,132));
        this.font = new Font("Candara", Font.BOLD, 45);
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

        this.nouvellePartie = createFormatButton("Nouvelle partie");
        this.charger = createFormatButton("Charger");
        this.regles = createFormatButton("Règles");
        this.quitter = createFormatButton("Quitter");

        BufferedImage logo = ImageIO.read(new File("./data/images/menu/titre.png"));
        ImageIcon icon = new ImageIcon(logo);
        JLabel logolabel = new JLabel(icon);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setAlignmentX(CENTER_ALIGNMENT);
        panel.setOpaque(false);

        mainPanel.add(logolabel);
        panel.add(this.nouvellePartie);
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        panel.add(this.charger);
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        panel.add(this.regles);
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(Box.createRigidArea(new Dimension(0,20)));
        panel.add(this.quitter);
        this.add(mainPanel);
        this.add(Box.createRigidArea(new Dimension(0,100)));
        this.add(panel);
        
    }

    private JButton createFormatButton(String txt) {
        JButton button = new JButton(" " + txt + " ");
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFont(this.font);
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
        this.nouvellePartie.addActionListener(buttonListener);
        this.charger.addActionListener(buttonListener);
        this.regles.addActionListener(buttonListener);
        this.quitter.addActionListener(buttonListener);
    }

    public JButton getNouvellePartie() {
        return this.nouvellePartie;
    }

    public JButton getCharger() {
        return this.charger;
    }

    public JButton getRegle() {
        return this.regles;
    }

    public JButton getQuitter() {
        return this.quitter;
    }

    public JPanel getMainPanel() {
        return this.mainPanel;
    }
}