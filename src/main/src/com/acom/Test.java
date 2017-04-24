package com.acom;

/**
 * Created by Jiay on 2016/8/30.
 */
public class Test {
    public static void main(String[] args) {
        Person lisi = new Person("李四", 20);
        Person zhangsan = new Person("张三", 20);
        swap(lisi, zhangsan);
        System.out.println(lisi.getName() + "-----1----" + lisi.getAge());
        System.out.println(zhangsan.getName() + "----2-----" + zhangsan.getAge());

        swapNew(lisi, zhangsan);

        System.out.println(lisi.getName() + "-----3----" + lisi.getAge());
        System.out.println(zhangsan.getName() + "----4-----" + zhangsan.getAge());

        swapNew3(lisi, zhangsan);

        System.out.println(lisi.getName() + "-----5----" + lisi.getAge());
        System.out.println(zhangsan.getName() + "----6-----" + zhangsan.getAge());

    }

    public static void swap(Person p1, Person p2) {
        Person temp = p1;
        p1 = p2;
        p2 = temp;
    }

    public static void swapNew(Person p1, Person p2) {
        p1.setName("lisi new");
        p2.setName("你猜猜 new");
    }

    public static void swapNew3(Person p1, Person p2) {
        Person temp = p1;
        Person temp_2 = p2;
        temp.setName("'我再次来了'");
        temp_2.setName("'王国维'");
    }
}

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}