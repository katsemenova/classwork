package WackAMoleGame;

import guiPractice.components.Action;
import guiPractice.components.Clickable;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Visible;

public interface MoleInterface extends Clickable {


	int getAppearanceTime();

	void setAppearanceTime(int i);

	void setAction(Action action);

}
