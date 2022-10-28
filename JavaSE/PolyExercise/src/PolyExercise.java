/*
 *
 * */

public class PolyExercise {
    public static void main(String[] args) {

        double d = 13.4;//ok
        long I = (long) d; //ok
        System.out.println(I);//13
        int in = 5;//ok
        //boolean b=(boolean) in；//不对， boolean -> int
        Object obj = "Hello";//可以，向上转型
        String objStr = (String) obj;//可以，向下转型
        System.out.println(objStr);//hello
        Object objPri = new Integer(5);//可以，向上转型
        //错误ClassCastExcetpion，指向Integer的父类引用，转成String
        String str = (String) objPri;
        Integer str1 = (Integer) objPri; //可以，向下转型A


    }
}
