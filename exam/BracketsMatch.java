import java.util.Scanner;
import java.util.Stack;

/*
 * 描述
 现在，有一行括号序列，请你检查这行括号是否配对。
 *输入
 第一行输入一个数N（0<N<=100）,表示有N组测试数据。后面的N行输入多组输入数据，每组输入数据都是一个字符串S(S的长度小于10000，且S不是空串），测试数据组数少于5组。数据保证S中只含有"[","]","(",")"四种字符
 *输出
 每组输入数据的输出占一行，如果该字符串中所含的括号是配对的，则输出Yes,如果不配对则输出No
 *样例输入
 3
 [(])
 (])
 ([[]()])
 *样例输出
 No
 No
 Yes
 * */

public class BracketsMatch {
	public static void main(String[] args) {
		Stack<Character> s = new Stack<Character>();
		Scanner scanner = new Scanner(System.in);
		Integer size = Integer.parseInt(scanner.nextLine());
		String[] seqs = new String[size];
		for (int i = 0; i < size; i++) {
			seqs[i] = scanner.nextLine();
		}
		for (int ii = 0; ii < size; ii++) {
			char[] seq = seqs[ii].toCharArray();
			boolean notMatched = false;
			for (int j = 0; j < seq.length; j++) {
				if (seq[j] == '(' || seq[j] == '[') {
					s.push(seq[j]);
				} else {
					if (s.isEmpty() || !isMatch(s.pop(), seq[j])) {
						notMatched = true;
						break;
					}
				}
			}

			if (!s.isEmpty() || notMatched) {
				System.out.println("No");
			} else {
				System.out.println("Yes");
			}
			s.clear();
		}
	}

	private static boolean isMatch(Character v, char c) {
		if (v.charValue() == '[' && c == ']' || v.charValue() == '(' && c == ')') {
			return true;
		}
		return false;
	}
}
