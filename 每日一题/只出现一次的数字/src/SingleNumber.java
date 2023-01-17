public class SingleNumber {
    public static void main(String[] args) {

    }
    public int singleNumber(int[] nums) {
        //异或运算 相同为0 不同为1
        int ans = 0;
        for(int num : nums){
            //一个数和 0 做 XOR 运算等于本身
            //一个数和其本身做 XOR 运算等于 0
            ans ^= num;
        }
        return ans;
    }
}
