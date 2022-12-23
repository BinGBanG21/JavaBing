import java.util.ArrayList;

/*
    插值查找原理
        1.插值查找算法类似于二分查找，不同的是插值查找每次从自适应mid处开始查找。
        2.将折半查找中的求mid 索引的公式 , low 表示左边索引left, high表示右边索引right
          key 就是前面我们讲的  findVal
        3.int mid = low + (high - low) * (key - arr[low]) / (arr[high] - arr[low])  ;插值索引
          对应前面的代码公式：int mid = left + (right – left) * (findVal – arr[left]) / (arr[right] – arr[left])

    插值查找注意事项：
        1.对于数据量较大，关键字分布比较均匀的查找表来说，采用插值查找, 速度较快.
        2.关键字分布不均匀的情况下，该方法不一定比折半查找要好

* */
public class InsertSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
    }

    public static ArrayList<Integer> insert(int[] arr, int left, int right, int findVal) {
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) { //说明没有找到 left = mid + 1; right = mid -1 ;
            return new ArrayList<Integer>();
        }
        //插值查找和二分查找主要是mid值的计算方式不同 findVal也参与计算 所以也叫自适应算法
        int mid = left + (findVal - arr[left] / arr[right] - arr[left]) * (right - left);
        int midVal = arr[mid];
        //进行判断 改变left和right的值并递归
        if (arr[mid] > findVal) {
            //向左递归
            return insert(arr, left, mid - 1, findVal);
        } else if (arr[mid] < findVal) { //向右递归
            return insert(arr, mid + 1, right, findVal);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            //先往左边找
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                list.add(temp);
                temp--;
            }
            //在把中间值mid放入list中记录
            list.add(mid);
            temp = mid + 1;
            //然后向右扫描
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                list.add(temp);
                temp++;
            }
            return list;
        }
    }
}
