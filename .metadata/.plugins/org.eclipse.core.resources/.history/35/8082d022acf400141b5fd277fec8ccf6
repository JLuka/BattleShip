
public class Ship implements IShip{

	private int shipSize;
	private boolean isReady;
	private int reloadTime;
	private int shootArea;
	private int reloadTimeLeft;
	private int[][] coordinates;


	/**
	 * Konstruktor der Klasse ship
	 * @param shipSize
	 * @param isReady
	 * @param reloadTime
	 * @param shootArea
	 */


	public Ship(int shipSize, boolean isReady, int reloadTime, int shootArea){
		this.shipSize = shipSize;
		this.isReady = isReady;
		this.reloadTime = reloadTime;
		this.shootArea = shootArea;
	}

	/**
	 * Default Konstruktor der Klasse Ship
	 */

	public Ship(){

	}

	/**
	 * getter ReloadTimeLeft
	 * @return
	 */

	public int getReloadTimeLeft() {
		return reloadTimeLeft;
	}

	/**
	 * Setter ReloadTimeLeft
	 * @param reloadTimeLeft
	 */

	public void setReloadTimeLeft(int reloadTimeLeft) {
		this.reloadTimeLeft = reloadTimeLeft;
	}

	/**
	 * Getter isReady
	 * @return
	 */

	public boolean isReady() {
		return isReady;
	}

	/**
	 * Setter isReady
	 * @param isReady
	 */

	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}

	/**
	 * getter ReloadTime
	 * @return
	 */

	public int getReloadTime() {
		return reloadTime;
	}

	/**
	 * Setter ReloadTimer
	 * @param reloadTime
	 */

	public void setReloadTime(int reloadTime) {
		this.reloadTime = reloadTime;
	}

	/**
	 * Getter Shootarea
	 * @return
	 */

	public int getShootArea() {
		return shootArea;
	}

	/**
	 * Setter ShootArea
	 * @param shootArea
	 */

	public void setShootArea(int shootArea) {
		this.shootArea = shootArea;
	}

	/**
	 * getterShipSize
	 * @return
	 */

	public int getShipSize() {
		return shipSize;
	}

	/**
	 * Setter Shipsize
	 * @param shipSize
	 */

	public void setShipSize(int shipSize) {
		this.shipSize = shipSize;
	}

	/**
	 * Getter für die Schiffkoordinaten
	 * @return
	 */

	public int[][] getCoordinates() {
		return coordinates;
	}

	/**
	 * Setter für die Schiffskoordinaten
	 * @param coordinates
	 */

	public void setCoordinates(int[][] coordinates){
		this.coordinates = coordinates;
	}

	/**
	 * Methode setzt die Koordinaten eines Schiffs auf 0,0 wenn es getroffen wurde.
	 * @param x
	 * @param y
	 */

	public void setCoordinatesIfHitted(int x, int y) {
		for(int i = 0; i < coordinates.length; i++){
			if(coordinates[0][i] == x){
				for(int j = 0; j < coordinates.length; j++){
					if(coordinates[1][j] == y){
						coordinates[0][i] = 0;
						coordinates[1][j] = 0;
					}
				}
			}
		}
	}

	/**
	 * Methode überprüft, ob Schiff noch schwimmt oder untergegangen ist.
	 * @return
	 */

	public boolean checkIfIsSwimming(){
		int counter = 0;
		for(int i = 0; i < this.coordinates.length; i++){
			for(int j = 0; j < this.coordinates[i].length; j++){
				if(coordinates[i][j] != 0){
					counter++;
				}
			}
		}
		if(counter > 0){
			return true;
		}
		return false;
	}

}

