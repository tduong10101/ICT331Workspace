package Tutorial_6;
import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.GregorianCalendar;

public class TestCar {
	public static void main (String[] args){
		GregorianCalendar startDate = new  GregorianCalendar(2009,4,5);
		GregorianCalendar endDate = new GregorianCalendar (2009,4,14);
		PurchaseCar myPurchaseCar = new PurchaseCar(30000, 4000);
		RentalCar myRentalCar = new RentalCar(30000, startDate, endDate);
		System.out.println (startDate.get(DATE) +""+ startDate.get(MONTH)+""+ startDate.get(YEAR));
		System.out.println ("Cost purchase car: "+myPurchaseCar.calculateTotalCost());
		System.out.println ("Cost rental car: "+myRentalCar.calculateTotalCost());
	}
}
