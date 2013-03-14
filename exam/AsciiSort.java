import java.util.Arrays;
import java.util.Scanner;

/**
 * http://acm.nyist.net/JudgeOnline/problem.php?pid=4
 * @author lihan01
 *
 */
public class AsciiSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = Integer.parseInt(scanner.nextLine());
		for(int i=0;i<size;i++) {
			String q = scanner.nextLine();
			char[] qArray = q.toCharArray();
			Arrays.sort(qArray);
			for(int j=0;j<qArray.length;j++){
				System.out.println(qArray[j] + " ");
			}
		}
	}
}
