package chatbot;

public class KatSchool implements Chatbot{
	
	private boolean inSchoolLoop;
	private String schoolResponse;
	@Override
	public void talk() {
		inSchoolLoop=true;
		while(inSchoolLoop){
			KatMain.print("(Type 'quit' to go back)");
			//statioc call on promptInput method from KatMain class
			schoolResponse =KatMain.promptInput();
			if(schoolResponse.indexOf("quit")>=0){
				inSchoolLoop=false;
				KatMain.promptForever();
			}
			KatMain.print("That's my favoriteee part about school.");
			
		}
		
	}

}
