package guiPractice;

import java.awt.Graphics;

import javax.swing.JFrame;

public abstract class GUIApplication extends JFrame {

	private Screen currentScreen;
	//no main, cant instentiate an abstract class
	public GUIApplication(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		int x=40;
		int y=40;
		int width=600;
		int height=400;
		setBounds(x,y,width,height);
		initScreen();
		setVisible(true);
	}
	//this is a method for creating the starting screen
	protected abstract void initScreen();
	
	public void setScreen(Screen screen){
		currentScreen=screen;
	}
	public void paint(Graphics g){
		g.drawImage(currentScreen.getImage(), 0, 0, null);
	}

}
