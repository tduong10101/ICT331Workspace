import java.util.ArrayList;

public class DomesticCustomer extends Customer {
	private int shipping;
	final int AIR = 0;
	final int ROAD = 1;
	final int RAIL = 2;
	final String[] STATE = { "ACT", "NSW", "NT", "QLD", "SA", "TAS", "VIC",
			"WA" };

	public DomesticCustomer(String name, String address, String city,
			String state, int shipping) throws IllegalArgumentException {
		super(name, address, city, state);
		boolean stateException = true;
		for (int i = 0; i < STATE.length; i++) {
			if (state.equals(STATE[i]))
				stateException = false;
		}
		if (stateException == true) {
			throw new IllegalArgumentException(
					"Domestic customer: " +name+" must have one of the following (case sensitive) " +
					"\nstate values: ACT, NSW, NT, QLD, SA, TAS, VIC, WA");
		}
		
		if ((shipping <0)||(shipping>2)){
			throw new IllegalArgumentException(
					"Shipping of Customer: "+name+" must be an integer with value 0, 1 or 2!");
		}
		this.shipping = shipping;
	}

	public int getShipping() {
		return shipping;
	}

	public DomesticCustomer() {

	}

	public String toString() {
		return "Domestic" + super.toString() + "|" + shipping;
	}
}
