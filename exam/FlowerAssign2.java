import java.util.Scanner;


public class FlowerAssign2 {
	static int[][] A = new int[6][6];
	static int[][] S = new int[6][6];
	static int F;
	static int V;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] cins = scanner.nextLine().split(" ");
		F= Integer.parseInt(cins[0]);
		V= Integer.parseInt(cins[1]);	
		for(int i = 0;i<F;i++){
			String[] vs = scanner.nextLine().split(" ");
			for(int j = 0;j<V;j++){
				A[i][j] = Integer.parseInt(vs[j]);
			}
		}
		
		for(int i= 0;i<F;i++){
			if(S[i][0] + A[i][0] > S[i][0]){
				S[i][0] =S[i][0] + A[i][0];
			}else{
				S[i][0] = S[i][0];
			}
		}
		
		for(int j = 1 ;j < V ; j++) {
			for(int i= 0;i<F;i++){
				if(S[i][j-1] + A[i][j] > S[i][j-1]){
					S[i][j] =S[i][j-1] + A[i][j];
				}else{
					S[i][j] = S[i][j-1];
				}
			}
		}
		
		int temp=0;
		for(int i= 0;i<F;i++){
			temp = A[0][V-1];
			if(temp<A[i][V-1]){
				temp = A[i][V-1];
			}
		}
		
		System.out.println(temp);
	}
	
	private static int max(int[] a) {
		int index =0;
		for(int k = 0; k<V;k++){
			if(a[k] > a[index]){
				index = k;
			}
		}
		return index;
	}
}
