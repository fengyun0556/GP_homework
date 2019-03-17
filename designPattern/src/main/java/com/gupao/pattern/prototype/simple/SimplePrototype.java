package com.gupao.pattern.prototype.simple;

import java.util.List;

public class SimplePrototype implements Cloneable {

    private String name;
    private int age;
    private List<String> hobbies;

    @Override
    public SimplePrototype clone() throws CloneNotSupportedException {
        SimplePrototype simplePrototype = new SimplePrototype();
        simplePrototype.setAge(this.age);
        simplePrototype.setHobbies(this.hobbies);
        simplePrototype.setName(this.name);
        return simplePrototype;
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

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
