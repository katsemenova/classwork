package arrays;

public class TestTwoReview {

	public static boolean[][] grid;
	public static void main(String[] args) {
		grid = new boolean[5][5];
		printGrid(grid);
		buttonClick(3,3);
		printGrid(grid);
		buttonClick(3,3);
		printGrid(grid);
	}
	public static void switchRow(boolean[] row, int x){
		//switch row[x-1]. row[x]. row[x+1] if they exist
		for(int i = -1; i < 2; i++){
	     	if(x+i  >= 0 && x+i < row.length)
	     		row[x+i] = !row[x+i]; 
	    }
	}
	public static void switchColumn(boolean[][] grid,int r, int c){
		switchIfValid(grid,r-1,c);
      	switchIfValid(grid,r+1,c);
    
	}
  
	public static void switchIfValid(boolean[][]grid, int r, int c){
		//3 pts worth
		if(r>=0 && r < grid.length && c >= 0 && c < grid[r].length){
			grid[r][c] = !grid[r][c]; 
		}
	}
	
	public static void buttonClick(int r, int c) {
		//3 pts
		if(r>=0 && r < grid.length) 
			switchRow(grid[r],c);
	    switchColumn(grid,r,c);
	    //above is 1 point
	    
	    for(int row = 0; row < grid.length; row++){
	      for(int col = 0 ; col < grid[row].length; col++){
	    	  //1 of 2 points
	    	  if(grid[row][col]) return; //1 of 2 points 
	      }
	    }
	    System.out.println("You won!");
	}
	public static void printGrid(boolean[][] grid){
		for(int r=0;r<grid.length;r++){
			for(int c=0;c<grid[r].length;c++){
				if(grid[c][r])
					System.out.print("O");
				else
					System.out.print("X");
			}
			System.out.print("\n");
		}
		System.out.println("- - - - - - - - - - - -");
	}
	public static void printGridSolutionTwo(boolean[][] grid){
		for(boolean[] row:grid){
			for(boolean b:row){
				if(b)
					System.out.print("O");
				else
					System.out.print("X");
			}
			System.out.print("\n");
		}
		System.out.print("- - - - - - - - - - - -");
	}
	
}
