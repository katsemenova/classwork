package guiPractice.sampleGames;

import java.awt.Color;
import java.util.ArrayList;

import guiPractice.Screen;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;

public class MyScreen extends Screen {

	private Button button;
	private Graphic picture;
	
	public MyScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		button = new Button((getWidth()-200)/2,(getHeight()-50)/2,200,50,"Click here to start",new Color(0,76,153), new Action(){
			public void act(){
				
			}
			});
		picture=new Graphic(0,0,"resourses/sampleImages/kittens.jpg");
	}

}
