
public class Model {
	private View view;
	public static final int size = 3;
	private String[][] grid;
	private boolean turn;
	private int count;
	public Model(){
		grid = new String[size][size];
		turn = true;
		count = 0;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				grid[i][j] = "";
			}
		}
	}
	private void checkStatus() {	
		String y = "";
		count++;
		for(int i = 0; i < 2; i++) {
			y = grid[i][0];
			if(grid[i][1].equals(y)== true && grid[i][2].equals(y) == true) {
				view.gameStatus(y);
			}
		}
		for(int i = 0; i < 2; i++) {
			y = grid[0][i];
			if(grid[1][i].equals(y)== true && grid[2][i].equals(y) == true) {
				view.gameStatus(y);
			}
		}
		y = grid[0][0];
		if(grid[1][1].equals(y)== true && grid[2][2].equals(y) == true) {
			view.gameStatus(y);
		}
		y = grid[2][0];
		if(grid[1][1].equals(y)== true && grid[0][2].equals(y) == true) {
			view.gameStatus(y);
		}
		if(count > 9) {
			view.gameStatus("draw");
		}
	}
	
	public void setView(View view) {
		this.view = view;
	}


	public void play(int i, int j) {
		if(turn == true) {
			grid[i][j] = "x";
			turn = false;
			view.update(i, j, "x");
			
		}else {
			grid[i][j] = "o";
			turn = true;
			view.update(i, j, "o");
			
		}
		checkStatus();
	}

	public boolean getTurn() {
		return turn;
	}


	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	
}
