import java.util.Scanner;
import java.util.Stack;

/*
 * ����
 ���ڣ���һ���������У����������������Ƿ���ԡ�
 *����
 ��һ������һ����N��0<N<=100��,��ʾ��N��������ݡ������N����������������ݣ�ÿ���������ݶ���һ���ַ���S(S�ĳ���С��10000����S���ǿմ���������������������5�顣���ݱ�֤S��ֻ����"[","]","(",")"�����ַ�
 *���
 ÿ���������ݵ����ռһ�У�������ַ�������������������Եģ������Yes,�������������No
 *��������
 3
 [(])
 (])
 ([[]()])
 *�������
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
