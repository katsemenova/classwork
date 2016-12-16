package guiPractice.sampleGames;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import guiPractice.Screen;
import guiPractice.components.Button;
import guiPractice.components.TextArea;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import guiPractice.components.Action;

public class CoordinateScreen extends Screen implements MouseMotionListener{

	private TextLabel label;
	private TextArea paragraph;
	private Button button;
	
	public CoordinateScreen(int width, int height) {
		super(width, height);
		
	}
	
	public void initObjects(ArrayList<Visible> viewObjects2) {
		label=new TextLabel(40,45,760, 40, "Sample");
		//paragraph = new TextArea(40,85,550,500,"SAmple paragraph  SAmple SAmple paragraph SAmple paragraph SAmple paragraph SAmple paragraph SAmple paragraph SAmple paragraph SAmple paragraph SAmple paragraph SAmple paragraph SAmple paragraph SAmple paragraph ");
		viewObjects.add(label);
		//viewObjects.add(paragraph);
		button = new Button(40,150,100,30,"Button",new Color(0,76,153), new Action(){
			public void act(){
				
			}
			});
		viewObjects.add(button);
		Graphic images=
	}

	
	public void mouseDragged(MouseEvent m) {
	
	}


	public void mouseMoved(MouseEvent m) {
		label.setText("Mouse at: "+m.getX()+", "+m.getY());
		
	}
	public MouseMotionListener getMouseMotionListener(){
		return this;
	}
}
