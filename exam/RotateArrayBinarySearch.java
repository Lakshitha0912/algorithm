/*
 * ����������ת����ж��ֲ���
 * 5,7,9,10,11, 1,3,4
 * ˼·��
 * 1)������ֳ�������[5,7,9],[11,1,3,4],mid=10
 * 2)һ��������һ������������ġ�
 *    * �ж��Ǹ�����������Ĺ�������������,left<mid<right,�ɴ˿���[11,1,3,4]�������
 * 3)������������ж��ֲ��ң�������ҵ�����λ�ã����û�ҵ���������2������������

 */

public class RotateArrayBinarySearch {

	public static int search(int a[], int n, int t) {
		int low=0,high = n-1;
		int mid;
		while(low<=high){
			mid = low + (high-low)/2;
			if(a[mid] == t){
				return mid;
			}
			
			if(a[low]<a[mid]){
				if(t>=a[low] && t<a[mid]){
					high = mid -1;
				}else{
					low =mid + 1;
				}
			}else{
				if(t<=a[high] && t >a[mid]){
					low = mid +1;
				}else{
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
		int index = search(a, a.length, 7);
		System.out.println("index=" + index);
	}

}
