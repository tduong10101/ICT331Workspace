package Tutorial_3;
import java.util.*;

public class tutExercise {
	public static void main(String[] args) {
		boolean x = true;
		Scanner s = new Scanner(System.in);
		do {
			try {
				System.out.println("Input monthly repayment amount:");
				double repayment = s.nextDouble();
				System.out.println("Input number of year:");
				int numberOfYear = s.nextInt();
				double loanAmount = repayment * 12 * numberOfYear;
				System.out.println("Max loan amount is: $" + loanAmount);
				x = false;
			} catch (InputMismatchException ex) {
				System.out.println("Invalid input. Please insert a number!");
			}
		} while (x == true);
	}
}
