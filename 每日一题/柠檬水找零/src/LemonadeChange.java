public class LemonadeChange {
    public static void main(String[] args) {

    }

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                five--;
                ten++;
            } else if (bill == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
            //每次判断完都要看一下是否透支 如果后面的20多是能透支的
            if (ten < 0 || five < 0) {
                return false;
            }
        }

        return true;
    }
}
