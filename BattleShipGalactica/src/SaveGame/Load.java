package SaveGame;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import Game.Player;

public class Load {


	public Load(){

	}

	public Player[] loadGame(String name){
		ObjectInputStream input = null;
		
		Player[] player;
		
		try {
			input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(name + ".save")));
			player = (Player[]) input.readObject();
			input.close();
			return player;


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
