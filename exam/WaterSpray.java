import java.util.Arrays;
import java.util.Scanner;


/**
 * http://acm.nyist.net/JudgeOnline/problem.php?pid=6
 *
 */
public class WaterSpray {
	
	private static final double L=20;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int size = Integer.parseInt(scanner.nextLine());
		for(int t = 0;t<size;t++) {
			int count = Integer.parseInt(scanner.nextLine());
			String[] rs = scanner.nextLine().split(" ");
			double[] rArray = new double[count];
			for(int i = 0; i<count;i++){
				try{
				rArray[i] = Double.valueOf(rs[i]);
				}catch(Exception e){}
			}
			Arrays.sort(rArray);
			double dr = 0;
			for(int j = rArray.length -1;j>=0;j--){
				dr = dr + 2*Math.sqrt(rArray[j]*rArray[j] - 1);
				if(dr>=L){
					System.out.println(rArray.length-j);
					break;
				}
				
			}
		}
	}

}
