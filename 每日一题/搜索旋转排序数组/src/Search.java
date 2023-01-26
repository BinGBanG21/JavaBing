public class Search {
    public static void main(String[] args) {

    }
    public int search(int[] nums, int target) {
        //边界处理
        if(nums.length == 1){
            return target == nums[0] ? 0 : -1;
        }
        int left = 0;
        int right = nums.length -1;

        while(left <= right ){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }
            //区分哪部分数组是有序的 用这部分数组的头尾值进行判断
            //这部分数组是有序的
            if( nums[0] <= nums[mid]){
                //target == nums[mid] 的值在上面处理过了
                if( nums[0]<= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid +1;
                }
            }else{
                if(nums[mid]< target && target <= nums[nums.length -1] ){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        //如果找到 在while中就会return mid
        return -1;
    }
}
