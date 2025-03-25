package com.example.templateproject;

public class Person {

    private String name;
    private int age;
    private String address;

    //우클릭 > 생성 하면 자동 생성됨.

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}
