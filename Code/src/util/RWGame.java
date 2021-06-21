package util;

import java.io.*;
import batisseur.*;

public class RWGame {
	public static void writeGame(String file, Game game) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(game);
			oos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

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