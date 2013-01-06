package Tutorial_6;
import static java.util.Calendar.DATE;
import java.util.GregorianCalendar;

public abstract class Car {
	private int basePrice;

	protected Car(int basePrice) {
		this.basePrice = basePrice;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public abstract int calculateTotalCost();
}

class RentalCar extends Car {
	private GregorianCalendar startDate;
	private GregorianCalendar endDate;

	protected RentalCar(int basePrice, GregorianCalendar startDate,
			GregorianCalendar endDate) {
		super(basePrice);
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int calculateTotalCost() {
		int dateRent = endDate.get(DATE)-startDate.get(DATE) ;
		return (getBasePrice() * dateRent) / 1000;
	}

}

class PurchaseCar extends Car {
	private int onRoadCost;

	protected PurchaseCar(int basePrice, int onRoadCost) {
		super(basePrice);
		this.onRoadCost = onRoadCost;
	}

	public int calculateTotalCost() {

		return getBasePrice() + onRoadCost;
	}

}