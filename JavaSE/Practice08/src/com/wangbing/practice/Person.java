package com.wangbing.practice;

public class Person {
    public static void main(String[] args) {
        Person01[] persons = new Person01[3];
        persons[0] = new Person01("WangBing", 22, "java开发");
        persons[1] = new Person01("ZhangSan", 28, "测试");
        persons[2] = new Person01("LiSi", 25, "前端开发");


        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = 0; j < persons.length - i - 1; j++) {
                Person01 temp = null;
                if (persons[j].getAge() > persons[j + 1].getAge()) {
                    temp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = temp;
                }
            }
        }


        for (int k = 0; k < persons.length; k++) {
            System.out.println(persons[k]);
        }
    }
}

class Person01 {
    private String name;
    private int age;
    private String job;

    public Person01(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    @Override
    public String toString() {
        return "Person01{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}


