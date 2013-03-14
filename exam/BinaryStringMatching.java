import java.util.Scanner;

/**
 * http://acm.nyist.net/JudgeOnline/problem.php?pid=5
 * 
 * @author lihan01
 * 
 */
public class BinaryStringMatching {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = Integer.parseInt(scanner.nextLine());
		for (int t = 0; t < size; t++) {
			String bSubString = scanner.nextLine();
			String bString = scanner.nextLine();
			char[] bSubStringArray = bSubString.toCharArray();
			char[] bStringArray = bString.toCharArray();
			int times = 0;
			for (int i = 0; i < bStringArray.length; i++) {
				boolean matched = true;
				if (i + bSubStringArray.length <= bStringArray.length) {
					for (int j = 0; j < bSubStringArray.length; j++) {
						if (bSubStringArray[j] != bStringArray[i + j]) {
							matched = false;
							break;
						}
					}
					if (matched) {
						times++;
					}
				}
			}
			System.out.println(times);
		}
	}
}
