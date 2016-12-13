package guiPractice.sampleGames;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import guiPractice.Screen;
import guiPractice.components.TextArea;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class CoordinateScreen extends Screen implements MouseMotionListener{

	private TextLabel label;
	private TextArea paragraph;
	public CoordinateScreen(int width, int height) {
		super(width, height);
		
	}
	
	public void initObjects(ArrayList<Visible> viewObjects2) {
		label=new TextLabel(40,45,760, 40, "Sample");
		//paragraph = new TextArea(40,85,550,500,"SAmple paragraph  SAmple SAmple paragraph SAmple paragraph SAmple paragraph SAmple paragraph SAmple paragraph SAmple paragraph SAmple paragraph SAmple paragraph SAmple paragraph SAmple paragraph SAmple paragraph ");
		viewObjects.add(label);
		//viewObjects.add(paragraph);
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
