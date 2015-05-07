
public class Options {
	private int player;
	private String[] playerNames;
	
	
	
	public Options(){
		
	}
	
	
	/**
	 * Spielstart ruft die Optionen für Spieler, Spielfeld und Schiffe auf
	 */
	public void initGame(){
		IO.println("Willkommen bei BATTLESHIP special LARS edition!\n"
				+ "um das Spiel zu beginnen, müssen Sie zunächst einmal\n"
				+ "das Spiel konfigurieren.");

		initPlayer();
		
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
	
	
}
