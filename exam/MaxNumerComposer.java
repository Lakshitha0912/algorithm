import java.util.TreeSet;

/*
 * 已知：[2,3,301,5]
 * 计算出可组成最大的数字： 533012
 * 解法：
 *   1)获得该数列的全排列，找到最大的
 *   2)回溯法（变形的选择排序）
 * */
public class MaxNumerComposer {

	private int[] a =  {2,3,301,5};
	private boolean[] vis = {false,false,false,false};
	private int n = 4;
	private Long maxNum=0L;

	public static void main(String[] args) {
		MaxNumerComposer composer = new MaxNumerComposer();
		composer.dfs(0,"");
		System.out.println(composer.maxNum);
	}

	private void dfs(int step,String s) {
		if (step == a.length) {
			long current = Long.parseLong(s);
			if( current > maxNum){
				maxNum = current;
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!vis[i]) {
				vis[i] = true;
				String t =s;
				s = s + a[i];
				dfs(step + 1,s);
				s= t;
				vis[i] = false;
			}
		}
	}
}

