import java.util.ArrayList;


public class testStringSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> stringList = new ArrayList<String>();
		stringList.add("z");
		stringList.add("f");
		stringList.add("c");
		stringList.add("a");
		for (int p = 0; p < stringList.size(); p++) {
			String string1 = stringList.get(p);

			for (int i = 0; i < stringList.size(); i++) {
				int compare = string1.compareTo(stringList.get(i));
				String string2 = stringList.get(i);
				if (compare > 1) {
					int x = stringList.indexOf(string1);
					stringList.remove(i);
					stringList.add(i, string1);
					stringList.remove(x);
					stringList.add(x, string2);
					string1 = stringList.get(i);
				}
			}
		}
		for (int i = 0; i<stringList.size();i++){
			System.out.println(stringList.get(i));
		}
	
	}

}
