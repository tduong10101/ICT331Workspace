import java.util.*;
public class anhYeuEm {
	public static void main (String[] args){
		int traLoi = 0;
		int shock = 0;
		do{
			System.out.println ("Anh yeu em, em co yeu anh ko??? Tra loi bang number <0 = Khong; >0 = Co; =0 = Khong biet ");
			Scanner input = new Scanner(System.in);
			traLoi = input.nextInt();
			if (traLoi>0){
				System.out.println("Anh biet anh dep trai, ai ma khong yeu, (cuoi to) he he he!!!");
			}else if (traLoi==0){
				System.out.println("Nhin anh ne, ko biet ji ma ko biet, noi dai di. Anh hoi lai ne.");
			}else if ((traLoi <0)&&(shock==0)){
				System.out.println("Anh biet em dang doi long phai ko? noi cho anh nghe di");
				shock = 1;
			}else if ((traLoi <0)&&(shock==1)){
				System.out.println("Ki wa dzay ne troi, khong wai da? anh hoi lai lan nua ne, ko thix gion ah nha");
				shock = 2;
			}
			else if ((traLoi <0)&&(shock==2)){
				System.out.println("Nan ni ma, yeu anh di, yeu anh di");
				shock = 3;
			}
			else if ((traLoi <0)&&(shock==3)){
				System.out.println("Chanh ha, \"hot\" dzay ma che ha, eh chet luon di" +
						"\n(Tat con nho 1 cai roi nhay wa con nho ke ben)");
				traLoi = 1;
			}
		}while (traLoi<=0);
	}
}
