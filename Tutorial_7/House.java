package Tutorial_7;

public class House implements Comparable, Imperial{
	private int price;
	private double landArea;
	private int bedrooms;
	public House (int price, double landArea, int bedrooms){
		this.price = price;
		this.landArea = landArea;
		this.bedrooms = bedrooms;
	}
	public int CompareTo(Object o) {
		int result = 0;
		if (this.price == ((House)o).price){
			if (this.landArea == ((House)o).landArea){
				result = 0;
			}
			else if (this.landArea > ((House)o).landArea){
				result = 1;
			}
			else if (this.landArea < ((House)o).landArea){
				result = -1;
			}
		}
		else if (this.price > ((House)o).price){
				result = 1;
			}
		else if (this.price < ((House)o).price){
			result = -1;
		}
		return result;
	}
	public String toStringImperial() {
		return "Price: "+this.price+" Land Area: "+this.landArea*2+" Bedrooms: "+this.bedrooms;
	}
}
