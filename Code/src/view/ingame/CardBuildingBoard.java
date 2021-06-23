package view.ingame;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.util.*;

import java.io.*;

import batisseur.*;
import controler.*;

public class CardBuildingBoard extends JPanel {

    private Board board;
    private static final String PATH_BUILDING = "./data/images/batiments/";
    private static final String PATH_MACHINE = "./data/images/machines/chantiers/";

    public CardBuildingBoard(Board board) throws IOException {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setOpaque(false);
        this.board = board;

        this.initComponents();
    }

    public void initComponents() throws IOException {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.setOpaque(false);
        for(IBuilding card : this.board.getFiveBuildingCards()) {
            if(card instanceof Building) 
                panel.add(genImage(PATH_BUILDING + ((Card)card).getName().replace(" ","_").replace("à","a").replace("é","e").replace("è","e")));
            if(card instanceof Machine) {
                if(checkCard(card,0,1,1,0)) {
                    panel.add(genImage(PATH_MACHINE + "four_à_tuiles1"));
                }
                if(checkCard(card,2,1,0,0)) {
                    panel.add(genImage(PATH_MACHINE + "four_à_tuiles2"));
                }
                if(checkCard(card,0,1,0,1)) {
                    panel.add(genImage(PATH_MACHINE + "grue1"));
                }
                if(checkCard(card,0,2,1,0)) {
                    panel.add(genImage(PATH_MACHINE + "grue2"));
                }
                if(checkCard(card,1,1,0,0)) {
                    panel.add(genImage(PATH_MACHINE + "instrument_de_mesure1"));
                }
                if(checkCard(card,1,0,0,2)) {
                    panel.add(genImage(PATH_MACHINE + "instrument_de_mesure2"));
                }
                if(checkCard(card,1,0,1,0)) {
                    panel.add(genImage(PATH_MACHINE + "scie_circulaire1"));
                }
                if(checkCard(card,0,0,2,1)) {
                    panel.add(genImage(PATH_MACHINE + "scie_circulaire2"));
                }
            }

            panel.add(Box.createRigidArea(new Dimension(30,0)));
        }
        add(panel);
    }

    public JLabel genImage(String path) {
        JLabel logolabel = new JLabel("");
        try {
            BufferedImage logo = ImageIO.read(new File(path + ".png"));
            ImageIcon icon = new ImageIcon(logo);
            logolabel = new JLabel(icon);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return logolabel;
    }

    public boolean checkCard(IBuilding card, int stone, int wood, int knowledge, int tile) {
        boolean ret = false;
        Card co = (Card)card;
        if(co.getStone() == stone && co.getWood() == wood && co.getKnowledge() == knowledge && co.getTile() == tile) {
            ret = true;
        }
        return ret;
    }

}