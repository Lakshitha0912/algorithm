import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * http://acm.nyist.net/JudgeOnline/problem.php?pid=6
 * 
 */
public class WaterSpray2 {


	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int size = Integer.parseInt(scanner.nextLine());
		for (int t = 0; t < size; t++) {
			String[] rs = scanner.nextLine().split(" ");
			int n = Integer.parseInt(rs[0]);
			int w = Integer.parseInt(rs[1]);
			int h = Integer.parseInt(rs[2]);
			ArrayList<Region> regions = new ArrayList<Region>();
			for (int i = 0; i < n; i++) {
				String[] cstr = scanner.nextLine().split(" ");
				int x = Integer.parseInt(cstr[0]);
				int r = Integer.parseInt(cstr[1]);
				if (r > h/2.0) {
					double dr = Math.sqrt(r * r - h * h / 4.0);
					Region re = new Region(x - dr, dr + x,w);
					regions.add(re);
				} 
			}
			
			Collections.sort(regions, new Comparator<Region>() {
				@Override
				public int compare(Region o1, Region o2) {
					return (o1.getStart() - o2.getStart()) > 0 ? 1 : 0;
				}
			});
			int num = 0;
			int k = 0;
			double start = 0;
			while(start < w && k<regions.size()){
				double max = 0;
				int index = 0;
				boolean tflag =false;
				for(int j=k;j<regions.size();j++){
					if(start >=regions.get(j).getStart() && max <regions.get(j).getEnd()){
						max = regions.get(j).getEnd();
						index = j;
						tflag = true;
					}
				}
				if(tflag) {
					start = regions.get(index).getEnd();
					num++;
				}
				k++;
			}
			if (start >= w) {
				System.out.println(num);
			} else {
				System.out.println(0);
			}
		}
	}
}

class Region {
	private double start;
	private double end;

	public Region() {
		super();
	}


	@Override
	public String toString() {
		return "Region [start=" + start + ", end=" + end + "]";
	}


	public Region(double start, double end, int w) {
		super();
		if(start<0){
			this.start = 0;
		}else{
			this.start = start;
		}
		if(end > w) {
			this.end = w;
		}else{
			this.end = end;
		}
	}



	public double getStart() {
		return start;
	}

	public void setStart(double start) {
		this.start = start;
	}

	public double getEnd() {
		return end;
	}

	public void setEnd(double end) {
		this.end = end;
	}

}