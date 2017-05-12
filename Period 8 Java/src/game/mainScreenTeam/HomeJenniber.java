/**
 * 
 */
package game.mainScreenTeam;

import java.util.ArrayList;

import game.DragonLand;
import game.miniGameTeam.GameScreen;
import guiPractice.components.Action;

/**
 * @author Jenniber Franco
 *
 */
public class HomeJenniber implements Runnable {
	
	private ArrayList<HungryBox> hungryBoxTimes;
	
	//Home Jenniber begins a Thread that will randomly add hungryBoxes
	public HomeJenniber() {
		this.hungryBoxTimes = new ArrayList<HungryBox>();
		Thread hungerBegins = new Thread(this);
		hungerBegins.start();
	}
	
	//Creates a new hungryBox Thread
	//d parameter is a dragon from HomeKat.onScreenDragons
	public void createHungryThread(Dragon d){
		/**
		 * A hungryBox is created for the dragon that has been passed through the parameter
		 */
		HungryBox hungryBox = getHungryBox(d);
		d.assignHungryBox(hungryBox);
		/**
		 * When the hungryBox is clicked:
		 *	The dragon's boolean value of whether it has a hungryBox is set to false
		 *	The hungryBox is removed from the ArrayList<HungryBox> hungryBoxTimes
		 *		and it is also removed from the ArrayList<Visible> viewObjects
		 */
//		hungryBox.setAction(new Action(){
//
//			@Override
//			public void act() {
//				for(int i=0; i<HomeKat.dragonHome.getDragonsOnScreen().size();i++){
//					Dragon d= HomeKat.dragonHome.getDragonsOnScreen().get(i);
//					if((d.getY()<350 && hungryBox.getX()==d.getX()-25) || hungryBox.getY()==d.getY()+105){
//							d.setHungryBox(false);
//					}
//				}
//				
//				hungryBoxTimes.remove(hungryBox);
//				DragonLand.homeScreen.remove(hungryBox);
//			}
//			
//		});
		//hungryBox is added to hungryBoxTimes and viewObjects
		hungryBoxTimes.add(hungryBox);
		DragonLand.homeScreen.addObject(hungryBox);
		//Thread of hungryBox begins
		Thread hungry = new Thread(hungryBox);
		hungry.start();
	}
	
	/**
	 * When the hungryBox reaches 0, this function is called to remove the hungryBox from
	 * the hungryBoxTimes and from viewObjects.
	 * It also calls a method from HomeKat to remove the Dragon that had the hungryBox 
	 * @param d = Dragon that has the hungryBox
	 * @param hungry = hungryBox that has already reached 0 or less
	 */
	public void removeHungryAndDragon(Dragon d, HungryBox hungry) {
		hungryBoxTimes.remove(hungry);
		HomeKat.dragonHome.removeHungryDragon(d);
		DragonLand.homeScreen.remove(hungry);
	}

	/**
	 * Checks the dragons that were bought and are in the homeScreen 
	 */
	public void checkRemoveDragon() {
		for(int i=0; i< HomeKat.dragonHome.getDragonsOnScreen().size();i++){
			Dragon d = HomeKat.dragonHome.getDragonsOnScreen().get(i);
			if(d.getHungryBox()){
				for(int j=0; j<hungryBoxTimes.size(); j++){
					HungryBox hungryBox = hungryBoxTimes.get(j);
					if(
							(
									//Checks if the dragon is moving vertically and if it is
									//it compares the xCoordinates of the dragon and hungryBox
									(d.getY()<350 && hungryBox.getX()==d.getX()-25)
									//If dragon is moving horizontally,
									//it compares the yCoordinates of the dragon and hungryBox
									|| hungryBox.getY()==d.getY()+105
							) 
							//Checks if the hungryBox time is less than 0 to remove
							&& hungryBox.getHungryTime()<=0){
						removeHungryAndDragon(d,hungryBox);
					}
				}
			}
		}
	}
	
	//Retrieves a random dragon that does not have a hungryBox to set it to have a hungryBox
	public Dragon getRandDragon(){
		//Will return a randomly selected dragon from the ones currently being displayed on the HomeScreen
		int randNum = (int) (Math.random()*HomeKat.dragonHome.getDragonsOnScreen().size());
		while(HomeKat.dragonHome.getDragonsOnScreen().get(randNum).getHungryBox()){
			randNum = (int) (Math.random()*HomeKat.dragonHome.getDragonsOnScreen().size());
		}
		HomeKat.dragonHome.getDragonsOnScreen().get(randNum).setHungryBox(true);
		
		return HomeKat.dragonHome.getDragonsOnScreen().get(randNum);
	}

	//returns a new HungryBox by setting its position relative to the Dragon d
	public HungryBox getHungryBox(Dragon d) {
		int yCoord = d.getY()+105;
		//Checks if dragon is moving vertically
		if(d.getY()<350){
			yCoord+=30;
		}
		return new HungryBox(d.getX()-25,yCoord);
	}

	/**
	 * Starts as a thread that will sleep for random moments in time 
	 * from an interval of 3 to 7 seconds.
	 * It will the check if there any dragon that have been bought.
	 * If there are dragons bought and there are less hungryBoxes than Dragons,
	 * 	a hungryThread might be created if Math.random() returns a double>0.5 
	 * 
	 */
	@Override
	public void run() {
		while(true){
			try {
				int sleepingTime = (int)(Math.random()*4000)+3000;
				Thread.sleep(sleepingTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!GameScreen.isNotHome 
					&& HomeKat.dragonHome.getDragonsOnScreen().size()>0 
					&& hungryBoxTimes.size()<HomeKat.dragonHome.getDragonsOnScreen().size())
				{
					double probability = .5;
					if(Math.random()>probability){
						createHungryThread(getRandDragon());
					}
				}
		}
		
	}

	public void editHungryBoxTimes(Dragon d){
		for(int i=0; i<hungryBoxTimes.size();i++){
			HungryBox hungryBox= hungryBoxTimes.get(i);
			if((d.getY()<350 && hungryBox.getX()==d.getX()-25) || hungryBox.getY()==d.getY()+105){
				hungryBoxTimes.remove(hungryBox);
				DragonLand.homeScreen.remove(hungryBox);
			}
		}
	}

	public void removeHungry(HungryBox hungryBox) {
		hungryBoxTimes.remove(hungryBox);
		DragonLand.homeScreen.remove(hungryBox);
	}

	public void checkFeed(int x, int y) {
		Dragon fed;
		for(int i=0; i<HomeKat.dragonHome.getDragonsOnScreen().size();i++){
			Dragon d= HomeKat.dragonHome.getDragonsOnScreen().get(i);
			if(d.getHungryBox()&&(x>=d.getX()&&x<=d.getHeight()+d.getWidth())
					&&(y>=d.getY()&&y<=d.getY()+d.getHeight())){
					d.setHungryBox(false);
					fed=d;
					removeHungry(d.getHungryBoxObj());
					break;
			}
		}
		
	}
}