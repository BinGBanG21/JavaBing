package com.wangbing.practice;

import java.util.Objects;

public class Practice810 {
    public static void main(String[] args) {

    }
}
class Doctor {
    private String name;
    private int age;
    private String job;
    private String gender;
    private double sal;

    public Doctor(String name, int age, String job, String gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

    //重写父类的equals方法

    @Override
    public boolean equals(Object o) {
        //如果两个内存地址相同 说明是在判断同一个对象 return true
        if (this == o) return true;
        //如果o不存在 或者不是Doctor的实例 或者o和this不在同一个包下 return false
        if ( !(o instanceof Doctor) || getClass() != o.getClass()) return false;
        //如满足如上条件 就进行比较 因为访问属性走的是编译类型 所以把o向下转型为doctor 然后逐一属性进行比较
        Doctor doctor = (Doctor) o;
        return age == doctor.age &&
                Double.compare(doctor.sal, sal) == 0 &&
                Objects.equals(name, doctor.name) &&
                Objects.equals(job, doctor.job) &&
                Objects.equals(gender, doctor.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, job, gender, sal);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
}
