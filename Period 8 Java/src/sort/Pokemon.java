package sort;

public class Pokemon {
	private int level;
	private int hp;
	private String name;
	private boolean poisoned;
	
	public void constructor(String n, int l){
		name=n;
		level=l;
		hp=100;
		poisoned=false;
		
	}
	public void iChooseYou(){
		System.out.println(name+", " + name +"!");
	}
	public void setHp(int newHp) {
		this.hp = newHp;
	}
	public String getName() {
		return name;
	}
	public void setPoisoned(boolean poisoned) {
		this.poisoned = poisoned;
	}
	public void lapse(){
		if(poisoned)
			hp-=15;
	}

}
