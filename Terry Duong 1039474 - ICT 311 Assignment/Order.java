import java.io.*;
import java.util.*;
import javax.swing.*;
import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

public class Order {
	// private static String[] varieties;
	private static ArrayList<String> varieties = new ArrayList<String>();
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
		if (variety.equals("")){
			throw new IllegalArgumentException ("Variety of Order: "+customer.getName()+" "+getStartDate()+" - "+getEndDate()+" must contain more than zero character!");
		} else if (quantityRequired < 0){
			throw new IllegalArgumentException ("Quantity required of Order: "+customer.getName()+" "+getStartDate()+" - "+getEndDate()+" must be an integer greater than zero!");
		}else if (quantitySupplied < 0){
			throw new IllegalArgumentException ("Quantity supplied of Order: "+customer.getName()+" "+getStartDate()+" - "+getEndDate()+" must be an integer greater than zero!");
		}else if (quantitySupplied > quantityRequired){
			throw new IllegalArgumentException ("Quantity supplied of Order: "+customer.getName()+" "+getStartDate()+" - "+getEndDate()+" must not be greater than quantity required");
		}else if (startDate.after(endDate)){
			throw new IllegalArgumentException ("Start date of Order: "+customer.getName()+" "+getStartDate()+" - "+getEndDate()+" must not occur after order end date");
		}
		addVariety(variety);
	}

	public Order() {

	}

	public String toString() {
		String sDay = converString(startDate.get(DATE));
		String sMonth = converString(startDate.get(MONTH));
		String sYear = converString(startDate.get(YEAR));
		String eDay = converString(endDate.get(DATE));
		String eMonth = converString(endDate.get(MONTH));
		String eYear = converString(endDate.get(YEAR)-2000);
		return "Order" + "|"+ customer.getName() + "|" + variety
				+ "|" + quantityRequired
				+ "|"  + quantitySupplied + "|"
				+ getStartDate() + "|" + getEndDate();
	}

	public String getVariety() {
		return variety;
	}

	public int getQuantityRequired() {
		return quantityRequired;
	}

	public int getQuantitySupplied() {
		return quantitySupplied;
	}

	public String getStartDate() {
		String sDay = converString(startDate.get(DATE));
		String sMonth = converString(startDate.get(MONTH)+1);
		String sYear = converString(startDate.get(YEAR)-2000);
		return sDay + "/" + sMonth + "/"  + sYear;
	}

	public String getEndDate() {
		String eDay = converString(this.endDate.get(DATE));
		String eMonth = converString(this.endDate.get(MONTH)+1);
		String eYear = converString(this.endDate.get(YEAR)-2000);
		return eDay + "/" + eMonth + "/"  + eYear;
	}

	public String converString(int number){
		String myString = "";
		if ((number)/10 >= 1){
			myString = (number%100)+"";
		}
		else if ((number)/10 < 1){
			myString = "0"+(number%100);
		}
		return myString;
		
	}
	
	public int compareTo(Object o) {
		int resultCustomer = this.customer.compareTo(((Order)o).customer);
		int resultVariety = 0;
		int resultDate = 0;
		if (this.variety.compareTo(((Order)o).variety) < 0) {
			resultVariety = 100;
		} else if (this.variety.compareTo(((Order)o).variety) == 0) {
			resultVariety = 0;
		} else if (this.variety.compareTo(((Order)o).variety) > 0) {
			resultVariety = 200;
		}
		if (this.startDate.before(((Order)o).startDate)){
			resultDate = 1000;
		}
		else if(this.startDate.compareTo(((Order)o).startDate) == 0){
			resultDate = 0;
		}
		if (this.startDate.after(((Order)o).startDate)){
			resultDate = 2000;
		}
		return resultCustomer+resultVariety+resultDate;
	}

	public boolean equals(Object o) {
		boolean result = true;
		if (this.customer.equals(( (Order)o ).customer)
				&& this.variety.equals(((Order) o).variety)
				&& this.startDate.equals(((Order) o).startDate)
				&& this.endDate.equals(((Order) o).endDate)) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	public Customer getCustomer() {
		return customer;
	}

	public static java.util.ArrayList<String> getVarieties() {
		return varieties;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public static void addVariety(String variety) {
		if (variety.equals("")){
			throw new IllegalArgumentException ("Variety must contain more than 0 character!");
		}
		if (!(Order.varieties.contains(variety)))
			Order.varieties.add(variety);
	}

	public static void saveVariety(String path) throws FileNotFoundException {
		File saveVariety = new File(path);
		PrintWriter output = new PrintWriter(saveVariety);
		for (int i = 0; i < Order.varieties.size(); i++)
			output.println(Order.varieties.get(i));
		output.close();
	}

	public static void openVariety(String path) throws FileNotFoundException {
		try {
		File openVariety = new File(path);
		Scanner input = new Scanner(openVariety);
		
		while (input.hasNextLine()) {
			//Order.addVariety(input.next());
			addVariety(input.nextLine());
		}
		input.close();
		}catch (FileNotFoundException e){
			throw new FileNotFoundException ("Invalid Path! File's path indicated \""+path+"\" is not found");
		}
	}
	public static void main (String[] args0){
		String x = "31/12/09";
		String y = x.replace("/", "");
		
		int z = Integer.parseInt(y);
		System.out.println(z);
		int year = z % 100;
		z = (z - year) / 100;
		int month = z % 100;
		z = (z - month) / 100;
		int day = z;
		System.out.println(day+" "+month+" "+year);
		GregorianCalendar startDate = new  GregorianCalendar(9,4,5);
		System.out.println(startDate.get(YEAR));
	}
}
