
public class GCD {
	public static int gcd(int a, int b){
		if(b != 0 ){
			return gcd(b,a%b);
		}else{
			return a;
		}
	}
	
	public static int gcd2(int a, int b){
		while(b!=0){
			int t = b;
			b=a%b;
			a=t;
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.println(gcd2(98,63));
	}
}
