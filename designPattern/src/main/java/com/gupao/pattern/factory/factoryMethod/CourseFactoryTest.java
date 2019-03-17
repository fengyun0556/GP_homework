package com.gupao.pattern.factory.factoryMethod;

import com.gupao.pattern.factory.ICourse;

public class CourseFactoryTest {
    public static void main(String[] args) {
        ICourseFactory courseFactory = new JavaCourseFactory();
        ICourse course = courseFactory.create();
        course.record();
    }
}
