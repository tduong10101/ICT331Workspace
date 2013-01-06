import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CustomerOrdersManager {

	final String ORDER_BORDER = "ORDER";
	private String path;
	// private Customer[] customer;
	private java.util.ArrayList<Customer> customer = new java.util.ArrayList<Customer>();
	// Order [] order;
	private java.util.ArrayList<Order> order = new java.util.ArrayList<Order>();

	public CustomerOrdersManager(String path) throws FileNotFoundException {
		this.path = path;

		File fileInput = new File(this.path);

		Scanner input = new Scanner(fileInput);
		ArrayList inputArray = new ArrayList();
		while (input.hasNext()) {
			inputArray.add(input.next());
		}
		final String DOMESTIC_CUST = "DomesticCustomer:";
		final String IMPORT_CUST = "ImportCustomer:";
		final String ADDRESS = "Address:";
		final String CITY = "City:";
		final String STATE = "State:";
		final String SHIPPING = "Shipping:";
		final String COUNTRY = "Country:";
		final String INSPECTION = "Inspection:";
		final String FUMIGATION = "Fumigation:";
		final String VARIETY = "Variety:";
		final String QUANTITY_REQ = "QuantityRequired:";
		final String QUANTITY_SUP = "QuantitySupplied:";
		final String STARTDATE = "Startdate:";
		final String ENDDATE = "Enddate:";
		final String TRUE = "true";
		final String FALSE = "false";

		ArrayList importCust = new ArrayList();
		// Input Domestic + Import Customer from inputArray ArrayList into customer ArrayList
		for (int i = 0; i < inputArray.indexOf(ORDER_BORDER); i++) {
			// if this input(i) is Domestic Customer then create a Domestic Customer Object with
			// this input(i) name, address, city, state, shipping
			if (inputArray.get(i).equals(DOMESTIC_CUST)) {
				DomesticCustomer myDomesticCust = null;
				String name = "";
				String address = "";
				String city = "";
				String state = "";
				int shipping = 0;
				// add string that in between "DomesticCustomer:" and "Address:" to name
				name = inputPara(DOMESTIC_CUST, ADDRESS, inputArray);
				// add string that in between "Address:" and "City:" to address
				address = inputPara(ADDRESS, CITY, inputArray);
				// add string that in between "City:" and "State:" to address
				city = inputPara(CITY, STATE, inputArray);
				// add string that in between "State:" and "Shipping:" to address
				state = inputPara(STATE, SHIPPING, inputArray);
				// add (int)string that next to "Shipping:"
				shipping = Integer.parseInt((String) (inputArray.get(inputArray
						.indexOf(SHIPPING) + 1)));
				// Remove previous customer properties in the inputArray
				inputArray.remove(inputArray.indexOf(SHIPPING) + 1);
				while (inputArray.indexOf(SHIPPING) != i) {
					inputArray.remove(i);
				}
				inputArray.remove(i);
				// Create Domestic Customer object and add it to the customer ArrayList
				myDomesticCust = new DomesticCustomer(name, address, city,
						state, shipping);
				
				addCustomer(myDomesticCust);			
				i = -1;
			}
			else if (inputArray.get(i).equals(IMPORT_CUST)) {
				ImportCustomer myImportCust = null;
				String name = "";
				String address = "";
				String city = "";
				String state = "";
				String country = "";
				boolean inspection = false;
				boolean fumigation = false;
				name = inputPara(IMPORT_CUST, ADDRESS, inputArray);
				address = inputPara(ADDRESS, CITY, inputArray);
				city = inputPara(CITY, STATE, inputArray);
				state = inputPara(STATE, COUNTRY, inputArray);
				country = inputPara(COUNTRY, INSPECTION, inputArray);
				if (inputArray.get(inputArray.indexOf(INSPECTION) + 1).equals(
						TRUE)) {
					inspection = true;
				} else if (inputArray.get(inputArray.indexOf(INSPECTION) + 1)
						.equals(FALSE)) {
					inspection = false;
				}
				if (inputArray.get(inputArray.indexOf(FUMIGATION) + 1).equals(
						TRUE)) {
					fumigation = true;
				} else if (inputArray.get(inputArray.indexOf(FUMIGATION) + 1)
						.equals(FALSE)) {
					fumigation = false;
				}
				// Remove previous customer properties in the Array
				inputArray.remove(inputArray.indexOf(FUMIGATION) + 1);
				while (inputArray.indexOf(FUMIGATION) != i) {
					inputArray.remove(i);
				}
				inputArray.remove(i);

				myImportCust = new ImportCustomer(name, address, city, state,
						country, inspection, fumigation);
				addCustomer (myImportCust);
				i = -1;
			}
		}
		inputArray.remove(inputArray.indexOf(ORDER_BORDER));
		for (int i = 0; i < inputArray.size(); i++){
			Order myOrder = null;
			String variety = "";
			int quantityRequired = 0;
			int quantitySupplied = 0;
			variety = inputPara(VARIETY, QUANTITY_REQ, inputArray);
			quantityRequired = Integer.parseInt(inputPara(QUANTITY_REQ, QUANTITY_SUP, inputArray));
			quantitySupplied = Integer.parseInt(inputPara(QUANTITY_SUP, STARTDATE, inputArray));
			GregorianCalendar startDate = new  GregorianCalendar(Integer.parseInt((String)inputArray.get(inputArray.indexOf(STARTDATE)+1)),Integer.parseInt((String)inputArray.get(inputArray.indexOf(STARTDATE)+2)),Integer.parseInt((String)inputArray.get(inputArray.indexOf(STARTDATE)+3)));
			GregorianCalendar endDate = new  GregorianCalendar(Integer.parseInt((String)inputArray.get(inputArray.indexOf(ENDDATE)+1)),Integer.parseInt((String)inputArray.get(inputArray.indexOf(ENDDATE)+2)),Integer.parseInt((String)inputArray.get(inputArray.indexOf(ENDDATE)+3)));
			if (inputArray.get(i).equals(DOMESTIC_CUST)){
				for (int p = 0; p <this.customer.size();p++){
					if (this.customer.get(i).compareTo(inputPara(DOMESTIC_CUST, ADDRESS, inputArray)) == 0){
						myOrder = new Order(this.customer.get(i), variety, quantityRequired, quantitySupplied, startDate, endDate );
						addOrder(myOrder);
					}
				}
			} else if (inputArray.get(i).equals(IMPORT_CUST)){
				for (int p = 0; p <this.customer.size();p++){
					if (this.customer.get(i).compareTo(inputPara(IMPORT_CUST, ADDRESS, inputArray)) == 0){
						myOrder = new Order(this.customer.get(i), variety, quantityRequired, quantitySupplied, startDate, endDate );
						addOrder(myOrder);
					}
				}
			}
			while(inputArray.indexOf(ENDDATE)!= 0){
				inputArray.remove(0);
			}
			for (int p = 0; p<3;p++){
				inputArray.remove(0);
			}
			i = -1;
		}
	}

	public String inputPara(String Tittle1, String Tittle2, ArrayList myArray) {
		String inputPara = "";
		for (int i = myArray.indexOf(Tittle1) + 1; i < myArray.indexOf(Tittle2); i++) {
			if (i == myArray.indexOf(Tittle1) + 1) {
				inputPara += myArray.get(i);
			} else {
				inputPara += " " + myArray.get(i);
			}
		}
		return inputPara;
	}

	public void addCustomer(Customer customer) {
		if (!(this.customer.contains(customer)))
			this.customer.add(customer);
	}

	public void updateCustomer(Customer oldCustomer, Customer newCustomer) {
		int oldIndex = this.customer.indexOf(oldCustomer);
		this.customer.remove(oldCustomer);
		this.customer.add(oldIndex, newCustomer);
	}

	public void deleteCustomer(Customer customer) {
		this.customer.remove(customer);
	}

	public void addOrder(Order order) {
		addCustomer (order.getCustomer());
		if (!(this.order.contains(order)))
			this.order.add(order);
	}

	public void updateOrder(Order oldOrder, Order newOrder) {
		int oldIndex = this.order.indexOf(oldOrder);
		this.order.remove(oldOrder);
		this.order.add(oldIndex, newOrder);
	}

	public void deleteOrder(Order order) {
		this.order.remove(order);
	}

	public String toString() {
		return "";
	}

	public void toFile() {
		File toFile = new File("H:\\eclipse\\ICT331Workspace\\toFile.txt");
		try {
			PrintWriter output = new PrintWriter(toFile);
			for (int i = 0; i < this.customer.size(); i++)
				output.println(this.customer.get(i).toString());
			output.println(ORDER_BORDER);
			for (int i = 0; i < this.order.size(); i++)
				output.println(this.order.get(i).toString());
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid path. File not found!");
		}
	}
}
