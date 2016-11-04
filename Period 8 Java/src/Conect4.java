
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class Conect4 {


	public static Scanner in = new Scanner(System.in);
	static String[][] arr2D;
	static int starti;
	static int startj;
	static int treasurei;
	static int treasurej;
	static boolean[][] bool;
	public static void main(String[] args) {
		arr2D=new String[7][17];
		bool = new String[7][17];
		
		for(int row=0;row<arr2D.length;row++){
			//populate with coordinates
			for( int col=0;col<arr2D[row].length;col++){
				arr2D[row][col]="("+row+ ", " +col+")";
			}
		}
//			starti=2;
//			startj=2;
//			startExploring();
			makeGrid(arr2D);
		
	}
	private static void startExploring() {
		print(arr2D);
		while(true){
			System.out.println("Which column do you want to drop your piece in?");
//			if(starti==treasurei&&startj==treasurej){
//				break;
//			}
			System.out.println("What do you want to do?");
			String input =in.nextLine();
			int[] newCoordinates = interpretInput(input);
			starti=newCoordinates[0];
			startj=newCoordinates[1];
		}
		
	}
	private static void printPic() {
		// TODO Auto-generated method stub
		
	}
	private static int[] interpretInput(String input) {
		//verify its a valid input
		while(!isValid(input)){
			System.out.println("Please select a number between 0 and 7, inclusive.");
			System.out.println("Tell me again which column do you want to drop your piece in?");
			input=in.nextLine();
		}
		input= convertToInt(input);
		
//		int currenti = starti;
//		int currentj = startj;
//		input = input.toLowerCase();
//		if(input.equals("w")) currenti--;
//		if(input.equals("s")) currenti++;
//		if(input.equals("a")) currentj--;
//		if(input.equals("d")) currentj++;
//		int[] newCoordinates={starti,startj};
//		if(currenti>=0&&currenti<arr2D.length&&currentj>=0&&currentj<arr2D[0].length){
//			newCoordinates[0]=currenti;
//			newCoordinates[1]=currentj;
//		}
//		else
//			System.out.println("Sorry cant go further in that direction");
//		return newCoordinates;
	}
	private static String convertToInt(String input) {
		int[] array={0,1,2,3,4,5,6,7};
		for(int i=0; i<array.length;i++){
			if(input.equals(""+i)){
				return i;
			}
		}
		return -1;
	}
	private static boolean isValid(String input) {
		String[] validKeys={"0","1","2","3","4","5","6","7"};
		for(String key:validKeys){
			if(input.toLowerCase().equals(key))
				return true; 
		}
		return false;
	}
	private static int isValidAndTrue(boolean[][] mines, int i, int j) {
		if(i>=0&&i<mines.length&&j>=0&&j<mines[0].length&&mines[i][j]){
			return 1;
		}
		return 0;
	}
//	public static void print(String[][] pic){
//		for(String[] row:pic){
//			for(String col:row){
//				
//				System.out.print(col);
//			}
//			System.out.println();
//		}
//	}
	public static void makeGrid(String[][]arr){

		for(int row=0;row<arr.length;row++){
			//populate with coordinates
			for( int col=0;col<arr[row].length;col++){
				arr[row][col]="  ";
			}
		}
		//populate first row
		for(int col = 1; col<arr[0].length;col+=2){
			arr[0][col] = ""+col/2;
		}
		for(int row =1; row<arr.length;row++){
			for(int col=0;col<arr[0].length-1;col++){
					if(col%2==0)
						arr[row][col]="|";
			}
//			pic[row][0]="|";
			arr[row][arr[row].length-1]="|";
		}			
		
		for(String[] row:arr){
			for(String col:row){
				
				System.out.print(col);
			}
			System.out.println();
		}
	}
}
