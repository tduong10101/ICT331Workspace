import java.util.ArrayList;


public class StringText {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String newString = "123|456 fgahgsajdgasj|789";
		
		System.out.println(newString);
		String[] array = newString.split("\\|");
		for (int i =0; i<array.length; i++){
			System.out.println(array[i]);
		}
	}

}