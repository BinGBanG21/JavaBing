import java.util.*;

public class RandomizedSet {

    //O1时间查询(插入 删除) map 存 值->索引
    Map<Integer, Integer> map;
    //插入 List
    List<Integer> list;
    int size;
    //随机返回 Random
    Random random;

    public RandomizedSet() {
        //初始化
        map = new HashMap<>();
        list = new ArrayList<>();
        size = 0;
        random = new Random();
    }

    public boolean insert(int val) {
        //如果存在 那么返回false(去重)
        if (map.containsKey(val)) {
            return false;
        }
        //不存在 插入
        map.put(val, size);
        size++;
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        //不存在
        if (!map.containsKey(val)) {
            return false;
        }
        //存在
        size--;
        //拿到数组中的最后一个元素
        int lastNum = list.get(size);
        //拿到当前元素对应的索引
        int index = map.get(val);
        //为了随机性 用最后一个元素覆盖val 并且删除最后一个元素
        list.set(index, lastNum);
        list.remove(size);
        //更新最后一个元素在map中的索引
        map.put(lastNum, index);
        //删除map中的该元素
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(size));
    }
}
