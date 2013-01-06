package Tutorial_1;

public class TestArrayList {
	public static void main(String[] args) {
		// Create a list to store cities
		java.util.ArrayList cityList = new java.util.ArrayList();
		
		// Add some cities in the list
		cityList.add ("London");
		cityList.add ("New York");
		cityList.add ("Paris");
		cityList.add ("Toronto");
		cityList.add ("Hongkong");
		cityList.add ("Singapore");
		
		System.out.println ("List size: "+cityList.size());
		System.out.println ("Is Toronto in the list? "+ cityList.contains("Toronto"));
		System.out.println ("What is the location of New York?" + cityList.indexOf("New York"));
		System.out.println ("Is the list empty? "+cityList.isEmpty());
		
		// Insert Beijing at index 2
		cityList.add(2,"Beijing");
		
		// Remove Toronto
		cityList.remove("Toronto");
		
		// Remove city by using index
		cityList.remove (1);
		// Display London Beijing Paris Hongkong Singapore
		for (int i = 0; 1< cityList.size(); i++)
			System.out.print (cityList.get(i) + " ");
		
		//System.out.println ();
		// Create a list store 2 circles
		java.util.ArrayList list = new java.util.ArrayList();
		
		// Add two circle
		list.add(new Circle(2));
		list.add(new Circle(3));
		// Display the area of the first circle in the list
		
		System.out.println("The area of the circle? "+ ((Circle)list.get(0)).getArea());
	}

}
