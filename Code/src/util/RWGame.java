package util;

import java.io.*;
import batisseur.*;

public class RWGame {
	/**
	 * write a game to a file
	 * @param file the file
	 * @param game the game you want to save
	 **/
	public static void writeGame(String file, Game game) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(game);
			oos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * read a game from a file
	 * @param file the file
	 * @return the game you want to save
	 * @throws IOException will be catched by Batisseurs
	 **/
	public static Game readGame(String file) throws IOException {
		Game game;
		try {
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream(file));
			game = (Game)oos.readObject();
			oos.close();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			game = null;
		}
		return game;
	}
}