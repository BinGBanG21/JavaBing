public class RemoveElement {
    public static void main(String[] args) {

    }

//    public int removeElement(int[] nums, int val) {
//        //fast找到非目标元素
//        //slow用来刷新数组
//        int slow = 0;
//        for (int fast = 0; fast < nums.length; fast++) {
//            if (nums[fast] != val) {
//                nums[slow] = nums[fast];
//                slow++;
//            }
//        }
//        return slow;
//    }
    //数组是一个连续的内存空间 不能删除元素 只能覆盖 一些语言的api 也只是帮你做了一个包装 本质上内存空间还是不变的
    //暴力解 两层for循环 找到 目标元素 然后一个个元素向后覆盖
    //优化 双指针 双指针其实就是把双重for循环变成1层for循环
    //两个指针都从头开始 其实双指针无非就是两个头 一头一尾 或者从头 挨着
    //fast指针找到我们需要的元素 并且利用slow给新数组赋值
    //其实就是覆盖 双指针给数组赋值 fast是目标元素 找到就通过slow赋值
//    public int removeElement(int[] nums, int val){
//        int slow = 0;
//        for(int fast = 0; fast < nums.length;fast++){
//            //找到新数组需要的元素
//            if(nums[fast] != val){
//                nums[slow] = nums[fast];
//                //对新数组赋值
//                slow++;
//            }
//        }
//        return slow;
//    }
public int removeElement3(int[] nums, int val) {
    //双指针 快指针找新数组的值 慢指针负责给数组赋值
    int slow = 0;
    for(int fast = 0; fast < nums.length; fast++ ){
        if(nums[fast] != val){
            nums[slow++] = nums[fast];
        }
    }
    return slow;
}
    public int removeElement(int[] nums, int val){
        //快慢指针 快指针找值 慢指针赋值
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast]:
            }
        }
        return slow;
    }
}
