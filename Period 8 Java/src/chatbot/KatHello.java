package chatbot;

public class KatHello implements Chatbot {

	private String helloResponse;
	private boolean inHelloLoop;
	private String[] calmResponses = {"Yes. Hello indeed. Let's get past the introduction, "
			+ "shall we?","We've already said our hellos, shall we move on from here?",
			"I said HELLO already, didn't you catch that?"};
	private String[] angryResponses = {"Seriously, stop saying hello.", "What is wrong with you?"};

	private int helloCount;
	
	public KatHello(){
		helloCount=0; 
	}
	
	public void talk() {
		inHelloLoop=true;
		while(inHelloLoop){
			helloCount++; 
			printResponse(); //helper method
			helloResponse=KatMain.promptInput();
			//to negate use !
			if(!isTriggered(helloResponse)){
				inHelloLoop=false;
				KatMain.promptForever();
			}
			
		}
	}

	private void printResponse() {
		if(helloCount>4){
			int responseSelection=(int)(Math.random()*angryResponses.length);
			KatMain.print(angryResponses[responseSelection]);	
		}else{
			int responseSelection=(int)(Math.random()*calmResponses.length);
			KatMain.print(calmResponses[responseSelection]);	
		}
	}

	@Override
	public boolean isTriggered(String userInput) {
		if(KatMain.findKeyword(userInput,"hello",0)>=0)
			return true;
		if(KatMain.findKeyword(userInput,"hi",0)>=0)
			return true;
		if(KatMain.findKeyword(userInput,"hey",0)>=0)
			return true;
		return false;
	}

}
