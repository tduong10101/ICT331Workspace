package tut1;

public class Question17_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("(a)");
		for (int i = 0; i < 2; i++) {
			System.out.println(i + "");
			try {
				System.out.println(1 / 0);
			} catch (Exception e) {

			}
		}
		System.out.println("(b-1)");
		for (int i = 0; i < 2; i++) {
			System.out.println(i + "");
			try {
				System.out.println(1 / 0);
			} catch (Exception e) {
				System.out.println("Exception calculation invalid!");
			}
		}
		System.out.println("(b-2)");
		try {
			for (int i = 0; i < 2; i++) {
				System.out.println(i + "");
				System.out.println(1 / 0);
			}
		} catch (Exception e) {
			System.out.println("Exception calculation invalid!");
		}
	}

}
