package WackAMoleGame;

import guiPractice.GUIApplication;

public class WackAMoleGame extends GUIApplication {

	public WackAMoleGame() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initScreen() {
		WackAMoleScreen wamp=new WhackAMoleScreen(getWidth(),getHeight());
		setScreen(wamp);
	}

	public static void main(String[] args) {
		WackAMoleGame game=new WackAMoleGame();
		Thread app =new Thread(game);
		app.start();
	}

}
