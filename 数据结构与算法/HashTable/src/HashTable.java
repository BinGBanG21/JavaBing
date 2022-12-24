/*
    哈希表的基本介绍
        散列表（Hash table，也叫哈希表），是根据关键码值(Key value)而直接进行访问的数据结构。
        也就是说，它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。
        这个映射函数叫做散列函数，存放记录的数组叫做散列表 因为把数据分散开 然后通过id定位 这样效率就高
* */

public class HashTable {
    public static void main(String[] args) {

    }
}
//有一个公司,当有新的员工来报道时,要求将该员工的信息加入(id,性别,年龄,名字,住址..)
//当输入该员工的id时,要求查找到该员工的所有信息.
//3个类 (1)员工类Emp并形成链表 (2)一个数组 里面放着每个链表的头节点  (3)管理数组和调用方法的table类


class Emp {
    public int id;
    public String name;
    public Emp next;    //默认为null


    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


//需要注意的是 这里面的第一个节点就是emp 不是null
class EmpLinkedList {
    //初始化头节点
    private Emp head;

    //添加员工 因为公司的员工id是子增长的
    //所以每次添加 直接加到最后即可
    public void add(Emp emp) {
        if (head.next == null) {
            head.next = emp;
            return;
        }
        //辅助指针
        Emp temp = head;
        //先找到节点的位置 然后加入
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        //退出循环 代表找到了最后
        temp.next = emp;
    }

    //循环打印链表信息
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空，请先添加数据~");
            return;
        }
        //循环链表 打印
        Emp temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //根据id查找员工
    public Emp findById(int id) {
        if (head.next == null) {
            System.out.println("链表为空没有员工");
        }
        Emp temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println("该员工不存在");
                break;
            }
            if (temp.id == id) {
                break;
            }
            temp = temp.next;
        }
        //出了循环后就找到了员工 即temp
        return temp;

    }

}

//创建hashTable
class HashTab {
    private EmpLinkedList[] arr;
    private int size;

    public HashTab(int size) {
        this.size = size;
        //初始化链表
        for (int i = 0; i < size; i++) {
            arr[i] = new EmpLinkedList();
        }
    }

    //hash函数 使用最简单的取模模拟
    public int hash(Emp emp) {
        return emp.id % size;
    }

    //添加员工
    public void add(Emp emp) {
        //拿到id  加入到对应的链表中
        int no = hash(emp);
        arr[no].add(emp);
    }

    //遍历所有的链表
    public void allList() {
        for (EmpLinkedList list : arr) {
            list.list();
        }
    }

    //根据输入的id 查找员工
    public Emp findById(Emp emp) {
        //得到链表的id
        int no = hash(emp);
        //找到链表添加
        Emp result = arr[no].findById(emp.id);
        if (result == null) {
            System.out.println("员工不存在");
            return null;
        } else {
            return result;
        }
    }
}