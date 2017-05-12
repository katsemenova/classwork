package test3;

public class Item {

	private boolean purchased;
	private String description;
	
	public Item(String description) {
		purchased =false;
		this.description=description;
	}
	public String getDescription(){
		return description;
	}
	public boolean getPurchased(){
		return purchased;
	}
	public void setPurchased(boolean bool){
		purchased=bool;
	}

}
