package SaveGame;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import Game.Player;

public class Load {
	

	private Player[] player;

	public Load(){
		
	}
	
	public Player[] loadGame(String name){
		ObjectInputStream input = null;
		
		try {
			input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(name + ".save")));
			player = (Player[]) input.readObject();
			input.close();
			return player;

		} catch (FileNotFoundException e) {
			System.err.println("Datei nicht gefunden.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
