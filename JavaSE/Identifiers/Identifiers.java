/**
 * 标识符的命名规则（必须遵守）
	1.由26个英文字母大小写，0-9，或$组成
	2.数字不可以开头。int3ab=1；//错误
	3.不可以使用关键字和保留字，但能包含关键字和保留字
	4.Java中严格区分大小写，长度无限制。int totalNum=10；int n=90
	5.标识符不能包含空格。intab=90
	1) 包名：多单词组成时所有字母都小写：aaa.bbb.ccc //比如 com.hsp.crm 
	2) 类名、接口名：多单词组成时，所有单词的首字母大写：XxxYyyZzz [大驼峰] 比如： TankShotGame 
	3) 变量名、方法名：多单词组成时，第一个单词首字母小写，第二个单词开始每个单词首字母大写：xxxYyyZzz [小 驼峰， 简称 驼峰法] 比如： tankShotGame 
	4) 常量名：所有字母都大写。多单词时每个单词用下划线连接：XXX_YYY_ZZZ 比如 ：定义一个所得税率 TAX_RATE
 * /