package com.gupao.pattern.prototype.simple;

import java.util.ArrayList;
import java.util.List;

public class SimplePrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<String> hobbies = new ArrayList<>();
        SimplePrototype simplePrototype = new SimplePrototype();
        simplePrototype.setName("ZhangSan");
        simplePrototype.setAge(20);

        SimplePrototype simplePrototype1 = simplePrototype.clone();

        System.out.println(simplePrototype == simplePrototype1);
        System.out.println(simplePrototype.getHobbies() == simplePrototype1.getHobbies());
    }
}
