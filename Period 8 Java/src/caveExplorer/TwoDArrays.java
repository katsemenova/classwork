package caveExplorer;

import java.util.Arrays;

public class TwoDArrays {

	public static void main(String[] args) {

		String[][] pic = new String[10][8];
		for(int row=0;row<pic.length;row++){
			//populate with coordinates
			for( int col=0;col<pic[row].length;col++){
				pic[row][col]=" ";
			}
		}
		//grassy field
		for(int row=5;row<pic.length;row++){
			for(int col=0;col<pic[row].length;col++){
				pic[row][col]="w";
						
			}
		}
		
		pic[0][4]=" |";
		pic[1][4]="O";
		pic[2][4]=" |";
		pic[1][3]="--";
		pic[1][5]="--";
		pic[0][1]="<";
		pic[1][0]="<";
		pic[2][1]="<";
		for(String[] row:pic){
			for(String col:row){
				System.out.print(col);
			}
			System.out.println();
		}
	}
	public static void firstLesson(){
		String[] xox = {"x","o","x","o","x"};
		//a 1D array prints out a horizontal string
		System.out.println(Arrays.toString(xox));
		
		String[][] arr2D = new String[5][4];
		System.out.println("The height is "+arr2D.length);
		System.out.println("The width is " +arr2D[0].length);
		
		for(int row=0;row<arr2D.length;row++){
			//populate with coordinates
			for( int col=0;col<arr2D[row].length;col++){
				arr2D[row][col]="("+row+ ", " +col+")";
			}
		}
		
		//print the 2D array
		//every element in a 2D array is itself an array,
		//so a for-each loop looks like this:
		for(String[] row:arr2D){
			System.out.println(Arrays.toString(row));
		}
	}

}

