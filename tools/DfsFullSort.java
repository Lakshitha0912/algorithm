
public class DfsFullSort {
	private int[] a = {1,2,3};
	private boolean[] vis = {false,false,false};
	private int n = 3;
	
	public static void main(String[] args) {
		DfsFullSort sort = new DfsFullSort();
		sort.dfs(0,"");
	}

	private void dfs(int step,String s) {
		if (step == a.length) {
			System.out.println(s);
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
