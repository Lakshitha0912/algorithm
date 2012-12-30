/*
 * 有序数组旋转后进行二分查找
 * 5,7,9,10,11, 1,3,4
 * 思路：
 * 1)将数组分成两部分[5,7,9],[11,1,3,4],mid=10
 * 2)一定至少有一个数组是有序的。
 *    * 判断那个数组是有序的规则，如果是有序的,left<mid<right,由此看出[11,1,3,4]是无序的
 * 3)对有序数组进行二分查找，如果查找到返回位置，如果没找到，对数组2进行上述处理

 */

public class RotateArrayBinarySearch {

	public static int search(int a[], int n, int t) {
		int low = 0, high = n - 1;
		while(low<=high) {
			int mid = low + (high-low)/2;
			if(a[mid] == t){
				return mid;
			}
			if(a[low]<=a[mid]) {
				if(t<a[mid] && t>a[low]) {  //t是不是存在于顺序数组
					high = mid -1;
				}else{
					low = mid + 1;
				}
			} else {
				if(t>a[mid] && t < a[high]) {
					low = mid + 1;
				} else {
					high = mid -1;
				}
			}
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 5, 7, 9, 10, 11, 1, 3, 4 };
		int index = search(a, a.length, 1);
		System.out.println("index=" + index);
	}

}
