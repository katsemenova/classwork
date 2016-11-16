package thing;

public class MemoryKsJf implements Playable {

	public static CardJf[][] cards;
	public String[][] learnedCards; //will be length 12, the first [] is the number, the second[] is the symbol 
	public String[] symbols={"#","#","@","@","*","*","?","?","!","!","%","%"};
	private static String map[][];
	public static String printMap;
	public boolean playerMove;
	public boolean gameDone;
	public boolean userWon;
	public static MemoryAiKat Ai;
	//same for jenniber
	
	public MemoryKsJf() {
		
		// TODO Auto-generated constructor stub
		//to do is to make a pick card method?
		
	}
	public static void updateMap(){
		System.out.println("map");
		map = new String[3][4];
		for(int row=0;row<cards.length;row++){
			for(int col=0;col<cards[row].length;col++){
				 map[row][col]="| "+cards[row][col].getNumIdentifier()+" |  ";
				 System.out.println(cards[row][col].getSymbol());
			}
		}
	}
	public void play(){
		drawCards();
		updateMap();
		print(map);
		gameDone=false;
		playerMove=false;
		gameMode();
		
		
	}

	
	private void gameMode() {
		while(!gameDone){
			if(playerMove){
				//runJenniber's
			}else{
				MemoryAiKat();
			}
		}
		
	}
	private static void printMap() {
		
		
//		//String str="";
//		//int count=0;
//		for(int row=0;row<map.length;row++){
//			for(int col=0;col<map[0].length;col++){
//				map[row][col]="|"+cards[row][col].getNumIdentifier()+"|  ";
////				if(count%4==0&&count!=0){
////					System.out.println("");
////					System.out.println("");
////				}
////				str+= "|"+cards[row][col].getNumIdentifier()+"|  ";
//			}
//		}
//		print2dArray(map);
	}
	private static void print2dArray(String[][] map2) {
		for(int row=0;row<map2.length;row++){
			for(int col=0;col<map2[0].length;col++){
				if(col%4==0&&col!=0){
					System.out.println("");
					System.out.println("");
				}
				System.out.print(map2[row][col]);
			}	
		}
	}
	public static void print(String[][] pic){
		for(String[] row:pic){
			for(String col:row){
				
				System.out.print(col);
			}
			System.out.println();
		}
	}
	private void drawCards() {
		cards = new CardJf[3][4];
		int count=1;
		
		for(int row=0;row<cards.length;row++){
			for(int col=0;col<cards[row].length;col++){
				cards[row][col]=new CardJf(setSymbols(),""+count);
				count++;
			}
		}
	}

	private String setSymbols() {
		int num=(int)(Math.random()*12);
		String result;
		while(true){
			if(symbols[num].equals("")){
				num=(int)(Math.random()*12);
			}else{
				result=symbols[num];
				symbols[num]="";
				break;
			}	
		}
		return result;
		
	}
	public void enter(){
//		super.enter(); //done to make sure that the X is moved in the actual thing
		
	}
	
	public void interpretAction(String input){
		
	}
	
	private boolean isValid(String input) {
		String[] validKeys={"1","2","3","4","5","6","7","8","9","10","11","12"};
		String ignore="";
		for(int i=0;i<13;i++){
			for(int j=0;j<13;j++){
				if(i==j)
					ignore = "do nothing";
				else if(input.equals(validKeys[i]+"_"+validKeys[j]))
					return true;
			}
		}
		
		return false;
	}
	
//	public static int rowNum(int blockNum, int rowLength){
//		int row=blockNum/rowLength;
//		if(blockNum%rowLength==0){
//			row--;
//		}
//		return row;
//	}
//	public static int colNum(int blockNum, int colLength){
//		int col=blockNum%colLength;
//		if(col==0){
//			col=colLength;
//		}
//		col--;
//		return col;
//	}
}
