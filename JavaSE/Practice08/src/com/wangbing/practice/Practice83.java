package com.wangbing.practice;

public class Practice83 {
    public static void main(String[] args) {
        Professor professor = new Professor("ZhangSan", 38, "副教授", 28000, 1.3);
        professor.introduce();
    }
}

class Teachers {
    private String name;
    private int age;
    private String post;
    private double salary;
    private double level;

    public Teachers(String name, int age, String post, double salary, double level) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
        this.level = level;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Teachers{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                ", level=" + level +
                '}';
    }

    public void introduce() {
        String info = this.toString();
        System.out.println(info);
    }
}

class Professor extends Teachers {
    public Professor(String name, int age, String post, double salary, double level) {
        super(name, age, post, salary, level);
    }

    @Override
    public void introduce() {
        System.out.println("这是教授的信息");
        super.introduce();
    }
}

