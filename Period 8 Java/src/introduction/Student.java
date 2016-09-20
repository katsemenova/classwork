package introduction;

public class Student {
	//fields
	private String name;
	//constructor(initialize fields), the name within the initialize field is local 
	public Student(String name){
		this.name = name; 
		//this refers to the global variable
	}
	//this talk method calls a variable "name" which calls the global variable not the 
	//variable inside the constructor because that one is local
	public void talk(){
		System.out.print("Hello, my name is " + name);
	}
}
