package tut1;
import java.util.Scanner;
public class PropertyInsurance {
	
public static void main(String[]args){
	
	//input
	double propertyValue;
	int numberOfProperties;
	double insuranceCost;
	
	// the two below are the rate???? i assume they are
	final double VALUE_LESS_10000_GREATER_5000 = 0.1; 
	final double VALUE_GREATER_THAN_10000 = 0.12;
	
	Scanner input = new Scanner(System.in);
	//Enter the value of your property
	System.out.println("Please enter the value of your property: ");
	propertyValue = input.nextDouble();
	
	//Enter the number of properties
	System.out.println("please enter the number of properts to insure: ");
	numberOfProperties = input.nextInt();
	
	//compute insurance cost
	insuranceCost = 0;
	if (propertyValue<5000)
		insuranceCost = 100;
	else if ((propertyValue<10000)&&(propertyValue>=5000)) // need to put >5000 so it wont confuse, just to make sure it work
		insuranceCost = 120 + (VALUE_LESS_10000_GREATER_5000)*(numberOfProperties - 1);
	else if (propertyValue>10000)
		insuranceCost = (0.1*propertyValue) + (VALUE_GREATER_THAN_10000 * propertyValue) * (numberOfProperties - 1);
	
	System.out.println("Insurance Cost is: " + insuranceCost);
	System.exit(0);
	
	

}


}