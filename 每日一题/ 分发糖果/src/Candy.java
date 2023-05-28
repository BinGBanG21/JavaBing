

public class Candy {
    public static void main(String[] args) {

    }

    public int candy(int[] ratings) {
        //思路:从左往右比较 先确定右边的关系 然后从右往左比较 确定左边的关系
        int len = ratings.length;
        int[] candyCount = new int[len];
        candyCount[0] = 1;
        for (int i = 1; i < len; i++) {
            candyCount[i] = ratings[i] > ratings[i - 1] ? candyCount[i - 1] + 1 : 1;
        }
        for (int j = len - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j + 1]) {
                candyCount[j] = Math.max(candyCount[j], candyCount[j + 1] + 1);
            }
        }
        int result = 0;
        for (int i : candyCount) {
            result += i;
        }
        return result;
    }
}
