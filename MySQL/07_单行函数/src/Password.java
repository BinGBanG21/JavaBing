public class Password {
    public static void main(String[] args) {

    }
    /*
    加密与解密函数
        加密与解密函数主要用于对数据库中的数据进行加密和解密处理，以防止数据被他人窃取。这些函数在保证数据库安全时非常有用。|
        PASSWORD(str)                   返回字符串str的加密版本，41位长的字符串。加密结果不可逆，常用于用户的密码加密
        MD5(str)                        返回字符串str的md5加密后的值，也是一种加密方式。若参数为NULL，则会返回NULL
        SHA(str)                        从原明文密码str计算并返回加密后的密码字符串，当参数为NULL时，返回NULL。SHA加密算法比MD5更加安全。
        ENCODE(value,password_seed)     返回使用password_seed作为加密密码加密value
        DECODE(value,password_seed)     返回使用password_seed作为加密密码解密value



     */
}
