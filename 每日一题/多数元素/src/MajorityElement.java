public class MajorityElement {
    public static void main(String[] args) {

    }
    public int majorityElement(int[] nums) {
        //思路：投票消耗
        //假定当前数字为多数元素 和下一个数字比较
        //一样就++ 不一样就-- 为0就选择比较元素的下一个元素为多数元素
        int cur = nums[0];
        int count = 1;
        for(int i = 1; i< nums.length;i++){
            if(cur == nums[i]){
                count++;
            }else if(cur != nums[i]){
                count--;
                if(count == 0){
                    //count == 0 说明已经被消耗完 没有备选人
                    //不会越界 因为如果最后一个元素count==0 就说明没有多数元素
                    //然而题目中说是一定存在多数元素
                    cur = nums[i];
                    //重置count
                    count = 1;
                }
            }

        }
        return cur;
    }
}
