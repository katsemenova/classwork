package introduction;

import java.util.Scanner;

public class StringPracticeExtraCredit {
	
	static Scanner input;
	static String user;

	public static void main(String[] args) {
//		demonstrateStringMethods();
		createFields();
		promptName();
		promptForever();
		
	}
	public static void promptName(){
	print("Enter your name");
	user=input.nextLine();
	print("Glad to meet you "+user+". For the rest of time I will call you " +user +". You may call me Computer. We will be friends.");
	}

	public static void promptForever() {
		while(true){
			promptInput();
		}
	}
	public static void promptInput(){
		print("Please type something "+user);
		String userInput = input.nextLine();
		print("Congrats, you typed: "+userInput);
	}
	public static void createFields(){
		input=new Scanner(System.in);
		user= "";
	}
	public static void demonstrateStringMethods(){
		String text1 = new String("Hello World");
		String text2 = "Hello World";
			
		if (text1.equals(text2))
			print("These strings are equal");
		else
			print("These strings are NOT equal");
		
		String word1="Aardvark";
		String word2="Zyzzyva";
		
		if(word1.compareTo(word2)<0){
			print("word1 comes before word2");
		}
	}
	public static void print(String s){
		String printString=s;
		int cutoff=15;
		if(printString.length()>cutoff){
			printString="";
			for(int i=0;(i+1)*cutoff<s.length();i++){
				int beginCut;
				if(i==0)
					beginCut=0;
				else
					beginCut=i+1;
				printString+=getCut(s,beginCut,cutoff,i+1)+i+"\n";
				
			}
		}
		System.out.println(printString);
	}
	
	private static String getCut(String s,int beginCut, int cutoff, int cut)
	{
		
		int cutIndex=cut*cutoff;
		if(cutIndex>s.length())
			cutIndex=s.length();
		String currentCut=s.substring(beginCut, cutIndex);
		
		int indexOfLastSpace=currentCut.length()-1;
		for(int i=indexOfLastSpace; i>=0;i--){
			String letter = currentCut.substring(i, i+1);
			if(letter.equals(" ")){
				indexOfLastSpace=i;
				break;
			}
		}
		currentCut=currentCut.substring(0, indexOfLastSpace);
		return currentCut;
	}

}
