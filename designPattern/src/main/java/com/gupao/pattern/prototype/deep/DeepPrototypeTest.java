package com.gupao.pattern.prototype.deep;

import java.util.ArrayList;
import java.util.List;

public class DeepPrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<String> hobbies = new ArrayList<>();
        DeepPrototype deepPrototype = new DeepPrototype();
        deepPrototype.setName("ZhangSan");
        deepPrototype.setAge(20);
        deepPrototype.setHobbies(hobbies);

        DeepPrototype deepPrototype1 = deepPrototype.clone();
        System.out.println(deepPrototype == deepPrototype1);
        System.out.println(deepPrototype.getHobbies() == deepPrototype1.getHobbies());
    }
}
