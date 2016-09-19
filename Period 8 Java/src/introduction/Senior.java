package introduction;

public class Senior extends Student {

	public Senior(String name) {
		super(name); //constructs a student first before making a senior
	}
	
	public void talk(){
//		super.talk();
		System.out.println(" and I am a senior!");
	}

}
