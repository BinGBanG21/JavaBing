public class Search {
    public static void main(String[] args) {

    }

    //    public int search(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (nums[mid] < target) {
//                left = mid + 1;
//            } else if (nums[mid] > target) {
//                right = mid - 1;
//            } else {
//                return mid;
//            }
//        }
//        return -1;
//    }
    public int search3(int[] nums, int target) {
        //避免多余运算 对target处理
        if(target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }
        //二分查找 左右指针循环
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            //中间值
            int mid = (left + right) / 2;
            if(target == nums[mid]){
                return mid;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
    //循环不变量 左闭右闭 left 和 right可以相等 左闭右开 left 和 right 不能相等 举例 [1 ,1] [ 1, 1)
    //左闭右闭写法
    public int search(int[] nums, int target) {
        //合法边界判断 避免target不合理却仍多次循环
        if( target < nums[0] || target > nums[nums.length -1]){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        //开始循环
        while (left <= right) { // left < right
            //每次重新获取中间值
            int middle = (left + right) / 2;
            //利用中间值判断 更新右区间的左边界
            if (nums[middle] < target) {
                left = middle + 1; // 不变 因为左区间是闭合
            } else if (nums[middle] > target) { //更新左区间的右边界
                right = middle - 1; //right = middle;
            } else {
                return middle;
            }
        }
        //循环结束没找到 return -1
        return -1;
    }

}
