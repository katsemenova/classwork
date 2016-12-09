package guiPractice;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import guiPractice.components.Visible;

public abstract class Screen {
	
	private int width;
	private int height;
	private ArrayList<Visible> viewObjects;
	
	protected BufferedImage image;
	
	public Screen(int width, int height){
		viewObjects=new ArrayList<Visible>();
		this.width = width;
		this.height= height;
		initImage();
		initObjects(viewObjects);
		}
	
	public abstract void initObjects(ArrayList<Visible> viewObjects2);

	private void initImage() {
		image=new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		update();	
	}

	private void update() {
		Graphics2D g = image.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.black);
		//draw all visible componenets
		for(Visible v: viewObjects){
			g.drawImage(v.getImage(), v.getX(), v.getY(), null);
		}
//		g.setFont(new Font("Helvetica", Font.PLAIN,20));
//		g.drawString("Hello", 40,80);
//		g.drawOval(0, 40, 120, 80);
//		g.drawRect(20,120,80,110);
//		g.drawLine(100, 120, 110, 200);
//		g.drawLine(20, 120, 10, 200);
//		g.drawLine(230, 40, 225, 140);
//		g.setColor(Color.green);
//		for(int i=0;i<image.getWidth();i+=4){
//			g.drawLine(i, 230, i, 238);
//		}
//		for(int i=2;i<image.getWidth();i+=4){
//			g.drawLine(i, 234, i, 238);
//		}
	}
	public BufferedImage getImage(){
		return image;
	}
	//Abstraction 
	//Interface
	//	description of methods
	//abstract class
	//	some methods
	//	some description
	
}
