import java.io.FileNotFoundException;
import java.util.GregorianCalendar;

public class TestInterface {

	public static void main(String[] args) {

		UserInterface myFrame = new UserInterface();
		DomesticCustomer testCust = new DomesticCustomer("lol", "address",
				"city", "state", 2);
		ImportCustomer testCust2 = new ImportCustomer("rofl", "address",
				"city", "state", "country", true, false);
		GregorianCalendar startDate = new GregorianCalendar(9, 4, 5);
		GregorianCalendar endDate = new GregorianCalendar(9, 4, 14);
		Order myOrder = new Order(testCust, "varieties nox", 150, 50,
				startDate, endDate);
		CustomerOrdersManager testManager;
		testManager = new CustomerOrdersManager("F:\\eclipse\\ICT331Workspace\\toFile.txt");
		testManager = new CustomerOrdersManager();
		testManager.addCustomer(testCust);
		testManager.addCustomer(testCust2);
		testManager.addOrder(myOrder);
		testManager.toFile("F:\\eclipse\\ICT331Workspace\\toFile.txt");
		
		
	}

}
