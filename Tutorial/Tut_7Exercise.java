package Tutorial;

public class Tut_7Exercise {

	public static void main(String[] args) {
		House myHouse = new House (37000,0.2,3);
		House myHouse0 = new House (37000,4,2);
		if (myHouse.CompareTo(myHouse0)== 1)
			System.out.println(myHouse.toStringImperial());
		else  System.out.println (myHouse0.toStringImperial());

	}

}
