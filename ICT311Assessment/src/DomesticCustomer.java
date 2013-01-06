
public class DomesticCustomer extends Customer {
	private int shipping;
	final int AIR = 0;
	final int ROAD = 1;
	final int RAIL = 2;
	public DomesticCustomer (String name,String address, String city, String state, int shipping){
		super(name, address,city, state);
		this.shipping = shipping;
	}
	public DomesticCustomer (){
		
	}
	public String toString (){
		return "Domestic"+super.toString() + " Shipping: " + shipping;
	}
}
