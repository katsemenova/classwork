package introduction;

public class RandomCardGenerator {

	public static void main(String[] args) {
		String[] suit = {"Hearts","Spades","Diamonds","Clubs"};
		String[] cardValue = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Jack","Queen","Kings"};
		int numOne =(int) ((double) Math.random()*suit.length);
		int numTwo =(int) ((double) Math.random()*cardValue.length);
		System.out.println("The " +cardValue[numTwo]+" of "+suit[numOne]);		
	}
}
