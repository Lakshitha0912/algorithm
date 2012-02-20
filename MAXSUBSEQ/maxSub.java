import java.util.Arrays;
import java.util.List;

public class maxSub {
	public static void main(String[] args) {
		Integer[] list = { -6, 2, 4, -7, 5, 3, 2, -1, 6, -9, 10, -2 };
//		System.out.println(maxSubSeqUsingRec(Arrays.asList(list),0,list.length-1));
		System.out.println(maxSubSum4(Arrays.asList(list)));
	}

	public static int maxSubSum4(List<Integer> a) {
		int maxSum = 0, thisSum = 0;
		for (int j = 0; j < a.size(); j++) {
			thisSum += a.get(j);
			if (thisSum > maxSum)
				maxSum = thisSum;
			else if (thisSum < 0)
				thisSum = 0;  //丢弃掉，因为他不可能作为子串的前缀
		}
		return maxSum;
	}
	public static int maxSubSeqUsingRec(List<Integer> list, int left, int right) {
		int[] x ={0,1};
		if (left == right) {
			if (list.get(left) > 0) {
				return list.get(left);
			} 
			return 0;
		}
		int center = (left + right) / 2;
		int maxLeftSum = maxSubSeqUsingRec(list, left, center);
		int maxRightSum = maxSubSeqUsingRec(list, center+1, right);
		int maxLeftBorderSum = 0, leftBorderSum = 0;
		for (int i = center; i >= left; i--) {
			leftBorderSum += list.get(i);
			if (leftBorderSum > maxLeftBorderSum){
				maxLeftBorderSum = leftBorderSum;
				x[0] = i-1;
			}
		}
		// 求出以右边对后一个数字结尾的序列最大值
		int maxRightBorderSum = 0, rightBorderSum = 0;
		for (int j = center + 1; j <= right; j++) {
			rightBorderSum += list.get(j);
			if (rightBorderSum > maxRightBorderSum){
				maxRightBorderSum = rightBorderSum;
				x[1] = j;
			}
		}
		System.out.println(x[0]+","+x[1]);
		return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
	}


	private static int max3(int a, int b, int c) {
		if (a < b) {
			a = b;
		}
		if (a > c)
			return a;
		else
			return c;
	}

	public static int maxSubSeq2(List<Integer> list) {
		int[] x = { 0, 1 };
		int maxSum = 0;
		for (int i = 0; i < list.size(); i++) {
			int thisSum = 0;
			for (int j = i; j < list.size(); j++) {
				thisSum += list.get(j);
				if (thisSum > maxSum) {
					maxSum = thisSum;
					x[0] = i-1;
					x[1] = j;
				}
			}
		}
		System.out.println(x[0] + "," + x[1]);
		return maxSum;
	}

	public static int maxSubSeq(List<Integer> list) {
		int[] x = { 0, 1 };
		int maxSum = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = i; j < list.size(); j++) {
				int thisSum = cursum(list, i, j);
				if (thisSum > maxSum) {
					maxSum = thisSum;
					x[0] = i-1;
					x[1] = j;
				}
			}
		}
		System.out.println(x[0] + "," + x[1]);
		return maxSum;
	}

	private static int cursum(List<Integer> list, int i, int j) {
		int thisSum = 0;
		for (int k = i; k <= j; k++) {
			thisSum += list.get(k);
		}
		return thisSum;
	}
}
