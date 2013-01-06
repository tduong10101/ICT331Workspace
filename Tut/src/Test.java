import java.util.Scanner;;
public class Test {
	public static void main (String[] args){
		// code goi method ten cal
		cal();
		// print out method ten integer
		System.out.println(integer());
		int motSoNaoDo = 100;
		// print out method ten integer1 voi' parameter la` motSoNaoDo
		System.out.println (integer1(motSoNaoDo));
	}
	public static void cal () { // method nay ten la` cal void nghia la ko co' variable nao` tra? lai. tu` method nay`
		int x = 123;
		System.out.println (x);
		
	}
	public static int integer (){ // int nghia la` 1 variable integer se~ dc tra? lai tu` method nay`
		int  x = 123;
		return x; 
	}
	public static int integer1 (int x){ // (int x) dc goi. la` parameter cua? method integer1 nghia la` e  co the input 1 integer vao` de method nay`
		return x*100;
	}
	// static va` public a se~ jai? thich sau
}
