package com.gupao.pattern.factory.abstractFactory;

public class AbstractFactoryTest {

    public static void main(String[] args) {
        ICourseFactory courseFactory = new JavaCourseFactory();
        courseFactory.createCourse().record();
        courseFactory.createNote().doSomeThing();
        courseFactory.createVideo().doSomeThing();
    }
}
