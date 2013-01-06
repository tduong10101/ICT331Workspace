package tut1;

public class Tut1Exercise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RentalMovie myRentalMovie = new RentalMovie();
		SalesMovie mySalesMovie = new SalesMovie();
		
		System.out.println (myRentalMovie.getCost());
		System.out.println (mySalesMovie.getCost());
	}

}
class Movie {
	private int id = 0;
	private int price = 0;
	protected Movie(){
		id = 0;
		price = 70;
	}
	protected Movie(int id, int price){
		this.id = id;
		this.price = price;
	}
	public double getCost(){
		return this.price;
	}
}

class SalesMovie extends Movie {
	SalesMovie(){
		super(0,50);
	}
	SalesMovie(int id, int price){
		super(id, price);
	}
}

class RentalMovie extends Movie {
	private int rentalDuration = 0;
	RentalMovie(){
		super(0,70);
		rentalDuration = 3;
	}
	RentalMovie(int id, int price, int rentalDuration){
		super(id,price);
		this.rentalDuration = rentalDuration;
	}
	public double getCost(){
		return super.getCost()*rentalDuration/20;
	}
}