package com.gupao.pattern.factory.abstractFactory;

import org.junit.Test;

public class AbstractFactoryTest {

    @Test
    public void test(){
        ICourseFactory courseFactory = new JavaCourseFactory();
        courseFactory.createCourse().record();
        courseFactory.createNote().doSomeThing();
        courseFactory.createVideo().doSomeThing();
    }
}
