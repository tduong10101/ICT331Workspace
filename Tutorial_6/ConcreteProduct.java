package Tutorial_6;

public abstract class ConcreteProduct {
	private double length;
	private double width;
	protected ConcreteProduct (double length, double width){
		this.length = length;
		this.width = width;
	}
	
	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}

	public abstract double findVolume();
}

class HouseSlab extends ConcreteProduct {
	private int floors;
	public HouseSlab (double length, double width, int floors){
		super(length, width);
		this.floors = floors;
	}
	public double findVolume(){
		return super.getLength()*super.getWidth()*0.1*this.floors;
	}
}
class Pool extends ConcreteProduct{
	private double maximumDepth;
	public Pool (double length, double width, double maximumDepth){
		super(length, width);
		this.maximumDepth = maximumDepth;
	}
	public double findVolume(){
		return super.getLength()*super.getWidth()*0.25+super.getLength()+super.getWidth();
	}
}