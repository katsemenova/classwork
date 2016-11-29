package sort;

public class RecursionIntro {

	public static void main(String[] args) {
//		System.out.println("Using a for loop:");
//		for(int i=0;i<5;i++){
//			System.out.println("Hello World! x"+i);
//		}
//		System.out.println("Without using a for loop:");
//		forLoop(5,new Action() {	
//			
//			private int value=0;
//			
//			public void act() {
//				System.out.println("Hello World! x"+value);
//				value++;
//			}
//		});
//		
//		System.out.println("with recursion:"+factorial(5));
		hanoiSolution(14,"A","B","C");
		
	}
	public static void hanoiSolution(int numberOfDisks,String startPeg,String midPeg,String endPeg){
		if(numberOfDisks<=1){
			System.out.println("Move "+ startPeg +" to "+ endPeg);
		}else{
			hanoiSolution(numberOfDisks-1,startPeg,endPeg,midPeg);
			hanoiSolution(1,startPeg,midPeg,endPeg);
			hanoiSolution(numberOfDisks-1,midPeg,startPeg,endPeg);
		}
	}
	private static void factorialForLoop(int q){
		int factorial=1;
		for(int i=q;i>0;i--){
			factorial=factorial*i;
		}
		
		System.out.println("without for loop factorial is "+factorial);
	}
	private static int factorial(int i) {
		if(i==1)
			return 1;
		else{
			return i*factorial(i-1);
		}
		
	}

	private static void forLoop(int i, Action action) {
		if(i<=0)
			return;
		else{
			action.act();
			forLoop(i-1,action);
		}
	}

}
