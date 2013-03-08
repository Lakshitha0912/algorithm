
public class Permutation {
	
	public static void swap(int[] a, int i, int j) {
		if (i != j) {
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
	}

	public static void permute(int[] a,int start,int end){
		if(start>end){
			for(int i=0;i<=end;i++){
				System.out.print(a[i]);
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<=end;i++){
			swap(a,start,i);
			permute(a,start+1,end);
			swap(a,start,i);
		}
		
	}
	
	public static void main(String[] args) {
		int[] a= {1,2,3};
		permute(a,0,2);
	}

}
