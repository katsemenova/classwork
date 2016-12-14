package guiPractice.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Button extends TextLabel implements Clickable{
	
	private Color color;
	private Action action;
	private String text;
	
	public Button(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text);
		this.color=color;
		this.action=action;
		this.text=text;
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.BLACK);
		if(text!=null){
			g.setFont(new Font(getFont(), Font.PLAIN,getSize()));
			g.drawString(text, 4, getHeight()-5);
		}
		g.drawRoundRect(getX(), getY(), getWidth(), getHeight(), 25, 35);
		g.setColor(color);
		g.fillRoundRect(getX(), getY(), getWidth(), getHeight(), 25, 35);
	}

	@Override
	public boolean isHovered(int x, int y) {
		if(x>getX()&&x<getX()+getWidth()&&y>getY()&&y<getY()+getHeight())
			return true;
		return false;
	}

	@Override
	public void act() {
		action.act();
	}

}
