/*
	某人有100，000元，每经过一次路口，需要交费，规则如下∶
		1）当现金>50000时，每次交5%
		2）当现金<=50000时，每次交1000 编程计算该人可以经过多少次路口，要求∶使用while+break方式完成

	判断一个整数是否是水仙花数，所谓水仙花数是指一个3位数，其各个位上数字立方
	和等于其本身。例如∶153=1*1*1+3*3+5*5*5
*/


public class Practice03 {
	public static void main (String[] args) {
		double money = 100000.00
		int count = 0
		while (money >= 1000 ) {
			if (money > 50000 ) {
				money -= money * 0.05
			}else{
				money -= 1000
			}
			count++
		}
	}

		//水仙花
		int n = 677
		int n1 = n / 100  // 百位
		int n2 = n % 100 / 10 // 十位
		int n3 = n % 10 // 个位
		boolean flag  = ( n == n1 * n1 * n1 + n2 * n2 * n2 + n3 * n3 * n3)
}