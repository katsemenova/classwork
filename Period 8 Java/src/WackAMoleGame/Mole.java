package WackAMoleGame;

import guiPractice.components.ClickableGraphic;

public class Mole extends ClickableGraphic implements MoleInterface {

	private double appearanceTime;
	
	public Mole(int x, int y, double scale, String imageLocation) {
		super(x, y, scale, imageLocation);
	}

	public Mole(int x, int y) {
		super(x, y, .20, "resourses/sampleImages/mole.png");
	}

	public Mole(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h, imageLocation);
		// TODO Auto-generated constructor stub
	}


	
	@Override
	public int getAppearanceTime() {
		return (int)appearanceTime;
	}

	@Override
	public void setAppearanceTime(int i) {
		// TODO Auto-generated method stub
		
		this.appearanceTime = i;
	}

}