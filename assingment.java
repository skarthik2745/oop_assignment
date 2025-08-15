package assingment_1;
import java.util.Scanner;
public class table {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter which multiplication table you want: ");
		int a=sc.nextInt();
		System.out.println("Enter how many times you want to multiply: ");
		int n = sc.nextInt();
		System.out.println("Multiplication table: "+a);
		for(int i=1;i<=n;i++) {
			System.out.println(a+"*"+i+"="+a*i);
		}
		System.out.println("\nDone by Karthik S 2117340040057 ECE-A");
	}
	
}
