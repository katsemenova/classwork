package introduction;

public class OOPExample {

	public static void main(String[] args) {
		Student jillian = new Senior("Jillian");
		Student joseph = new Junior("Joseph");
		Student jordan = new Sophomore("Jordan", "Software Engineer");
		Student jack = new Senior("Jack");
		
		
		jillian.talk();
		joseph.talk();
		jordan.talk();
		jack.talk();

	}

}
