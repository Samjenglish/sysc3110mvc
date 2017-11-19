import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View extends JFrame{
private Model model;
private JLabel turnlabel;	
private JButton[][] buttonGrid;

	
	public View() {
		super("View");
		JPanel firstPanel = new JPanel(new GridLayout(0,1));
		turnlabel = new JLabel("Player 1's turn");
		JPanel grid = new JPanel(new GridLayout(3, 3));
		buttonGrid = new JButton[3][3];
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				 buttonGrid[i][j] = new JButton("");
				 grid.add(buttonGrid[i][j]);
			}
		}
		firstPanel.add(turnlabel);
		firstPanel.add(grid);
		this.add(firstPanel);
		this.setSize(500, 500);
		this.setVisible(true);

		
	}
	public void setListeners(ActionListener listener) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				 buttonGrid[i][j].addActionListener(listener);
			}
		}
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public JButton[][] getGrid() {
		return buttonGrid;
	}
	public void update(int i, int j, String newChar) {
		if(model.getTurn() == true) {
			buttonGrid[i][j].setText(newChar);
			buttonGrid[i][j].setEnabled(false);
			turnlabel.setText("Player One's Turn");
		}
		else {
			buttonGrid[i][j].setText(newChar);
			buttonGrid[i][j].setEnabled(false);
			turnlabel.setText("Player Two's Turn");
		}
	}
	public void gameStatus(String x) {
		if(x.equals("x")) {
			JOptionPane.showMessageDialog(this, "Player 1 Wins");
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					 buttonGrid[i][j].setEnabled(false);
				}
			}
		}
		else if(x.equals("o")) {
			JOptionPane.showMessageDialog(this, "Player 2 Wins");
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					buttonGrid[i][j].setEnabled(false);
				}
			}
		}else if(x.equals("draw")){
			JOptionPane.showMessageDialog(this, "Draw");
		}
	}
	
}
