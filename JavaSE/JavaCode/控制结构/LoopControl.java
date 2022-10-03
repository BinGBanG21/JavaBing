/*
	程序流程控制
		在程序中，程序运行的流程控制决定程序是如何执行的，是我们必须掌握的
		主要有三大流程控制语句。 
		1) 顺序控制
			程序从上到下逐行地执行，中间没有任何判断和跳转
			java中定义变量时采用合法的前向引用原则
		2) 分支控制
			让程序有选择的的执行,分支控制有三种 
			1) 单分支 if 
			2) 双分支 if-else 
			3) 多分支 if-else if -....-else
			switch case分支 
			switch（表达式）中表达式的返回值必须是∶（byte，short，int，char，enum【枚举】，String
			1.switch关键字，表示swtich分支
			2.表达式对应一个值
			3.case常量1∶当表达式的值等于常量1，就执行语句块1
			4.break∶表示退出swtich
			5.如果和case常量1匹配，就执行语句块1，如果没有匹配，就继续匹配case常量2
			6.如果一个都没有匹配上，执行default
			注意：
				1.表达式数据类型，应和case后的常量类型一致，或者是可以自动转成可以相互比较的
				2.switch（表达式）中表达式的返回值必须是∶（byte，short，int，char，enum【枚举】，String）
				3.case子句中的值必须是常量，而不能是变量
				4.default子句是可选的，当没有匹配的case时，执行default
				5.eak语句用来在执行完一个case分支后使程序跳出switch语句块；如果没有写break，程序会顺序执行到switch结尾，除非遇到break（穿透现象 多个case执行同一逻辑  或者一个case执行多个逻辑）
			switch 和 if 的比较
			1) 如果判断的具体数值不多，而且符合 byte、 short 、int、 char, enum[枚举], String 这 6 种类型。虽然两个语句都可 以使用，建议使用 swtich 语句
			2) 其他情况：对区间判断，对结果为 boolean 类型判断，使用 if，if 的使用范围更广
		3) 循环控制











*/