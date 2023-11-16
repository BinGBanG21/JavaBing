public class CanWinNim {
    public static void main(String[] args) {

    }

    public boolean canWinNim(int n) {
        //因为先手 石头数如果为4的倍数 那么对方的回合一定会拿走剩余的全部
        return n % 4 != 0;
    }
}
