package sort;

public class Pokemon {
	private int level;
	private int hp;
	private String name;
	private boolean poisoned;
	
	public  Pokemon(String n, int l){
		name=n;
		level=l;
		hp=100;
		poisoned=false;
		
	}
	public void attack(Pokemon target, Attack attack){
		if(Math.random()<.9){
			attack.attack(target);
			System.out.println("The attack hit");
		}else{
			System.out.println("The attack missed");
		}
	}
	public void iChooseYou(){
		System.out.println(name+", " + name +"!");
	}
	public void setHp(int newHp) {
		this.hp = newHp;
	}
	public int getHp() {
		return hp;
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
