import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * Problem Description
 You must write a program that simulates placing spherical balloons into a rectangular box.
 The simulation scenario is as follows. Imagine that you are given a rectangular box and a set of points inside the box. Each point represents a position where you might place a balloon. To place a balloon at a point, center it at the point and inflate the balloon until it touches a side of the box or a previously placed balloon. You may use the points in any order you like, and need not use every point. Your objective is to place balloons in the box in an order that maximizes the total volume occupied by the balloons.
 You are required to calculate the volume within the box that is not enclosed by the balloons.
 All integer will be in [-1000, 1000].
 Input
 The input consists of several test cases. The first line of each test case contains a single integer n that indicates the number of points in the set (n ≤ 6). The second line contains three integers that represent the (x, y, z) integer coordinates of a corner of the box, and the third line contains the (x, y, z) integer coordinates of the opposite corner of the box. The next n lines of the test case contain three integers each, representing the (x, y, z) coordinates of the points in the set. The box has non-zero length in each dimension and its sides are parallel to the coordinate axes.
 Output
 For each test case print one line which indicates the volume of the box not occupied by balloons. Round the volume to the nearest integer.
 Sample Input
 2
 0 0 0
 10 10 10
 3 3 3
 7 7 7

 Sample Output
 774
 */
public class Balloons {
	private int N;
	private Balloon lefttop;
	private Balloon rightbottom;
	private Balloon[] balloons; 
	List<List> seq = new ArrayList<List>();
	
	/**
	 * @param n
	 * @param lefttop
	 * @param rightbottom
	 */
	public Balloons(int n, Balloon lefttop, Balloon rightbottom) {
		super();
		N = n;
		this.lefttop = lefttop;
		this.rightbottom = rightbottom;
	}


	public double getMaxBallV() {
		double v = 0;
		sort(Arrays.asList(balloons), new ArrayList());
		for(List t : seq) {
			double av = 0;
			for(int i=0;i<t.size();i++) {
				double r = minr(i);
				balloons[i].setR(r);
				av = av + (4.0/3.0)*Math.PI*balloons[i].getR()*balloons[i].getR()*balloons[i].getR();
			}
			if(av > v) {
				v = av;
			}
		}
		return v;
	}

    private void sort(List datas, List target) {  
        if (target.size() == N) {  
            seq.add(target); 
            return;  
        }  
        for (int i = 0; i < datas.size(); i++) {  
            List newDatas = new ArrayList(datas);  
            List newTarget = new ArrayList(target);  
            newTarget.add(newDatas.get(i));  
            newDatas.remove(i);  
            sort(newDatas, newTarget);  
        }  
    }
	private double minr(int i) {
		int[] mi = new int[6];
		mi[0] = Math.abs(balloons[i].getX() -lefttop.getX()) ;
		mi[1] = Math.abs(balloons[i].getY() -lefttop.getY()) ;
		mi[2] = Math.abs(balloons[i].getZ() -lefttop.getZ()) ;
		mi[3] = Math.abs(balloons[i].getX() -rightbottom.getX()) ;
		mi[4] = Math.abs(balloons[i].getY() -rightbottom.getY()) ;
		mi[5] = Math.abs(balloons[i].getZ() -rightbottom.getZ()) ;
		double m = Double.MAX_VALUE;
		for(int j=0;j<6;j++ ) {
		  if(mi[j]<m) {
		         m=mi[j];
		  }
		 }
		for(int j=0;j<N;j++) {
			if(i!=j){
				m = Math.min(m, distant(i, j)-balloons[j].getR());
			}
		}
		return m;
	}


	private double distant(int i, int j) {
		return  Math.round(Math.sqrt((balloons[i].getX()-balloons[j].getX())*(balloons[i].getX()-balloons[j].getX()) + 
		(balloons[i].getY()-balloons[j].getY())*(balloons[i].getY()-balloons[j].getY())+
		(balloons[i].getZ()-balloons[j].getZ())*(balloons[i].getZ()-balloons[j].getZ())));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "2.0 0 0.10 10 10.3 3 3.7 7 7";
		Scanner scanner = new Scanner(str);
		scanner.useDelimiter("\\.");
		int n = scanner.nextInt();
		String[] s = scanner.next().split(" ");
		Balloon lefttop = new Balloon(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]),0);
		String[] s1 = scanner.next().split(" ");
		Balloon rightbottom = new Balloon(Integer.parseInt(s1[0]),Integer.parseInt(s1[1]),Integer.parseInt(s1[2]),0);
		Balloon[] ballons = new Balloon[n];
		for(int i = 0;i<n;i++){
			String[] s0 = scanner.next().split(" ");;
			ballons[i] = new Balloon(Integer.parseInt(s0[0]),Integer.parseInt(s0[1]),Integer.parseInt(s0[2]),0);
		}
		Balloons b = new Balloons(n,lefttop,rightbottom);
		b.balloons = ballons;
		
		double recv = (rightbottom.getX()-lefttop.getX())*(rightbottom.getY()-lefttop.getY())*(rightbottom.getZ()-lefttop.getZ());
		System.out.println(Math.round(recv - b.getMaxBallV()));
	}
}

class Balloon {
	private int x;
	private int y;
	private int z;
	private double r;
	/**
	 * @param x
	 * @param y
	 * @param z
	 */
	public Balloon(int x, int y, int z, double r) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.r = r;
	}
	/**
	 * @return the r
	 */
	public double getR() {
		return r;
	}
	/**
	 * @param r the r to set
	 */
	public void setR(double r) {
		this.r = r;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the z
	 */
	public int getZ() {
		return z;
	}
	/**
	 * @param z the z to set
	 */
	public void setZ(int z) {
		this.z = z;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	
}
