package introduction;

public class Sophomore extends Student {

	private String majorPreference;
	public Sophomore(String name, String majorPreference) {
		super(name);
		this.majorPreference = majorPreference;
	}
	public void talk(){
		super.talk();
		System.out.println(" and I am a sophomore!" + majorPreference);
	}

}
