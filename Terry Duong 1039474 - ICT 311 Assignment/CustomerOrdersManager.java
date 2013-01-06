import static java.util.Calendar.YEAR;

import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class CustomerOrdersManager {

	private String path;
	// private Customer[] customer;
	private java.util.ArrayList<Customer> customer = new java.util.ArrayList<Customer>();
	// Order [] order;
	private java.util.ArrayList<Order> order = new java.util.ArrayList<Order>();

	final String DOMESTIC_CUST = "domesticcustomer";
	final String IMPORT_CUST = "importcustomer";
	final String ORDER = "order";
	final String TRUE = "true";
	final String FALSE = "false";

	final int TYPE = 0;
	final int NAME = 1;
	final int ADDRESS = 2;
	final int CITY = 3;
	final int STATE = 4;
	final int SHIPPING = 5;
	final int COUNTRY = 5;
	final int INSPECT = 6;
	final int FUMIGATION = 7;
	final int VARIETY = 2;
	final int QUANREQ = 3;
	final int QUANSUP = 4;
	final int START_DATE = 5;
	final int END_DATE = 6;

	ArrayList<String> inputArray = new ArrayList<String>();
	String name = "";
	String address = "";
	String city = "";
	String state = "";
	int shipping = 0;
	String country = "";
	boolean inspection = false;
	boolean fumigation = false;
	String variety = "";
	int quanReq = 0;
	int quanSup = 0;
	String date = "";
	int day = 0;
	int month = 0;
	int year = 0;
	java.util.GregorianCalendar startDate;
	java.util.GregorianCalendar endDate;
	boolean string = true;
	boolean integer = false;
	int x = 0;

	public CustomerOrdersManager() {

	}

	public CustomerOrdersManager(String path) throws Exception {
		this.path = path;
		try {
			File fileInput = new File(this.path);
			Scanner input = new Scanner(fileInput);
			while (input.hasNextLine()) {
				inputArray.add(input.nextLine());
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(
					"Invalid Path! File's path indicated \"" + path
							+ "\" is not found");
		}

		for (int i = 0; i < inputArray.size(); i++) {
			String[] stringArray = inputArray.get(i).split("\\|");
			try {
				if ((stringArray[TYPE].toLowerCase()).equals(DOMESTIC_CUST)) {

					name = stringArray[NAME];
					address = stringArray[ADDRESS];
					city = stringArray[CITY];
					state = stringArray[STATE];

					try {
						shipping = Integer.parseInt(stringArray[SHIPPING]);
					} catch (NumberFormatException e) {
						throw new NumberFormatException(
								"Invalid input! Customer: " + stringArray[NAME]
										+ "'s shipping \""
										+ stringArray[SHIPPING]
										+ "\" is not a integer!");
					}

					addCustomer(new DomesticCustomer(name, address, city,
							state, shipping));
				} else if ((stringArray[TYPE].toLowerCase())
						.equals(IMPORT_CUST)) {

					name = stringArray[NAME];
					address = stringArray[ADDRESS];
					city = stringArray[CITY];
					state = stringArray[STATE];
					country = stringArray[COUNTRY];

					if (stringArray[INSPECT].equals(TRUE)) {
						inspection = true;
					} else if (stringArray[INSPECT].equals(FALSE)) {
						inspection = false;
					} else {
						throw new IllegalArgumentException(
								"Freight forwarder inspection of Customer: "
										+ stringArray[NAME]
										+ " must be either \"true\" or \"false\"; this is case sensitive "
										+ "\nFor example \"True\" and \"False\" are not allowed!");
					}
					if (stringArray[FUMIGATION].equals(TRUE)) {
						fumigation = true;
					} else if (stringArray[FUMIGATION].equals(FALSE)) {
						fumigation = false;
					} else {
						throw new IllegalArgumentException(
								"Freight forwarder fumigation of Customer: "
										+ stringArray[NAME]
										+ " must be either \"true\" or \"false\"; this is case sensitive "
										+ "\nFor example \"True\" and \"False\" are not allowed!");
					}

					addCustomer(new ImportCustomer(name, address, city, state,
							country, inspection, fumigation));
				} else if ((stringArray[TYPE].toLowerCase()).equals(ORDER)) {
					name = stringArray[NAME];
					boolean customerExist = false;
					Customer orderCustomer = new DomesticCustomer();
					for (int p = 0; p < this.customer.size(); p++) {
						if (name.equals(this.customer.get(p).getName())) {

							orderCustomer = this.customer.get(p);
							customerExist = true;
						}
					}

					if ((customerExist == false) && (!name.equals(""))) {
						throw new IllegalArgumentException("Customer: " + name
								+ " is not exist in the customer list");
					} else if ((customerExist == false) && (name.equals(""))) {
						throw new IllegalArgumentException(
								"There is order without customer's name!");
					}

					variety = stringArray[VARIETY];
					try {
						quanReq = Integer.parseInt(stringArray[QUANREQ]);
					} catch (NumberFormatException e) {
						throw new NumberFormatException(
								"Quantity required must be an integer!");
					}
					try {
						quanSup = Integer.parseInt(stringArray[QUANSUP]);
					} catch (NumberFormatException e) {
						throw new NumberFormatException(
								"Quantity supplied must be a integer!");
					}

					date = stringArray[START_DATE];
					date = date.replaceAll("/", "");
					try {
						x = Integer.parseInt(date);
					} catch (Exception e) {
						throw new Exception(
								"Start Date must be in dd/mm/yy format");
					}
					
					year = x % 100;
					x = (x - year) / 100;
					
					month = x % 100;
					if ((month < 1)||(month >12)){
						throw new IllegalArgumentException ("Invalid value! Month can not be less than 1 or greater than 12");
					}
					x = (x - month) / 100;
					day = x;
					if ((day < 1)||(day>31)){
						throw new IllegalArgumentException ("Invalid value! Day can not be less than 1 or greater than 31");
					}

					startDate = new GregorianCalendar(year + 2000, month - 1,
							day);

					date = stringArray[END_DATE];
					date = date.replaceAll("/", "");
					try {
						x = Integer.parseInt(date);
					} catch (Exception e) {
						throw new Exception(
								"Start Date must be in dd/mm/yy format");
					}
					
					year = x % 100;
					x = (x - year) / 100;
					month = x % 100;
					if ((month == 0)||(month >12)){
						throw new IllegalArgumentException ("Invalid value! Month can not equals to 0 or greater than 12");
					}
					x = (x - month) / 100;
					day = x;
					if ((day == 0)||(day>31)){
						throw new IllegalArgumentException ("Invalid value! Day can not equals to 0 or greater than 31");
					}
					endDate = new GregorianCalendar(year + 2000, month - 1, day);

					addOrder(new Order(orderCustomer, variety, quanReq,
							quanSup, startDate, endDate

					));
				} else {
					throw new IllegalArgumentException(
							"Insufficiant data! Data in the file is not bar (|) delimited");
				}
			} catch (IndexOutOfBoundsException e) {
				throw new IllegalArgumentException(
						"Insufficiant data! Data in the file is not bar (|) delimited");
			}

		}

	}

	public java.util.ArrayList<Customer> getCustomer() {
		return customer;
	}

	public java.util.ArrayList<Order> getOrder() {
		return order;
	}

	public void addCustomer(Customer customer) throws IllegalArgumentException {
		if (!(this.customer.contains(customer)))
			this.customer.add(customer);
		else if (this.customer.contains(customer))
			throw new IllegalArgumentException(
					"There are already an exist customer: "
							+ customer.getName()
							+ "\nCustomer name can not be duplicate!");
		for (int p = 0; p < this.customer.size(); p++) {
			customer = this.customer.get(p);
			customerSorting();
		}
	}

	public void customerSorting() {
		for (int p = 0; p < this.customer.size(); p++) {
			Customer customer1 = this.customer.get(p);

			for (int i = 0; i < this.customer.size(); i++) {

				Customer customer2 = this.customer.get(i);
				int compare = customer1.compareTo(customer2);
				if (compare % 10 < 2) {
					int customer1Index = this.customer.indexOf(customer1);
					this.customer.remove(i);
					this.customer.add(i, customer1);
					this.customer.remove(customer1Index);
					this.customer.add(customer1Index, customer2);
					customer1 = customer2;
				}
			}
		}
	}

	public void orderSorting() {
		for (int i = 0; i < this.order.size(); i++) {
			Order order1 = this.order.get(i);
			for (int p = 0; p < this.order.size(); p++) {
				Order order2 = this.order.get(p);
				int compare = order1.compareTo(order2);
				if (compare % 10 < 2) {
					int order1Index = this.order.indexOf(order1);
					this.order.remove(p);
					this.order.add(p, order1);
					this.order.remove(order1Index);
					this.order.add(order1Index, order2);
					order1 = order2;
				}
			}

		}
		for (int i = 0; i < this.order.size(); i++) {
			Order order1 = this.order.get(i);
			for (int p = 0; p < this.order.size(); p++) {
				Order order2 = this.order.get(p);
				int compare = order1.compareTo(order2);
				if ((compare / 1000 < 2) && (compare % 10 == 0)) {
					int order1Index = this.order.indexOf(order1);
					this.order.remove(p);
					this.order.add(p, order1);
					this.order.remove(order1Index);
					this.order.add(order1Index, order2);
					order1 = order2;
				}
			}
		}
	}

	public void updateCustomer(Customer oldCustomer, Customer newCustomer) {
		this.customer.remove(oldCustomer);
		addCustomer(newCustomer);
		customerSorting();
	}

	public void deleteCustomer(Customer customer) {
		this.customer.remove(customer);
		customerSorting();
	}

	public void addOrder(Order myOrder) {
		if (!(this.order.contains(myOrder)))
			this.order.add(myOrder);
		else {
			throw new IllegalArgumentException("There is already a same order exist in the order list!");
		}
		if (order.size() > 1)
			orderSorting();
	}

	public void updateOrder(Order oldOrder, Order newOrder) {
		this.order.remove(oldOrder);
		addOrder(newOrder);
		orderSorting();
	}

	public void deleteOrder(Order order) {
		this.order.remove(order);
		orderSorting();
	}

	public String toString() {
		return "";
	}

	public void toFile(String path) throws FileNotFoundException {
		File toFile = new File(path);
		try {
			PrintWriter output = new PrintWriter(toFile);
			for (int i = 0; i < this.customer.size(); i++)
				output.println(this.customer.get(i).toString());

			for (int i = 0; i < this.order.size(); i++)
				output.println(this.order.get(i).toString());
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new FileNotFoundException(
					"Invalid Path! File's path indicated \"" + path
							+ "\" is not found");
		}
	}
}
