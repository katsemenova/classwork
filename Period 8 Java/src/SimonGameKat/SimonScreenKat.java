package SimonGameKat;

import java.util.ArrayList;

import guiPractice.ClickableScreen;
import guiPractice.components.Button;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class SimonScreenKat extends ClickableScreen implements Runnable {

	private ProgressInterfaceKat progress;
	private ArrayList<MoveInterfaceKat> moves;
	private int roundNumber;
	private boolean acceptingInput;
	private TextLabel txtLabel;
	private ButtonInterfaceKat[] button;
	private int lastSelectedButton;
	private int sequenceIndex;
	
	public SimonScreenKat(int width, int height) {
		super(width, height);
		Thread app=new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		addButtons();
		progress = getProgress();
		txtLabel = new TextLabel(130,230,300,40,"Let's play Simon!");
		moves = new ArrayList<MoveInterfaceKat>();
		//add 2 moves to start
		lastSelectedButton = -1;
		moves.add(randomMove());
		moves.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(txtLabel);
	}

	public MoveInterfaceKat randomMove() {
		ButtonInterfaceKat b;
		int randomNumber;
		while(true){
			randomNumber=(int)Math.random()*(button.length-1);
			b=button[randomNumber];
			if(b!=button[lastSelectedButton]);
				break;
		}
		lastSelectedButton=randomNumber;
		return getMove(b);
	}

	public MoveInterfaceKat getMove(ButtonInterfaceKat b) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProgressInterfaceKat getProgress() {
		// placeholder
		return null;
	}

	public void addButtons() {
		int numberOfButtons=5;
		for(int i=0;i<5;i++){
			
		}
	}

}
