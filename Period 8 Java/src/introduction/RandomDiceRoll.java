package introduction;

public class RandomDiceRoll {

	public static void main(String[] args) {
		int[] results= new int[6];
		//Declare variable, logic test, incriment
		int totalRolls=10000;
		for(int index=0;index<totalRolls; index++){
			int result= rollFairDie();
			System.out.println("Roll #" +(index+1)+" Fair Die Number: "+ result);
			results[result-1]++;
//			System.out.println("Roll #" +(index+1)+" Fair Die Number: "+rollFairDie() + " Unfair Die Number: " + rollUnfairDie());
		}
		//print result
		for(int i=0;i<6;i++){
			double percentage = ((int)(1000*(double)results[i]/totalRolls))/10.0;
			System.out.println((i+1)+" appeared "+percentage+"%.");
		}
	}
	//return 1,2,3,4,5,6 with equal probability
	public static int rollFairDie(){
		double rand = Math.random();
		int roll= (int)(6*rand+1); //numbers including 0 so have to add "+1" to make it 
		return roll;
	}
	public static int rollUnfairDie(){
		double rand = Math.random();
		int num1= (int)(3*rand+1); //numbers including 0 so have to add "+1" to make it 
		int num2= (int)(4*rand);
		return (num1+num2);
	}
}
