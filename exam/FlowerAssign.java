import java.util.Scanner;


/**
 * 
 * IoI99_花店橱窗布置问题（普通DP）
 * @author lihan01
 *
 */
public class FlowerAssign {
	static int[][] A = new int[6][6];
	static int[][] S = new int[6][6];
	static int[] P = new int[6];
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
		for(int j = 0;j<V;j++){
			S[0][j] = A[0][j];
		}
		
		for(int i = 1;i<F;i++){
			for(int j = 0;j<V;j++){
				for(int k = 0;k<j;k++){
					if(S[i][j]<S[i-1][k]+A[i][j] && k !=j){
						S[i][j] = S[i-1][k]+A[i][j];
					}
				}
			}
		}
		
		int index = max(S[F-1]);
		P[F-1] = index + 1;
		int maxvalue = S[F-1][index];
		for(int i=F-2;i>=0;i--){
			for(int j=0;j<V;j++){
				if(S[i][j] == (maxvalue - A[i+1][P[i+1]-1])){
					P[i] = j+1;
					maxvalue = maxvalue - A[i+1][P[i+1]-1];
					break;
				}
			}
		}
		System.out.println(S[F-1][index]);
		for(int i=0;i<F;i++){
			System.out.print(P[i]+" ");
		}
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
