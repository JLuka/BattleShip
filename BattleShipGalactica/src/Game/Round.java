package Game;

import Tools.EShipType;
import Tools.IO;

public class Round {
	private Player[] player;

	public Round(Player[] player){
		this.player = player;
	}

	public void play(){
		int x;
		int y;
		char orientation;
		String eingabe;
		int gegner;
		int schiff;
		int counter = 1;
		while(ende() > 1){
			for(int i = 0; i < player.length; i++){

				if(player[i].getIsAlive()){
					player[i].reloadTimeCountdown();
					if(player[i].checkIfAnyShipIsReady()){

						//Bei allen Schiffen die laden, wird die reloadTime um einen verringert. Ist diese = 0 sind sie wieder verfügbar.

						System.out.println(player[i].getPlayerName() + " ist an der Reihe.");
						player[i].printPrivateField();

						//Gegenspieler wählen

						System.out.println("Gegen welchen Spieler möchten sie spielen?");
						for(int j = 0; j < player.length; j++){
							counter = j+1;
							if(j != i){
								if(player[j].getIsAlive()){
									System.out.println(player[j].getPlayerName() + "\t Spieler: " + counter);
									player[j].printPublicField();
								}else{
									System.out.println(player[j].getPlayerName() + "\t ist Tot");
								}
							}
						}
						System.out.println("Geben sie nun die Zahl ihres Wunschgegners ein.");
						gegner = IO.readInt();
						System.out.println("Sie spielen nun gegen "+ player[gegner-1].getPlayerName());

						//Schiff zum angreifen wählen

						System.out.println("Mit welchem Schiff möchten sie schießen?");
						if(player[i].getDestroyer().length > 0){
							System.out.println("Zerstörer\t 1");
						}
						if(player[i].getFrigate().length > 0){
							System.out.println("Frigatte\t 2");
						}
						if(player[i].getCorvette().length > 0){
							System.out.println("Korvette\t 3");
						}
						if(player[i].getSubmarine().length > 0){
							System.out.println("U-Boot\t\t 4");
						}
						schiff = IO.readInt();
						while(player[i].isAvailable(schiff) == false){
							System.out.println("Ihr/e Schiff lädt leider noch nach, bitte wählen sie ein anderes Schiff.");
							schiff = IO.readInt();
						}
						player[gegner-1].printPublicField();

						//Koordinaten wählen und schießen

						System.out.println("Geben sie nun die Koordinaten ein, auf die sie schießen möchten.");

						//TODO auf checkPos zugreifen. Wusste nicht, ob ich die Methode hier nochmal einfügen sollte oder iwie auf die Methode zugreifen sollte...

						String pos = IO.readString();
						int[] koordinaten = checkPos(pos);


						if(schiff == 1){
							System.out.println("Horizontal (h) oder Vertikal(v)?");
							orientation = IO.readChar();
							player[gegner-1].getPrivateField().setAttack(EShipType.DESTROYER, koordinaten,orientation, player[gegner-1]);
							player[i].setDestroyerIsntReady();
						} else if(schiff == 2){
							System.out.println("Horizontal (h) oder Vertikal(v)?");
							orientation = IO.readChar();
							player[gegner-1].getPrivateField().setAttack(EShipType.FRIGATE,koordinaten,orientation,player[gegner-1]);
							player[i].setFrigateIsntReady();
						} else if(schiff == 3){
							orientation = 'h';
							player[gegner-1].getPrivateField().setAttack(EShipType.CORVETTE,koordinaten,orientation,player[gegner-1]);
							player[i].setCorvetteIsntReady();
						} else if(schiff == 4){
							orientation = 'h';
							player[gegner-1].getPrivateField().setAttack(EShipType.SUBMARINE,koordinaten,orientation,player[gegner-1]);
							player[i].setSubmarineIsntReady();
						}

						//Überprüft, ob der Gegner noch am Leben ist, wenn nicht wird isAlive auf false gesetzt.
						
						//TODO Die Methode isDead hatte ich in meiner Klasse field, hat überprüft, ob Player überhaupt noch ein Schiff besitzt. Und nun? :D
						
						if(player[gegner-1].getPrivateField().isDead() == true){
							player[gegner-1].setAlive(false);
							System.out.println("Herzlichen Glückwunsch, sie haben " + player[gegner-1].getPlayerName() + " besiegt.");
						}

						//überprüft, ob noch Spieler am leben sind. Wenn nicht wird Spiel beendet.
						if(ende() == 1){
							System.out.println("Herzlichen Glückwunsch, Spieler " + player[i].getPlayerName() + " hat gewonnen.");
							System.exit(-1);
						}


						System.out.println("Drücken sie (n) damit der nächste Spieler an der Reihe ist.");
						System.out.println("Drücken sie (x) um das Spiel zu beenden ohne zu speichern.");
						System.out.println("Drücken sie (s) um das Spiel zu speichern.");
						eingabe = IO.readString();
						while((!(eingabe.equals("n"))) || (!(eingabe.equals("x"))) ||  (!(eingabe.equals("x")))){
							System.out.println("Sie müssen eine dieser Auswahlmöglichkeiten wählen.");
							eingabe = IO.readString();
						}
						if(eingabe.equals("n")){
							for(int w = 0; w < 150; w++){
								System.out.println("");
							}
						}else if(eingabe.equals("x")){
							System.exit(0);
						}else{
							//TODO Speicherabfrage
							System.out.println("Wenn sie das Spiel jetzt beenden möchten, drücken sie (x) um weiter zu spielen drücken sie irgendeine andere Taste.");
							eingabe = IO.readString();
							if(eingabe.equals("x")){
								System.exit(0);
							}else{
								for(int w = 0; w < 150; w++){
									System.out.println("");
								}
							}
						}
						
					}
				}
			}

		}
	}




	public int ende(){
		int counter = 0;
		for(int i = 0; i<player.length; i++){
			if(player[i].getIsAlive()){
				counter++;
			}
		}
		return counter;
	}



}
