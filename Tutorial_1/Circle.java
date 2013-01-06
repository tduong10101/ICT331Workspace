package Tutorial_1;


public class Circle extends GeometricObject{
	private double radius;
	public Circle(){
		
	}
	public Circle(double radius){
		this.radius = radius;
	}
	// return radius
	public double getRadius (){
		return radius;
	}
	// set a new radius
	public void setRadius (double radius){
		this.radius = radius;
	}
	// return area
	public double getArea(){
		return radius*radius*Math.PI;
	}
	// return diameter
	public double getDiameter(){
		return radius*2;
	}
	//return perimeter
	public double getPerimeter(){
		return 2*radius*Math.PI;
	}
	//Print the circle info
	public void printCircle(){
		System.out.println("The circle is created "+getDateCreated()+"and the radius is "+radius);	
	}
	// Overriding toString() method in GeometricObject
	public String toString(){
		return super.toString() + " radius is: "+ radius;
	}
}
