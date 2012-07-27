import java.util.Arrays;


/**
 * 不稳定排序，需要o(n)临时空间
 * O(nlogn)
 * @author lihan01
 *
 */
public class MergeSort {
	private static String print(int[] a) {
		return Arrays.toString(a);
	}
	
	public static void main(String[] args) {
		int[] a = {7,5,9,4,6,10,3,1};
		System.out.println("排序前:"+ print(a));
		mergeSort(a,0,a.length-1);
		System.out.println("排序后:"+ print(a));
	}

	private static void mergeSort(int[] a, int start, int end) {
		if(start < end){
			int middle = (start + end)/2;
			mergeSort(a,start,middle);
			mergeSort(a,middle+1,end);
			merge(a,start,middle,end);
		}
		
	}

	private static void merge(int[] a, int start, int middle, int end) {
	    int[] temp=new int[a.length];
		int p=start;
		int q=middle+1;
		int i = start;
		while(q<=end && p<=middle) {
			if(a[p]>a[q]){
				temp[i++]=a[q++];
			}else {
				temp[i++] = a[p++];
			}
		}
		while(p<=middle) {
			temp[i++] = a[p++];
		}
		while(q<=end){
			temp[i++] = a[q++];
		}
		for(int j=start;j<i;j++) {
			a[j] = temp[j];
		}
	}

}
