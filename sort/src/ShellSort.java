import java.util.Arrays;


//希尔排序 O(n的1.x次方)
public class ShellSort {
     
    //按照增量进行直接插入
    public static void shellInsert(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while(j>=gap && temp > (array[j - gap])){
                array[j] = array[j - gap];
            	j -= gap;
            }
            array[j] = temp;
        }
    }
     
     
    public static void shellSort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2)//取增量
            shellInsert(array, gap);
    }
	private static String print(int[] a) {
		return Arrays.toString(a);
	}
	
	public static void main(String[] args) {
		int[] a = {7,5,9,4,3,1,8,2,10};
		System.out.println("排序前:"+ print(a));
		shellSort(a);
		System.out.println("排序后:"+ print(a));
	}

}