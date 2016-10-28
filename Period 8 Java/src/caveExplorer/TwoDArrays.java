package caveExplorer;

import java.util.Arrays;

public class TwoDArrays {

	public static void main(String[] args) {
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
