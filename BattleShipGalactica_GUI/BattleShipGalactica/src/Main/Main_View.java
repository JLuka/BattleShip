package Main;

import javax.swing.*; 

import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_View extends JFrame{

	private JFrame frame; 
	private JPanel welcomePan;		
	private JPanel shownPan;		

	private Label welcome_text;
	private JButton newGame;
	private JButton loadGame;
	private int width;
	private int height;
	private int selection = 0;
	private CardLayout cards;

	public Main_View(int width, int height){
		super();
		this.width = width;
		this.height = height;
		this.cards = new CardLayout();
		this.initFrame();
		this.initStartPanel();
		
		this.shownPan = new JPanel();
	
	}

	private void initFrame(){
		this.frame = new JFrame("BattleShip Galactica");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(this.width, this.height);
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
		this.frame.setLayout(this.cards);
		//TODO Frame Icon hinzufügen
	}

	private void initStartPanel(){
		this.welcomePan = new JPanel();
		this.welcomePan.setSize(this.width, this.height);
		this.welcomePan.setBackground(Color.BLACK);
		this.welcomePan.setLayout(null);
		this.welcomePan.setVisible(true);
		
		this.frame.add(this.welcomePan, "welcome");
		
		this.setWelcomeText();
		this.setButtons();
	}

	private void setPanel(JPanel panel, String name){
		this.frame.add(panel, name);
	}
	
	private void changeShownPan(String cardName){
		CardLayout cardLayout = (CardLayout) this.frame.getLayout();
		cardLayout.show(this.frame, cardName);
	}
	
	private void setWelcomeText(){

		this.welcome_text = new Label();
		this.welcome_text.setText("<HTML><BODY>Willkommen bei BATTLESHIP special LARS edition</BODY></HTML>");
		this.welcome_text.setAlignment(Label.CENTER);
		this.welcome_text.setForeground(Color.RED);
		int labelWidth = 400;
		this.welcome_text.setBounds((this.width-labelWidth)/2, 100, labelWidth, 50);;
		this.welcome_text.setVisible(true);
		this.welcomePan.add(welcome_text);
	}

	private void setButtons(){
		int buttonWidth = 150;
		
		//Button um ein neues Spiel zu starten
		this.newGame = new JButton();
		this.newGame.setText("Neues Spiel");
		this.newGame.setBounds((this.width-buttonWidth)/2, 175, buttonWidth, 30);
		this.newGame.setForeground(Color.BLUE);
		
		//Button um ein Spiel zu laden
		this.loadGame = new JButton();
		this.loadGame.setText("Spiel Laden");
		this.loadGame.setBounds((this.width-buttonWidth)/2, 225, buttonWidth, 30);
		this.loadGame.setForeground(Color.BLUE);
		
		this.welcomePan.add(this.newGame);
		this.welcomePan.add(this.loadGame);
		
	}
	
	/**
     * Funktionen bereitstellen, mit denen man später aus
     * dem Controller die nötigen Listener hinzufügen kann
     */
    public void setNewGameSelectionListener(ActionListener l){
        this.newGame.addActionListener(l);
    }
    
    /**
     * Funktionen bereitstellen, mit denen man später aus
     * dem Controller die nötigen Listener hinzufügen kann
     */
    public void setLoadSelectionListener(ActionListener l){
        this.loadGame.addActionListener(l);
    }
 
    
    
}
