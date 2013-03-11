public class MaxSeq {
	/**
	 * 计算最大乘积连续自序列
	 * 
	 * @param data
	 * @return 元素1 乘积值 元素2 自序列开始索引 元素3 结束索引
	 */
	public static String exec(double[] data) {
		int i = 0, start = 0, current = 0, end = 0;
		double max = 0.0, multi = 1.0;
		while (i < data.length) {
			multi *= data[i];
			if (multi > max) {
				end = i;
				start = current;
				max = multi;
			} else if (multi <= 0) {
				multi = 1;
				current = i + 1;
			}

			i++;
		}

		double res[] = { max, start, end };
		return res[0]+","+res[1]+","+ res[2];
	}
	
	
	public static void main(String[] args) {
		double[] a = { -2.5,-4,0,-3,-0.5,-8,-1};
		
		System.out.println(exec(a));
	}
}
