import java.util.Scanner;

public class Fibonacci {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = Integer.parseInt(s.nextLine());
		for(int t=0;t<size;t++) {
			 int n = Integer.parseInt(s.nextLine());
			 System.out.println(fib(n));
		}
	}

	private static int fib(int n) {
		if(n==1 || n==2) {
			return 1;
		}
		return fib(n-1) + fib(n-2);
	}
}
