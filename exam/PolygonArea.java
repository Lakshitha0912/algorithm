import java.util.Scanner;


public class PolygonArea {
	public static double getTriggleArea(Point p1,Point p2) {
		return (p1.getX() * p2.getY() - p2.getX() * p1.getY())/2.0;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size =  Integer.parseInt(scanner.nextLine());
		for(int k=0;k<size;k++){
			int count = Integer.parseInt(scanner.nextLine());
			Point[] ps = new Point[count+1];
			double s=0,x=0,y =0,temp =0;
			for(int j=0;j<count;j++){
				Point p = new Point();
				String[] tp = scanner.nextLine().split(" ");
				p.setX(Double.parseDouble(tp[0]));
				p.setY(Double.parseDouble(tp[1]));
				ps[j] = p;
			}
			ps[count] = ps[0];
		    for(int i=0;i<count;i++)
	        {
	            temp=getTriggleArea(ps[i],ps[i+1]);//各个三角形的有向面积 
	            s+=temp;
	            x+=temp*(ps[i].getX()+ps[i+1].getX())/3.0;
	            y+=temp*(ps[i].getY()+ps[i+1].getY())/3.0;
	        }
		    
		    if(Math.abs(s)<0.0000001) 
	            System.out.printf("0.000 0.000\n");
	        else 
	        	System.out.printf("%.3f %.3f\n",Math.abs(s),(x+y)/s);
			
		}
	}
}


class Point {
	private double x;
	private double y;
	
	public Point() {
		super();
	}
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
}