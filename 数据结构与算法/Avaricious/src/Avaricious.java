/*
    贪心算法
        1.贪婪算法(贪心算法)是指在对问题进行求解时，在每一步选择中都采取最好或者最优(即最有利)的选择，从而希望能够导致结果是最好或者最优的算法
        2.贪婪算法所得到的结果不一定是最优的结果(有时候会是最优解)，但是都是相对近似(接近)最优解的结果
    贪心算法最佳应用-集合覆盖
        1.假设存在如下表的需要付费的广播台，以及广播台信号可以覆盖的地区。 如何选择最少的广播台，让所有的地区都可以接收到信号
            广播台	    覆盖地区
            K1	        "北京", "上海", "天津"
            K2	        "广州", "北京", "深圳"
            K3	        "成都", "上海", "杭州"
            K4	        "上海", "天津"
            K5	        "杭州", "大连"
        2.思路分析:
            如何找出覆盖所有地区的广播台的集合呢，使用穷举法实现,列出每个可能的广播台的集合，这被称为幂集。
            假设总的有n个广播台，则广播台的组合总共有2ⁿ -1 个,假设每秒可以计算10个子集
            广播台数量n	子集总数2ⁿ	    需要的时间
            5	        32	3.2秒
            10	        1024	        102.4秒
            32	        4294967296	    13.6年
            100	        1.26*100³º 	    4x10²³年
        3.使用贪婪算法，效率高:
          目前并没有算法可以快速计算得到准备的值， 使用贪婪算法，则可以得到非常接近的解，并且效率高。选择策略上，因为需要覆盖全部地区的最小集合:
              1.遍历所有的广播电台, 找到一个覆盖了最多未覆盖的地区的电台(此电台可能包含一些已覆盖的地区，但没有关系）
              2.将这个电台加入到一个集合中(比如ArrayList), 想办法把该电台覆盖的地区在下次比较时去掉。
              3.重复第1步直到覆盖了全部的地区
    贪心算法注意事项和细节
        1.贪婪算法所得到的结果不一定是最优的结果(有时候会是最优解)，但是都是相对近似(接近)最优解的结果
        2.比如上题的算法选出的是K1, K2, K3, K5，符合覆盖了全部的地区
        3.但是我们发现 K2, K3,K4,K5 也可以覆盖全部地区，如果K2 的使用成本低于K1,那么我们上题的 K1, K2, K3, K5 虽然是满足条件，但是并不是最优的.


* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Avaricious {
    public static void main(String[] args) {
        //创建电台 放入Map
        HashMap<String, HashSet<String>> broadsCasts = new HashMap<>();

        HashSet<String> set1 = new HashSet<>();
        set1.add("北京");
        set1.add("上海");
        set1.add("天津");

        HashSet<String> set2 = new HashSet<>();
        set2.add("广州");
        set2.add("北京");
        set2.add("深圳");

        HashSet<String> set3 = new HashSet<>();
        set3.add("成都");
        set3.add("上海");
        set3.add("杭州");

        HashSet<String> set4 = new HashSet<>();
        set4.add("上海");
        set4.add("天津");

        HashSet<String> set5 = new HashSet<>();
        set5.add("杭州");
        set5.add("大连");

        broadsCasts.put("k1",set1);
        broadsCasts.put("k2",set2);
        broadsCasts.put("k3",set3);
        broadsCasts.put("k4",set4);
        broadsCasts.put("k5",set5);

        //所有的地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //创建arrayList 存放已选择的电台的集合
        ArrayList<String> selects = new ArrayList<>();

        //定义一个临时的集合 方便用找到电台覆盖地区和全覆盖地区的交集
        HashSet<String> tempSet = new HashSet<>();

        //从map中拿到每一个电台集合 然后选择覆盖最多的那个
        while (selects.size()>0) {
            for (String key : broadsCasts.keySet()) {
                tempSet.addAll(broadsCasts.get(key));
                //然后与全部集合进行对比 拿到交集
                tempSet.retainAll(allAreas);
            }
        }

    }
}
