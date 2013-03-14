import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RectangleSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = Integer.valueOf(scanner.nextLine());
		for(int t=0;t<size;t++){
			int count = Integer.valueOf(scanner.nextLine());
			TreeSet<CRectangle> recs = new TreeSet<CRectangle>();
			for(int i=0;i<count;i++){
				String[] rs = scanner.nextLine().split(" ");
				int tlength = Integer.valueOf(rs[1]);
				int twidth = Integer.valueOf(rs[2]);
				if(tlength<twidth){
					int temp = tlength;
					tlength = twidth;
					twidth = temp;
				}
				CRectangle r = new CRectangle(Integer.valueOf(rs[0]),tlength,twidth);
				recs.add(r);
			}
			
			for(CRectangle re : recs){
				System.out.println(re);
			}
		}
	}
}

class CRectangle implements Comparable<CRectangle>{
	private int idx;
	private int len;
	private int width;

	public CRectangle(int idx, int len, int width) {
		super();
		this.idx = idx;
		this.len = len;
		this.width = width;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public CRectangle() {
		super();
	}

	@Override
	public String toString() {
		return idx + " " + len + " " + width;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idx;
		result = prime * result + len;
		result = prime * result + width;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CRectangle other = (CRectangle) obj;
		if (idx != other.idx)
			return false;
		if (len != other.len)
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	@Override
	public int compareTo(CRectangle o2) {

		if(this.getIdx()<o2.getIdx()){
			return -1;
		}
		if(this.getIdx()>o2.getIdx()){
			return 1;
		}
		
		if(this.getIdx() == o2.getIdx() && this.getLen() < o2.getLen()){
			return -1;
		}
		
		if(this.getIdx() == o2.getIdx() && this.getLen() > o2.getLen()){
			return 1;
		}
		
		if(this.getIdx() == o2.getIdx() && this.getLen() == o2.getLen() && this.getWidth() <  o2.getWidth()){
			return -1;
		}
		if(this.getIdx() == o2.getIdx() && this.getLen() == o2.getLen() && this.getWidth() >  o2.getWidth()){
			return 1;
		}
		return 0;
	}

}