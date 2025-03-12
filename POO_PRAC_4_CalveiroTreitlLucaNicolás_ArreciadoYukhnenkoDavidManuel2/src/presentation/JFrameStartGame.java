package presentation;

import java.awt.*;
import javax.swing.*;
import domain.Game;

public class JFrameStartGame extends JFrame{

	private Game game;
	private JButton[][] buttons;
	private JButton newGameButton;
	private JButton closeButton;
	
	Container mainContentPane;
	Container gridContainer;
	Container buttonContainer;
	
	Dimension dim = new Dimension(400,60);
	
	public JFrameStartGame() {
		super();
		initComponents();
	}
	
	public static void main (String []args) {
		EventQueue.invokeLater(
			new Runnable() {
				public void run() {
					JFrame jf = new JFrameStartGame();
					jf.setVisible(true);
				}
			}
		);
	}
	private void initComponents() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		game = new Game();
		mainContentPane = new Panel();
		gridContainer = new Container();
		buttonContainer = new Container();
		mainContentPane = this.getContentPane();
		gridContainer.setLayout(new GridLayout(3,3));
		buttonContainer.setLayout(new FlowLayout());
		
		this.setSize(400, 500);
		this.setLocation(0, 0);
		gridContainer.setSize(400,400);
		gridContainer.setLocation(0,400);
		
		buttonContainer.setPreferredSize(dim);
		buttonContainer.setMaximumSize(dim);
		createButtons();
		addButtons();
		
		this.setVisible(true);
		gridContainer.setVisible(true);
		buttonContainer.setVisible(true);
	}
	private void createButtons() {
		for(int i = 0; i<gridContainer.getWidth();i++) {
			for(int j = 0; j<gridContainer.getHeight();j++) {
				buttons[i][j] = new JButton();
			}
		}
		newGameButton = new JButton("New Game");
		closeButton = new JButton("Close");		
	}
	private void addButtons() {
		this.getContentPane().add(gridContainer, BorderLayout.CENTER);
		this.getContentPane().add(buttonContainer, BorderLayout.SOUTH);
		
		for(int i = 0; i<gridContainer.getWidth();i++) {
			for(int j = 0; j<gridContainer.getHeight();j++) {
				gridContainer.add(buttons[i][j]);
			}
		}
		buttonContainer.add(newGameButton, closeButton);
	}
}
