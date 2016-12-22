package guiPractice.components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import guiPractice.Screen;

public abstract class ClickableScreen extends Screen implements MouseMotionListener, MouseListener {

	protected ArrayList<Clickable> clickables;
	
	public ClickableScreen(int width, int height) {
		super(width, height);
	
	}

	public MouseListener getMouseListener(){
		return this;
	}
	
	public MouseMotionListener getMouseMotionListener(){
		return this;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		for(Clickable object: clickables){
			if(object.isHovered(getWidth(), getHeight())){
				object.act();
				break;
			}
			
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void addObject(Visible v){
		super.addObject(v);
		if(v instanceof Clickable)
			clickables.add((Clickable)v);
	}
	public void remove(Visible v){
		super.remove(v);
		clickables.remove(v);
	}
	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		initAllObjects(viewObjects);
		clickables=new ArrayList<Clickable>();
		for(Visible object: viewObjects){
			if(object instanceof Clickable){
				clickables.add((Clickable)object);
			}
		}
		
		
	}

	public abstract void initAllObjects(ArrayList<Visible> viewObjects);
}
