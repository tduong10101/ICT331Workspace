package Tutorial_1;

import java.util.Scanner;

public class TestPolymorphismCasting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Declare and initialise two objects
		Object object1 = new Circle(1);
		Object object2 = new Scanner(System.in);
		//Display circle
		displayObject(object1);
		displayObject(object2);
	}
	public static void displayObject(Object object){
		if (object instanceof Circle){
			System.out.println("Circle area: "+((Circle)object).getArea());			
		}
		else {
			System.out.println("This object is not a circle");
		}
	}
}
