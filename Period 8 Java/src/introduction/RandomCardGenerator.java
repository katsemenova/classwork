package introduction;

public class RandomCardGenerator {

	public static void main(String[] args) {
		String[] suit = {"Hearts","Spades","Diamonds","Clubs"};
		String[] cardValue = {"Ace","2","3","4","5","6","7","8","9","Jack","Queen","Kings"};
		int numOne =(int) ((double) Math.random()*4);
		int numTwo =(int) ((double) Math.random()*11);
		System.out.println("The " +cardValue[numTwo]+" of "+suit[numOne]);
		
		
	}

}
