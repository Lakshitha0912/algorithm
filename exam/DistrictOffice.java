import java.util.Arrays;
import java.util.Scanner;

/**
 * http://acm.nyist.net/JudgeOnline/problem.php?pid=7
 *
 */
public class DistrictOffice {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = Integer.valueOf(scanner.nextLine());
		for (int t = 0; t < size; t++) {
			int count = Integer.valueOf(scanner.nextLine());
			int[] p_x = new int[count];
			int[] p_y = new int[count];
			for (int i = 0; i < count; i++) {
				String[] x_y = scanner.nextLine().split(" ");
				int x = Integer.parseInt(x_y[0]);
				int y = Integer.parseInt(x_y[1]);
				p_x[i] = x;
				p_y[i] = y;
			}

			Arrays.sort(p_x);
			Arrays.sort(p_y);
			int min_path = 0; // x[3]-x[min] + x[2]-x[min] + x[min]-x[1] + x[min]-x[0] = x[3]-x[0]+x[2]-x[1]
			for (int k = 0; k < count / 2; k++) {
				min_path += p_x[count - k - 1] - p_x[k] + p_y[count - k - 1] - p_y[k];
			}
			System.out.println(min_path);

		}
	}

}
