public class MaxOrderSeq {
	public static void main(String[] args) {
		int[] h = { 206, 207, 155, 300, 139, 170, 138, 65 };
		int[] d = new int[8];  //表示从下标 到 末尾 的最大递增子序列的最小值。 有 d[i] = max(d[i+1],d[i+2],d[i+3]...) 但 i
		
		int c = 1;
		d[0] = h[0];
		int i,j;
		for(i = 1 ;i < d.length;i++){   //d[1],d[2] ... 遍历所有的h
			for(j = c - 1;j>=0;j--){  //若x>y,一定有d[x]>d[y]
				if(h[i] <= d[j] )  //摘出哪些 非d[n]组成的d[x]，表明既然最大串包括我，我必然应该是小于原来子串最小的
					break;
			}
			
			d[j+1] = h[i]; //表示采用了d[j+1]为最大序列，最小值为h[i]
			if(j==c-1) c++;
		}
		
		System.out.println(c);
	}
}
