import java.util.Scanner;

public class Skiing {
	private static int row;
	private static int col;
	private static int[][] a =new int[100][100];
	private static int[][] f =new int[100][100];
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = Integer.parseInt(scanner.nextLine());
		for(int t = 0;t<size;t++) {
			try{
			String[] row_col = scanner.nextLine().split(" ");
			row = Integer.parseInt(row_col[0]);
			col = Integer.parseInt(row_col[1]);
			for(int i=0;i<row;i++){
				String[] rowstrs = scanner.nextLine().split(" ");
				for(int j=0;j<col;j++) {
					a[i][j] = Integer.parseInt(rowstrs[j]);
					f[i][j] = -1;
				}
			}
		
			int maxHeight=0;
			for(int ii=0;ii<row;ii++){
				for(int jj=0;jj<col;jj++){
					f[ii][jj] = dfs(ii,jj,0xffffff);
					if(f[ii][jj]>maxHeight){
						maxHeight = f[ii][jj];
					}
				}
			}
			System.out.println(maxHeight);
			}catch(Exception e){}
		}
	}

	private static int max(int dfs, int dfs2, int dfs3, int dfs4) {
		int maxI = dfs;
		if(maxI<dfs2) {
			maxI = dfs2;
		}
		if(maxI<dfs3){
			maxI = dfs3;
		}
		if(maxI<dfs4){
			maxI = dfs4;
		}
		return maxI;
	}

	private static int dfs(int r, int c, int h) {
		if(r <0 || c<0 || r>=row || c>=col|| h <= a[r][c]){
			return 0;
		}
		if(f[r][c] >= 0){
			return f[r][c];
		}	
		f[r][c] =  max(dfs(r-1,c, a[r][c]),dfs(r+1,c, a[r][c]),dfs(r,c-1, a[r][c]),dfs(r,c+1, a[r][c]))+1;
		return f[r][c] ;
	}
}
