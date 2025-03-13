package presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
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
		buttons = new JButton[3][3];
		
		mainContentPane = this.getContentPane();
		gridContainer = new Container();
		buttonContainer = new Container();
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
	}
	private void createButtons() {
		
		for(int i = 0; i<buttons.length;i++) {
			for(int j = 0; j<buttons[i].length;j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setName(i + "," + j);
				buttons[i][j].addActionListener(this);
			}
		}
		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(this);
		closeButton = new JButton("Close");		
		closeButton.addActionListener(this);
	}
	private void addButtons() {
		this.getContentPane().add(gridContainer, BorderLayout.CENTER);
		this.getContentPane().add(buttonContainer, BorderLayout.SOUTH);
		
		for(int i = 0; i<buttons.length;i++) {
			for(int j = 0; j<buttons[i].length;j++) {
				gridContainer.add(buttons[i][j]);
			}
		}
		buttonContainer.add(newGameButton);
		buttonContainer.add(closeButton);	
	}

	public void actionPerformed(ActionEvent e) {
		String[] positionButton;
		if(game.hasGameEnded()) {
			if(e.getSource() == closeButton) {
				System.exit(0);
			}
			
			else if(e.getSource() == newGameButton) {
				game = new Game();
				resetButtons();
			}
			else {
				JOptionPane.showMessageDialog(this, "La partida ja ha acabat, no pots interactuar amb el tauler","Partida acabada",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else {
			if(e.getSource() == closeButton) {
				if(JOptionPane.showConfirmDialog(this,"El joc encara no ha acabat, estas segur que vols sortir?","Sortir",JOptionPane.YES_NO_OPTION)==0) {
					System.exit(0);
				}
			}
			
			else if(e.getSource() == newGameButton) {
				if(JOptionPane.showConfirmDialog(this,"La partida encara esta en joc, estas segur que vols començar de nou?","Nova partida",JOptionPane.YES_NO_OPTION)==0) {
					game = new Game();
					resetButtons();
				}
			}
			else {
				positionButton = ((JButton)e.getSource()).getName().split(",");
		        int row = Integer.parseInt(positionButton[0]);
		        int col = Integer.parseInt(positionButton[1]);
		        if (game.move(row, col)) {
		            buttons[row][col].setText(game.getCellContent(row, col) + "");
				}
		        if (game.hasGameEnded()) {
	                JOptionPane.showMessageDialog(this, "¡Game ended! " + game.getEndMessage(),"Fin del juego", JOptionPane.INFORMATION_MESSAGE);
	            }
			}
		}
	}
	
	private void resetButtons() {
        for (int i = 0; i<buttons.length;i++) {
            for (int j = 0;j<buttons[i].length;j++) {
                buttons[i][j].setText("");
            }
        }
    }
}
