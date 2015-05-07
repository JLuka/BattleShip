package Game;
import Tools.IO;


public class Options {
	private int player;
	private String[] playerNames;
	private int destroyer;
	private int frigate;
	private int corvette;
	private int submarine;
	private int totalShips;
	private int battlefieldSize;

	public Options(){
		totalShips = 0;
	}

	/**
	 * Spielstart ruft die Optionen für Spieler, Spielfeld und Schiffe auf
	 */
	public void initGame(){
		IO.println("Willkommen bei BATTLESHIP special LARS edition!\n"
				+ "um das Spiel zu beginnen, müssen Sie zunächst einmal\n"
				+ "das Spiel konfigurieren.");

		initPlayer();
		initShips();
		setBattleFieldSize();
	}

	/**
	 * Einstellungen der Spieleranzahl und ihre Namen
	 */
	private void initPlayer(){

		IO.println("Bitte wählen sie die Anzahl der Spieler aus [2-6]: ");
		int count = IO.readInt();

		while(count < 2 || count > 6){
			IO.println("Ungültige Eingabe. Bitte zwischen 2-6 auswählen!");
			count = IO.readInt();
		}

		this.player = count;
		this.playerNames = new String[count];
		for(int i = 0; i < count; i++){
			int c = i+1;
			boolean nameUnique = true;

			IO.println("Spieler " + c + " Name: ");
			String tempName;
			do{
				tempName= IO.readString();
				nameUnique = true;

				for(int t = 0; t < this.playerNames.length; t++){

					if(this.playerNames[t] != null){
						if(this.playerNames[t].equals(tempName)){
							System.out.println("Name schon vorhanden! Bitte erneut eingeben: ");
							nameUnique = false;	
						}
					}
				}

			}while(nameUnique == false);
			this.playerNames[i] = tempName;	
		}
	}

	public void initShips(){

		System.out.println("Bitte geben sie nun die Anzahl der Schiffe ein:");
		while(totalShips == 0){
			System.out.println("Zerstörer");
			destroyer = IO.readInt();
			System.out.println("Frigatte");
			frigate = IO.readInt();
			System.out.println("Korvette");
			corvette = IO.readInt();
			System.out.println("U-Boot");
			submarine = IO.readInt();
			totalShips = destroyer + corvette + frigate + submarine;
			if(totalShips == 0){
				System.out.println("Sie müssen mindestens ein Schiff auswählen!");
			}
		}
	}
	
	/**
	 * 
	 * Methode berechnet anhand der Anzahl der Schiffe, wie groß das Spielfeld sein muss und gibt diese zurück.
	 * 
	 * @return size (größe des Spielfelds)
	 */

	public void setBattleFieldSize(){
		int zahl = 1;
		int destroyerSize = 21;
		int frigateSize = 18;
		int corvetteSize = 15;
		int submarineSize = 12;
		int totalShipSize;

		totalShipSize = (this.destroyer*destroyerSize)+(this.corvette*corvetteSize)+(this.frigate*frigateSize)+(this.submarine*submarineSize);

		while((zahl * zahl) < totalShipSize){
			zahl++;
		}
		System.out.println("Bitte geben sie nun die Spielfeldgröße ein (mindestens " + zahl + ")");
		battlefieldSize = IO.readInt();
		while(this.battlefieldSize < zahl){
			System.out.println("Ihre Eingabe muss midestens " + zahl + " betragen. Bitte wiederholen sie ihre Eingabe!");
			this.battlefieldSize = IO.readInt();
		}
	}
}
