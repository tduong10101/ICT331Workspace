package Tutorial_1;

public class ChainingConstructor extends Class1 {
	public static void main (String[] args){
		new ChainingConstructor();
	}
	public ChainingConstructor (){
		System.out.println("(4)");
	}
}
class Class1 extends Class2 {
	public Class1(){
		System.out.println ("(3)");
	}
}
class Class2 {
	public Class2(){
		System.out.println ("(2)");
	}
}
