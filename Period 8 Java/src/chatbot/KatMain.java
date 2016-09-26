package chatbot;

import java.util.Scanner;

public class KatMain {
	
	static Scanner input;
	static String user;
	static String response; 
	static boolean inMainLoop; 
	//list all the chatbots available under this class
	static Chatbot school; 

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
		inMainLoop =true;
		while(inMainLoop){
			print("Hi, "+user+ ". How are you?");
			response = promptInput();
			if(findKeyword(response, "good", 0)>=0)
				print("That's wonderful. So glad that you feel good.");
			else if(response.indexOf("school")>=0){
				print("School is great. Tell me more.");
				inMainLoop=false;
				school.talk();
			}
			else 
				print("I don't understand");
		}
	}
	public static int findKeyword(String searchString, String keyword, int startPosition) {
		//delete white space on outside
		searchString=searchString.trim();
		searchString=searchString.toLowerCase();
		keyword=keyword.toLowerCase();
		//find first position of key word
		int psn=searchString.indexOf(keyword);
		//keep searching until keyword found
		while (psn>=0){
			//assume preceeded and followed by space
			String before=" ";
			String after=" ";
			//check if character in front e=of it exists
			if(psn>0){
				before=searchString.substring(psn-1, psn);
			}
			//check for characted after keyword
			if(pns+keyword.length()<searchString.length()){
				after=searchString.substring(psn+keyword.length(),psn+keyword.length()+1);
			}
			if(before.compareTo("a")<0 && after.compareTo("a"))
				return psn;
			else
				psn=searchString.indexOf(keyword,psn+1)
		}
		return -1;
	}
	public static String promptInput(){
		String userInput = input.nextLine();
		return userInput;
	}
	public static void createFields(){
		input=new Scanner(System.in);
		user= "";
		school= new KatSchool(); 
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
		 String printString = "";
		 int cutoff = 25;
		 //this while loop last as long as there are words left in the original String
		 while(s.length() > 0){

		 String currentCut = "";
		 String nextWord = "";

		 //while the current cut is still less than the line length 
		 //AND there are still words left to add
		 while(currentCut.length()+nextWord.length() < cutoff && s.length() > 0){

		 //add the next word
		 currentCut += nextWord;
		 
		 //remove the word that was added from the original String
		 s = s.substring(nextWord.length());
		 
		 //identify the following word, exclude the space
		 int endOfWord = s.indexOf(" ");

		 //if there are no more spaces, this is the last word, so add the whole thing
		 if(endOfWord == -1) {
		 endOfWord = s.length()-1;//subtract 1 because index of last letter is one les than length
		 }

		 //the next word should include the space
		 nextWord = s.substring(0,endOfWord+1);
		 }

		 printString +=currentCut+"\n";

		 }
		 System.out.print(printString);
		 }

	}