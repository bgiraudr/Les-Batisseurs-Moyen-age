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

public class CardWorkerBoard extends JPanel {

    private Board board;
    private static final String PATH_IMAGE = "./data/images/";
    private static final String PATH_WORKER = "./data/images/ouvriers";

    public CardWorkerBoard(Board board) throws IOException {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        //this.setPreferredSize(new Dimension(1250, 800));
        this.setOpaque(false);
        this.board = board;

        this.initComponents();
    }

    public void initComponents() throws IOException {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.setOpaque(false);
        for(IWorker card : this.board.getFiveWorkerCards()) {
            switch(((Card)card).getName()) {
                case "Apprenti":
                    if(checkCard(card,0,1,1,0)) {
                        panel.add(genImage(PATH_WORKER + "/apprenti/1.png"));
                    }
                    if(checkCard(card,0,0,1,1)) {
                        panel.add(genImage(PATH_WORKER + "/apprenti/2.png"));
                    }
                    if(checkCard(card,0,1,0,1)) {
                        panel.add(genImage(PATH_WORKER + "/apprenti/3.png"));
                    }
                    if(checkCard(card,1,0,1,0)) {
                        panel.add(genImage(PATH_WORKER + "/apprenti/4.png"));
                    }
                    if(checkCard(card,1,1,0,0)) {
                        panel.add(genImage(PATH_WORKER + "/apprenti/5.png"));
                    }
                    if(checkCard(card,1,0,0,1)) {
                        panel.add(genImage(PATH_WORKER + "/apprenti/6.png"));
                    }
                    break;
                case "Manœuvre":
                    if(checkCard(card,0,0,2,1)) {
                        panel.add(genImage(PATH_WORKER + "/manoeuvre/1.png"));
                    }
                    if(checkCard(card,1,0,2,0)) {
                        panel.add(genImage(PATH_WORKER + "/manoeuvre/2.png"));
                    }
                    if(checkCard(card,0,1,2,0)) {
                        panel.add(genImage(PATH_WORKER + "/manoeuvre/3.png"));
                    }
                    if(checkCard(card,1,2,0,0)) {
                        panel.add(genImage(PATH_WORKER + "/manoeuvre/4.png"));
                    }
                    if(checkCard(card,0,2,0,1)) {
                        panel.add(genImage(PATH_WORKER + "/manoeuvre/5.png"));
                    }
                    if(checkCard(card,0,2,1,0)) {
                        panel.add(genImage(PATH_WORKER + "/manoeuvre/6.png"));
                    }
                    if(checkCard(card,2,0,1,0)) {
                        panel.add(genImage(PATH_WORKER + "/manoeuvre/7.png"));
                    }
                    if(checkCard(card,2,0,0,1)) {
                        panel.add(genImage(PATH_WORKER + "/manoeuvre/8.png"));
                    }
                    if(checkCard(card,2,1,0,0)) {
                        panel.add(genImage(PATH_WORKER + "/manoeuvre/9.png"));
                    }
                    if(checkCard(card,0,0,1,2)) {
                        panel.add(genImage(PATH_WORKER + "/manoeuvre/10.png"));
                    }
                    if(checkCard(card,0,1,0,2)) {
                        panel.add(genImage(PATH_WORKER + "/manoeuvre/11.png"));
                    }
                    if(checkCard(card,1,0,0,2)) {
                        panel.add(genImage(PATH_WORKER + "/manoeuvre/12.png"));
                    }
                    break;
                case "Compagnon":
                    if(checkCard(card,1,0,3,0)) {
                        panel.add(genImage(PATH_WORKER + "/compagnon/1.png"));
                    }
                    if(checkCard(card,1,1,1,1)) {
                        panel.add(genImage(PATH_WORKER + "/compagnon/2.png"));
                    }
                    if(checkCard(card,0,3,0,1)) {
                        panel.add(genImage(PATH_WORKER + "/compagnon/4.png"));
                    }
                    if(checkCard(card,0,2,0,2)) {
                        panel.add(genImage(PATH_WORKER + "/compagnon/5.png"));
                    }
                    if(checkCard(card,2,0,2,0)) {
                        panel.add(genImage(PATH_WORKER + "/compagnon/6.png"));
                    }
                    if(checkCard(card,3,1,0,0)) {
                        panel.add(genImage(PATH_WORKER + "/compagnon/7.png"));
                    }
                    if(checkCard(card,0,0,2,2)) {
                        panel.add(genImage(PATH_WORKER + "/compagnon/8.png"));
                    }
                    if(checkCard(card,0,2,2,0)) {
                        panel.add(genImage(PATH_WORKER + "/compagnon/9.png"));
                    }
                    if(checkCard(card,0,0,1,3)) {
                        panel.add(genImage(PATH_WORKER + "/compagnon/10.png"));
                    }
                    if(checkCard(card,2,0,0,2)) {
                        panel.add(genImage(PATH_WORKER + "/compagnon/11.png"));
                    }
                    if(checkCard(card,2,2,0,0)) {
                        panel.add(genImage(PATH_WORKER + "/compagnon/12.png"));
                    }
                    if(checkCard(card,2,1,1,0)) {
                        panel.add(genImage(PATH_WORKER + "/compagnon/13.png"));
                    }
                    if(checkCard(card,0,1,1,2)) {
                        panel.add(genImage(PATH_WORKER + "/compagnon/14.png"));
                    }
                    if(checkCard(card,1,2,0,1)) {
                        panel.add(genImage(PATH_WORKER + "/compagnon/15.png"));
                    }
                    if(checkCard(card,1,0,2,1)) {
                        panel.add(genImage(PATH_WORKER + "/compagnon/16.png"));
                    }
                    break;
                case "Maître":
                    if(checkCard(card,0,2,3,0)) {
                        panel.add(genImage(PATH_WORKER + "/maitre/1.png"));
                    }
                    if(checkCard(card,0,0,3,2)) {
                        panel.add(genImage(PATH_WORKER + "/maitre/2.png"));
                    }
                    if(checkCard(card,2,3,0,0)) {
                        panel.add(genImage(PATH_WORKER + "/maitre/3.png"));
                    }
                    if(checkCard(card,0,3,2,0)) {
                        panel.add(genImage(PATH_WORKER + "/maitre/4.png"));
                    }
                    if(checkCard(card,3,2,0,0)) {
                        panel.add(genImage(PATH_WORKER + "/maitre/5.png"));
                    }
                    if(checkCard(card,3,0,0,2)) {
                        panel.add(genImage(PATH_WORKER + "/maitre/6.png"));
                    }
                    if(checkCard(card,2,0,0,3)) {
                        panel.add(genImage(PATH_WORKER + "/maitre/7.png"));
                    }
                    if(checkCard(card,0,0,2,3)) {
                        panel.add(genImage(PATH_WORKER + "/maitre/8.png"));
                    }
                    break;
            }
            panel.add(Box.createRigidArea(new Dimension(30,0)));
        }
        add(panel);
    }

    public JLabel genImage(String path) throws IOException {
        BufferedImage logo = ImageIO.read(new File(path));
        ImageIcon icon = new ImageIcon(logo);
        JLabel logolabel = new JLabel(icon);
        return logolabel;
    }

    public boolean checkCard(IWorker card, int stone, int wood, int knowledge, int tile) {
        boolean ret = false;
        Card co = (Card)card;
        if(co.getStone() == stone && co.getWood() == wood && co.getKnowledge() == knowledge && co.getTile() == tile) {
            ret = true;
        }
        return ret;
    }
}