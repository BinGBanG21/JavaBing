/*
递归的执行机制
	1.执行一个方法时，就创建一个新的受保护的独立空间（栈空间）
	2.方法的局部变量是独立的，不会相互影响，比如n变量
	3.当一个方法执行完毕，或者遇到return，就会返回，遵守谁调用，就用类型的数据.
	4.如果方法中使用的是引用类型变量（比如数组，对象），就会共享该引递归必须向退出递归的条件逼近，否则就是无限递归，出现StackOverflowError，死龟了∶）
	5.当一个方法执行完毕，或者遇到return，就会返回，遵守谁调用，就将结果返回给谁，同时当方法执行完毕或者返回时，该方法也就执行完毕


*/



public class Recursion {
	public static void main( String[] args){

	}
}
class Exercise {
	int sum = 0
	public int fibonacci(n){
		if (n > 1) {
			if (n = 2 || n = 1) {
				return  1
			} else {
				return fibonacci(n-1) + fibonacci(n-2)
			}
		} else {
			System.out.println("输入有误")
			return -1
		}
	}
}

//猴子吃桃子问题:有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个!以后每天猴子都吃其中的一半
//然后再多吃一个。当到第10天时，想再吃时(即还没吃)，发现只有1个桃子了。问题:最初共多少个桃子?
//需要注意的是：要先+1 在乘以2  因为在开始分一半的时候 是先分完一半然后在吃的一个 我们逆推
//就要先+1再乘以2  不然就少一个
class Peach {
	public int Peach (int days) {
		if (days = 10) {
			return 1
		} else if (days >= 1 && days <= 9) {
			return (Peach(days-1) + 1) * 2 		
		}else {
			return "输入天数有误"
		}
	}
}

