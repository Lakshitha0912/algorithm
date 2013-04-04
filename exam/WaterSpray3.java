import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * http://acm.nyist.net/JudgeOnline/problem.php?pid=6
 * 
 */
public class WaterSpray3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int size = Integer.parseInt(scanner.nextLine());
		for (int t = 0; t < size; t++) {
			String[] rs = scanner.nextLine().split(" ");
			int n = Integer.parseInt(rs[0]);
			int w = Integer.parseInt(rs[1]);
			int h = Integer.parseInt(rs[2]);
			ArrayList<Line> lines = new ArrayList<Line>();
			for (int i = 0; i < n; i++) {
				String[] cstr = scanner.nextLine().split(" ");
				int x = Integer.parseInt(cstr[0]);
				int r = Integer.parseInt(cstr[1]);
				if (r > h / 2.0) {
					double dr = Math.sqrt(r * r - h * h / 4.0);
					Line re = new Line(x - dr, dr + x, w);
					lines.add(re);
				}
			}

			int num = 0;
			double start = 0 ;
			double k =0;
			while(start < w && k <lines.size()) {
				double max = start;
				int selectedIndex = 0;
				boolean flag = false;
				for(int j=0;j<lines.size();j++){
					if(start >= lines.get(j).start && lines.get(j).end > max) {
						max =  lines.get(j).end;
						selectedIndex = j;
						flag = true;
					}
				}
				if(flag){
					start = lines.get(selectedIndex).end;
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

class Line {
	public double start;
	public double end;

	public Line() {
		super();
	}

	@Override
	public String toString() {
		return "Line [start=" + start + ", end=" + end + "]";
	}

	public Line(double start, double end, int w) {
		super();
		if (start < 0) {
			this.start = 0;
		} else {
			this.start = start;
		}
		if (end > w) {
			this.end = w;
		} else {
			this.end = end;
		}
	}

}