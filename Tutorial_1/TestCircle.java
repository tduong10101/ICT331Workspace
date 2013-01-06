package Tutorial_1;

public class TestCircle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle circle = new Circle(1);
		circle.setColor("red");
		System.out.println ("Circle 01 "+circle.toString());
		System.out.println ("Radius: "+circle.getRadius());
		System.out.println ("Area: "+circle.getArea());
		System.out.println ("Diameter: "+circle.getDiameter());
		System.out.println ("Perimeter: "+circle.getPerimeter());
	}

}
