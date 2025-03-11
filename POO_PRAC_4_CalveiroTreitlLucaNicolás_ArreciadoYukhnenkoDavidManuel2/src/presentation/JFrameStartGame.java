package presentation;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import domain.Game;

public class JFrameStartGame extends JFrame implements ActionListener{

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
		mainContentPane = new Container();
		gridContainer = new Container();
		buttonContainer = new Container();
		initComponents();
		game = new Game();
	}
	
	
	private void initComponents() {
		mainContentPane = this.getContentPane();
		gridContainer.setLayout(new GridLayout(3,3));
		buttonContainer.setLayout(new FlowLayout());
		
		this.setSize(400, 500);
		gridContainer.setSize(400,400);
		buttonContainer.setPreferredSize(dim);
		buttonContainer.setMaximumSize(dim);
		createButtons();
		addButtons();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		gridContainer.setVisible(true);
		buttonContainer.setVisible(true);
	}
	private void createButtons() {
		for(int i = 0; i<gridContainer.getWidth();i++) {
			for(int j = 0; j<gridContainer.getHeight();j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setForeground(Color.BLUE);
			}
		}
		newGameButton = new JButton();
		closeButton = new JButton();
		
		newGameButton.setToolTipText("New Game");
		closeButton.setToolTipText("Close");
		
		
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
