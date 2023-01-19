import java.util.LinkedList;
import java.util.List;

public class FindDisappearedNumbers {
    public static void main(String[] args) {

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        //原地交换  把当前数字交换到它在数组中该在的位置
        //如果重复 就不交换 然后循环 i+1 不等的数字 放在List中
        for (int i = 0; i < nums.length; i++) {
            //nums[nums[i] -1] 该数字应该出现的位置
            //一直交换 直到位置正确或者两个位置数字相等
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
