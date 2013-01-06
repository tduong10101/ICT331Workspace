import java.io.*;
import java.util.*;
import javax.swing.*;
import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

public class Order {
	// private static String[] varieties;
	private static java.util.ArrayList<String> varieties = new java.util.ArrayList<String>();
	private Customer customer;
	private String variety;
	private int quantityRequired;
	private int quantitySupplied;
	private java.util.GregorianCalendar startDate;
	private java.util.GregorianCalendar endDate;

	public Order(Customer customer, String variety, int quantityRequired,
			int quantitySupplied, java.util.GregorianCalendar startDate,
			java.util.GregorianCalendar endDate) {
		this.customer = customer;
		this.variety = variety;
		this.quantityRequired = quantityRequired;
		this.quantitySupplied = quantitySupplied;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Order() {

	}

	public String toString() {
		return customer.toString() + " Variety: " + variety
				+ " QuantityRequired: " + quantityRequired
				+ " QuantitySupplied: " + quantitySupplied + " Startdate: "
				+ startDate.get(DATE) + " " + startDate.get(MONTH) + " "
				+ startDate.get(YEAR) + " Enddate: " + startDate.get(DATE)
				+ " " + startDate.get(MONTH) + " " + startDate.get(YEAR);
	}

	public int compareTo(Object o) {
		int resultCustomer = this.customer.compareTo(((Order)o).customer);
		int resultVariety = 0;
		int resultDate = 0;
		if (this.variety.compareTo(((Order)o).variety) < 0) {
			resultVariety = -9;
		} else if (this.variety.compareTo(((Order)o).variety) == 0) {
			resultVariety = 0;
		} else if (this.variety.compareTo(((Order)o).variety) > 0) {
			resultVariety = 9;
		}
		if (this.startDate.compareTo(((Order)o).startDate) < 0){
			resultDate = 27;
		}
		else if(this.startDate.compareTo(((Order)o).startDate) == 0){
			resultDate = 0;
		}
		if (this.startDate.compareTo(((Order)o).startDate) > 0){
			resultDate = -27;
		}
		return resultCustomer+resultVariety+resultDate;
	}

	public boolean equals(Object o) {
		boolean result = true;
		if ((this.customer.equals(((Order) o).customer))
				&& (this.variety.equals(((Order) o).variety))
				&& (this.startDate.equals(((Order) o).startDate))
				&& (this.endDate.equals(((Order) o).endDate))) {
			result = true;
		} else if ((this.customer.equals(((Order) o).customer))
				&& (this.variety.equals(((Order) o).variety))
				&& (this.startDate.equals(((Order) o).startDate))
				&& (this.endDate.equals(((Order) o).endDate))) {
			result = false;
		}
		return result;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void addVariety(String variety) {
		this.varieties.add(variety);
	}

	public void saveVariety(String path) throws FileNotFoundException {
		File saveVariety = new File(path);
		PrintWriter output = new PrintWriter(saveVariety);
		output.close();
	}

	public void openVariety(String path) throws FileNotFoundException {
		this.varieties = null;
		File openVariety = new File(path);
		Scanner input = new Scanner(openVariety);
		while (input.hasNext()) {
			this.varieties.add(input.next());
		}
		input.close();

	}

}
