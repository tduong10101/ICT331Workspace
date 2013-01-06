import java.util.ArrayList;
import java.util.Scanner;


public class sorting {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> stringList= new ArrayList<String>();
		Scanner x  = new Scanner (System.in);
		System.out.println ("Input string:");
		for (int i =0; i<10;i++)
			
			stringList.add(x.next());
			String topString = "";
		for (int i = 0; i < stringList.size();i++){
			topString = stringList.get(i);
			for (int p = 0; p< stringList.size(); p++){
				if (topString.compareTo(stringList.get(p))== -1)
					topString = stringList.get(p);
				
			}
			System.out.println (topString);
			
		}
		
	}

}
