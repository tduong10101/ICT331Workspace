package Tutorial_3;

import java.util.*;

public class ArrayOutOfBound {
	public static void main (String[] args){
		// Create an array contain 100 random
		ArrayList randomNumberArray = new ArrayList();
		for (int i = 0; i < 100;i++ ){
		int randomNumber  = (int)(Integer.MAX_VALUE*Math.random());
		randomNumberArray.add(randomNumber); 
		}
		// Get array index from user
		Scanner s = new Scanner (System.in);
		boolean inputIsValid = true;
		do{
		System.out.println("Input array index");
		try{
			int index = s.nextInt();
		
		// Display random integer at the specified index
			System.out.println ("Number at specified position: "+randomNumberArray.get(index));
		}
		// or "Out of  Bound" message if the index doesnt exit
		catch (IndexOutOfBoundsException ex){
			System.out.println ("Out of  Bound");
			inputIsValid = false;
		}
		catch (InputMismatchException ex){
			System.out.println ("Please input integer");
			inputIsValid = false;
		}
		} while(inputIsValid == false);
		// exist
	}
}
