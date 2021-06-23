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
import view.ingame.*;

public class GameButtonListener implements ActionListener {

	private GameFrame fenetre;

	/*
	* create the listener for all the button or component
	*/
	public GameButtonListener(GameFrame fenetre) {
		this.fenetre = fenetre;
	}

	/*
	* detect a click on a button
	*/
	public void actionPerformed(ActionEvent paramActionEvent) {
	}
}