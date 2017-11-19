import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Controller implements ActionListener{
	private Model model;
	private View view;
	
	public static void main(String [ ] args)
	{
		Controller controller = new Controller();
		 
		
	}
	public Controller(){
		 model = new Model();
		 view = new View();	
		 view.setModel(model);
		 model.setView(view);
		 
		 
		 view.setListeners(this); 
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton[][] viewGrid = view.getGrid();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(e.getSource() == viewGrid[i][j]) {
					model.play(i, j);
				}
			}
		}
	}
	
	/*
	 * 
	 * 
	 * aButton.addActionListener(new java.awt.event.ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
            myMethod();
        }
    });
	 * 
	 * 
	 * 
	 */
	
	
}
