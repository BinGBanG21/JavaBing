package com.wangbing.map;/*
 * @author WangBing
 * @version 1.0
 **/


import java.util.*;

@SuppressWarnings({"all"})
public class MapMethod {
    public static void main(String[] args) {
        // map 接口常用方法
        Map map = new HashMap();
        map.put("邓超", new Book("", 100));//OK
        map.put("邓超", "孙俪");//替换
        map.put("王宝强", "马蓉");//OK
        map.put("宋喆", "马蓉");//OK
        map.put("刘令博", null);//OK
        map.put(null, "刘亦菲");//OK
        map.put("鹿晗", "关晓彤");//OK
        map.put("ow", "守望先锋");
        System.out.println("map=" + map);
        // remove:根据键删除映射关系
        map.remove(null);
        System.out.println("map=" + map);
        // get：根据键获取值
        Object val = map.get("鹿晗");
        System.out.println("val=" + val);
        // size:获取元素个数
        System.out.println("k-v=" + map.size());
        // isEmpty:判断个数是否为 0
        System.out.println(map.isEmpty());//F
        // clear:清除 k-v
        //map.clear();
        System.out.println("map=" + map);
        // containsKey:查找键是否存在
        System.out.println("结果=" + map.containsKey("ow"));//T

        //第一组: 先取出 所有的 Key , 通过 Key 取出对应的 Value
        Set keyset = map.keySet();
        //(1) 增强 for
        System.out.println("-----第一种方式-------");
        for (Object key : keyset) {
            System.out.println(key + "-" + map.get(key));
        }
        //(2) 迭代器
        System.out.println("----第二种方式--------");
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println(key + "-" + map.get(key));
        }
        //第二组: 把所有的 values 取出
        Collection values = map.values();
        //这里可以使用所有的 Collections 使用的遍历方法
        //(1) 增强 for
        System.out.println("---取出所有的 value 增强 for----");
        for (Object value : values) {
            System.out.println(value);
        }
        //(2) 迭代器
        System.out.println("---取出所有的 value 迭代器----");
        Iterator iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            Object value = iterator2.next();
            System.out.println(value);
        }
        //第三组: 通过 EntrySet 来获取 k-v
        Set entrySet = map.entrySet();// EntrySet<Map.Entry<K,V>>
        //(1) 增强 for
        System.out.println("----使用 EntrySet 的 for 增强(第 3 种)----");
        for (Object entry : entrySet) {
            //将 entry 转成 Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
        //(2) 迭代器
        System.out.println("----使用 EntrySet 的 迭代器(第 4 种)----");
        Iterator iterator3 = entrySet.iterator();
        while (iterator3.hasNext()) {
            Object entry = iterator3.next();
            //System.out.println(next.getClass());//HashMap$Node -实现-> Map.Entry (getKey,getValue)
            //向下转型 Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }

    }
}

class Book {
    private String name;
    private int num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Book(String name, int num) {
        this.name = name;
        this.num = num;
    }
}
