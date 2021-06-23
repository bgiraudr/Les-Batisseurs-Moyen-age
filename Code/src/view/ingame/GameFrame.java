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

public class GameFrame extends JFrame {

	private Game game;
	private CardWorkerBoard cardWorkerBoard;
	private CardBuildingBoard cardBuildingBoard;

	public GameFrame(Game game) {
		this.game = game;
		try {
			this.initComponents();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void initComponents() throws IOException {
		setTitle("Les Bâtisseurs - Jeu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1250,800);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setLayout(new FlowLayout());
        this.setIconImage(ImageIO.read(new File("./data/images/icon.png")));

        this.setContentPane(new JPanel() {
             @Override
             public void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                      BufferedImage bufimage = ImageIO.read(new File("./data/images/ingame/fond.png"));
                      g.drawImage(bufimage, 0,0,1250,800,null);
                } catch (IOException e) {
                      System.out.println("Error : Pages : paintComponent() : " + e.getMessage());
                }
             }
          });
        this.revalidate();

        this.cardWorkerBoard = new CardWorkerBoard(this.game.getBoard());
        this.cardBuildingBoard = new CardBuildingBoard(this.game.getBoard());
        this.add(this.cardBuildingBoard);
        this.add(this.cardWorkerBoard);

        this.revalidate();
	}
}