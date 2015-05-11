package Game;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

import Tools.LimitNumber;

public class Options_View {

	private JPanel mainPan;
	private JPanel optionsPan;
	private JPanel namesPan;
	private FlowLayout flowLayout;
	private GridLayout optionsGrid;
	private GridLayout namesGrid;
	private JComboBox player;
	private JComboBox ki;
	private JTextField destroyer;
	private JTextField frigate;
	private JTextField corvette;
	private JTextField submarine;
	private int width;
	private int height;

	public Options_View(int width, int height){
		this.width = width;
		this.height = height;
		this.flowLayout = new FlowLayout();
		this.initOptionsPan();
		this.mainPan.setLayout(flowLayout);
		this.mainPan.add(this.optionsPan);
		this.mainPan.add(this.namesPan);
	}

	private void initOptionsPan(){
		this.optionsGrid = new GridLayout(6,2);
		this.optionsPan = new JPanel();
		this.optionsPan.setSize(this.width, this.height);
		this.optionsPan.setVisible(true);
		this.optionsPan.setLayout(optionsGrid);
		
		this.initOptions();
	}

	public JPanel getPanel(){
		return this.mainPan;
	}


	private void initOptions(){
		JLabel playerlb = new JLabel("Spieler Anzahl");
		JLabel kilb = new JLabel("Computer Anzahl");
		JLabel destroyerlb = new JLabel("Anzahl Zerstörer");
		JLabel frigatelb = new JLabel("Anzahl Fregatten");
		JLabel corvettelb = new JLabel("Anzahl Korvetten");
		JLabel submarinelb = new JLabel("Anzahl UBoote");


		String[] count = {"2", "3", "4", "5", "6"};
		String[] kiCount = {"1", "2", "3", "4", "5"};

		this.player = new JComboBox(count);
		this.ki  = new JComboBox(kiCount);
		
		this.destroyer = new JTextField(new LimitNumber(3), "1", 3);
		this.frigate = new JTextField(new LimitNumber(3), "1", 3);
		this.corvette = new JTextField(new LimitNumber(3), "1", 3);
		this.submarine = new JTextField(new LimitNumber(3), "1", 3);

		this.optionsPan.add(playerlb);
		this.optionsPan.add(player);
		this.optionsPan.add(kilb);
		this.optionsPan.add(ki);
		this.optionsPan.add(destroyerlb);
		this.optionsPan.add(destroyer);
		this.optionsPan.add(frigatelb);
		this.optionsPan.add(frigate);
		this.optionsPan.add(corvettelb);
		this.optionsPan.add(corvette);
		this.optionsPan.add(submarinelb);
		this.optionsPan.add(submarine);

		this.initNames(Integer.parseInt(this.player.getSelectedItem().toString()));
	}
	
	private void initNames(int player){
		this.namesGrid = new GridLayout(player,2);
		this.namesPan.setLayout(this.namesGrid);
		
		for(int i = 1; i <= player; i++){
			
			JLabel playerName = new JLabel("Spieler "+ i);
			JTextField enterName = new JTextField();
		}
	}
	
	
}
