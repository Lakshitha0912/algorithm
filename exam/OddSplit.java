import java.util.ArrayList;
import java.util.Scanner;


public class OddSplit {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = Integer.parseInt(scanner.nextLine());
		for(int t=0;t<size;t++){
			int num = Integer.parseInt(scanner.nextLine());
			ArrayList<Integer> oddlist = new ArrayList<Integer>();
			ArrayList<Integer> evenlist = new ArrayList<Integer>();
			for(int i=1;i<=num;i++){
				if(i%2==0){
					evenlist.add(i);
				}else{
					oddlist.add(i);
				}
			}
			for(Integer k:oddlist){
				System.out.print(k+" ");
			}
			System.out.println();
			for(Integer k:evenlist){
				System.out.print(k+" ");
			}
			System.out.println();
		}
	}
}
