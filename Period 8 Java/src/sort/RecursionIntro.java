package sort;

public class RecursionIntro {

	public static void main(String[] args) {
		int n=50;
		System.out.println("The "+n+"th Fiboncacci is "+fibonacci(n));
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
		//hanoiSolution(2,"A","B","C");
		
	}
	public static int fibonacci(int n) {
		if(n<=1)
			return 1;
		else{
			int previous= fibonacci(n-1);
			int beforePrevious=fibonacci(n-2);
			//print("before we find fibonacci "+n+ " we need to find fibonacci "+(n-1)+" which is "+previous);
			return previous+beforePrevious;
		}
		
	}
	private static int count=1;
	public static void print(String s){
		System.out.println("Move #"+count +" : "+s);
		count++;
	}
	public static void hanoiSolution(int numberOfDisks,String startPeg,String midPeg,String endPeg){
		if(numberOfDisks<=1){
			print("Move "+ startPeg +" to "+ endPeg);
		}else{
			System.out.println("In order to move "+ numberOfDisks+" over to peg " +endPeg+" we must move "+(numberOfDisks-1)+" over to peg " +midPeg+ " first");
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
