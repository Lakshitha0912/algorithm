import java.util.Arrays;


/**
 * 插入排序
 * 将元素插入至已排序序列
 * @author lihan01
 *
 */
public class InsertSort {
	/**
	 * @param a
	 */
	public static int[] sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int cur = a[i];
			int j = i;
			while(j>0 && a[j-1] > cur) {
				a[j] = a[j-1];
				j--;
			}
			a[j] = cur;
		}
		return a;
	}
	

	public static void main(String[] args) {
		int[] a = {7,5,9,4,3,1,8};
		System.out.println("排序前:"+ print(a));
		int[] b = sort(a);
		System.out.println("排序后:"+ print(b));
	}

	private static String print(int[] a) {
		return Arrays.toString(a);
	}
}
