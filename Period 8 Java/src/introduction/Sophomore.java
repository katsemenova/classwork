package introduction;

public class Sophomore extends Student {

	public Sophomore(String name, String majorPreference) {
		super(name);
		String majorPreference = this.majorPreferece;
	}
	public void talk(){
		super.talk();
		System.out.println(" and I am a sophomore!");
	}

}
