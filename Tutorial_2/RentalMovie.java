package Tutorial_2;

public class RentalMovie extends Movie {
	private int rentalDuration;
	public RentalMovie(){
		super();
		this.rentalDuration = 3;
	}
	public RentalMovie(int id, int price, int rentalDuration){
		super(id, price);
		this.rentalDuration = rentalDuration;
	}
	public double getCost(){
		return super.getCost()*this.rentalDuration/20;
	}
}
