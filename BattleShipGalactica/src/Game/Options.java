package Game;
import Tools.ColoredPrint;
import Tools.ColoredPrint.EPrintColor;
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
	private ColoredPrint colorPrint;

	public Options(){
		this.colorPrint = new ColoredPrint();
		this.totalShips = 0;
		this.initGame();
	}

	public int getPlayer() {
		return player;
	}

	public String[] getPlayerNames() {
		return playerNames;
	}

	public int getDestroyer() {
		return destroyer;
	}

	public int getFrigate() {
		return frigate;
	}

	public int getCorvette() {
		return corvette;
	}

	public int getSubmarine() {
		return submarine;
	}

	public int getTotalShips() {
		return totalShips;
	}

	public int getBattlefieldSize() {
		return battlefieldSize;
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
			this.colorPrint.println(EPrintColor.RED, "Ungültige Eingabe. Bitte zwischen 2-6 auswählen!");
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
							this.colorPrint.println(EPrintColor.RED, "Name schon vorhanden! Bitte erneut eingeben: ");
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
			destroyer = this.checkShipCount();

			System.out.println("Frigatte");
			frigate = this.checkShipCount();

			System.out.println("Korvette");
			corvette = this.checkShipCount();

			System.out.println("U-Boot");
			submarine = this.checkShipCount();

			totalShips = destroyer + corvette + frigate + submarine;

			if(totalShips == 0){
				colorPrint.println(EPrintColor.RED, "Sie müssen mindestens ein Schiff auswählen!");
			}
		}
	}

	private int checkShipCount(){
		//Prüft ob die Eingabe der Schiffsanzahl eine gültige Zahl und größer/gleich 0 ist
		int temp = IO.readShipInt();
		while(temp < 0){	
			this.colorPrint.println(EPrintColor.RED, "Ungültige Eingabe! Bitte geben sie eine Zahl größer/gleich 0 ein!");
			temp = IO.readShipInt();
		}
		return temp;
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
		this.battlefieldSize = IO.readInt();
		while(this.battlefieldSize < zahl){
			colorPrint.println(EPrintColor.RED, "Ihre Eingabe muss midestens " + zahl + " betragen. Bitte wiederholen sie ihre Eingabe!");
			this.battlefieldSize = IO.readInt();
		}
	}
}
