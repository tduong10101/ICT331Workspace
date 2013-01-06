package Tutorial_3;
import java.io.PrintStream;
import java.util.*;
public class HandleExceptionTest {
	public static void main (String[] args){
		boolean x = true;
	
		do {
			try {
				System.out.println ("Input an integer:");
				Scanner input = new Scanner(System.in);
				int number = input.nextInt();
				myException test = new myException(number);
				x = false;
			}
			//catch (InputMismatchException ex){
			//	System.out.println ("Try again, invalid input!!! you're idiot i need an integer!!!");
			//}
			catch (IllegalArgumentException ex){
				System.out.println (ex);
			}
		} while (x);
	}
}
class myException {
	int number;
	public myException(int number){
		this.number = number;
		myMethod(this.number);
	}
	public void myMethod(int newnumber) throws IllegalArgumentException {
		if (newnumber>1){
			throw new IllegalArgumentException("go to die");
		}
		else {
			this.number = newnumber;
		}
	}
}