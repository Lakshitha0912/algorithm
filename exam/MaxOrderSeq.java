public class MaxOrderSeq {
	public static void main(String[] args) {
		int[] h = { 206, 207, 155, 300, 139, 170, 138, 65 };
		int[] d = new int[8];  //��ʾ���±� �� ĩβ �������������е���Сֵ�� �� d[i] = max(d[i+1],d[i+2],d[i+3]...) �� i
		
		int c = 1;
		d[0] = h[0];
		int i,j;
		for(i = 1 ;i < d.length;i++){   //d[1],d[2] ... �������е�h
			for(j = c - 1;j>=0;j--){  //��x>y,һ����d[x]>d[y]
				if(h[i] <= d[j] )  //ժ����Щ ��d[n]��ɵ�d[x]��������Ȼ��󴮰����ң��ұ�ȻӦ����С��ԭ���Ӵ���С��
					break;
			}
			
			d[j+1] = h[i]; //��ʾ������d[j+1]Ϊ������У���СֵΪh[i]
			if(j==c-1) c++;
		}
		
		System.out.println(c);
	}
}
