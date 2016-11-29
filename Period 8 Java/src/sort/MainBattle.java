package sort;

public class MainBattle {

	public static void main(String[] args) {
		Pokemon squirtle = new Pokemon("Squirtle",26);
		Pokemon bulbasaur = new Pokemon("Bulbasaur",26);
		squirtle.iChooseYou();
		bulbasaur.iChooseYou();
		System.out.println("Squirtle is preparing to attack with water blast");
		//anonymous inner type example
		squirtle.attack(bulbasaur, new Attack() {
			//cuts hp in half
			public void attack(Pokemon target) {
				int newHp=target.getHp()/2;
				target.setHp(newHp);
			}
		});
		System.out.println("Bulbasaur is preparing to attack with poison");
		bulbasaur.attack(squirtle, new Attack() {
			//poisons
			public void attack(Pokemon target) {
				target.setPoisoned(true);
			}
		});
		squirtle.lapse();
		bulbasaur.lapse();
		printScore(bulbasaur,squirtle);
	}
	public static void printScore(Pokemon p1, Pokemon p2){
		System.out.println(p1.getName()+", HP = "+p1.getHp());
		System.out.println(p2.getName()+", HP = "+p2.getHp());
	}

}
