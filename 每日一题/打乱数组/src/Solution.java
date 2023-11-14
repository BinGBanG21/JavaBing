import java.util.Random;

public class Solution {

    public static void main(String[] args) {

    }

    int[] nums;
    int[] shuffle;
    Random random;

    //构造器
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }


    //重置
    public int[] reset() {
        return nums;
    }

    //洗牌
    public int[] shuffle() {
        //随机取一个数字 与当前元素交换
        shuffle = nums.clone();
        for (int i = shuffle.length - 1; i >= 0; i--) {
            int j = random.nextInt(i + 1);
            swap(shuffle, i, j);
        }
        return shuffle;
    }

    public void swap(int[] shuffle, int i, int j) {
        int temp = shuffle[i];
        shuffle[i] = shuffle[j];
        shuffle[j] = temp;
    }
}

