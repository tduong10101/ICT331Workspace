package Tutorial_2;

public class TestExercise {
	public static void main (String[] arg){
		RentalMovie myRentalMovie = new RentalMovie();
		SaleMovie mySaleMovie = new SaleMovie();
	
		System.out.println ("Rental Movie Price: " + myRentalMovie.getCost());
		System.out.println ("Sale Movie Price: " + mySaleMovie.getCost());
	}
}
