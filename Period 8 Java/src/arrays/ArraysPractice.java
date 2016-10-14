package arrays;

public class ArraysPractice {
	static boolean[] boos3;

	public static void main(String[] args) {
		/**
		 In java arrays have a fixed length
		  indicies with 0
		  indexed (ordered)
		  common data types, ex: Student[] has to have objects that are 
		  students so junior and senior can be in there
		  
		  if you want to put different primitive types into arrays
		  you must use wrapper case
		  
		  Primitive type arrays will always put a value of 0 in their type 
		  so for int it would be "0"
		  for double "0.0"
		  for boolean false
		 */
		//two ways to initialize array
		boolean[] boos1= new boolean[3];
		//the second way can only be done in the declaraton because it sets size and content:
		boolean[] boos2 = {false,false,false};

		//DOES NOT WORK
		//boos3={false, true, true};
		boos3= new boolean[3];
		
		/**
		 2 ways of itirating though an array:
		 Standard For Loop:
		 	- the index is important to keep track of
		 	- you need to customize the order
		 */
		for(int i=0; i<boos1.length;i++){
			System.out.println(boos1[i]); 
		}
		/**
			"For-EACH" Loop
				-the index is not important
				-don't need to customize
				-automatically assigns a "handle"'
				-faster
		 */
		for(boolean b:boos1){
			System.out.println(b);
		}
		
		//Object arrays
		String[] someStrings1 = new String[3];
		//to initialize elements you can:
//		someStrings1[0]="a";
//		someStrings1[0]="b";
//		someStrings1[0]="c";
		//but that is repetitive^^^
		
		//lets try a loop the for each loop does not work for this
		for(int i=0;i<someStrings1.length ; i++){
			someStrings1[i]="a new String";
			
		}
		
		String[] someString2= {"a","b","c"};
		
		for(String s:someStrings1){
			System.out.println(s);
		}
	}

}