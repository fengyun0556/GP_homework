package com.gupao.pattern.factory.simpleFactory;

import com.gupao.pattern.factory.ICourse;
import com.gupao.pattern.factory.JavaCourse;
import com.gupao.pattern.factory.PhythonCourse;

public class CourseSimpleFactoryTest {
    public static void main(String[] args) {
        CourseSimpleFactory courseSimpleFactory = new CourseSimpleFactory();
        ICourse course = courseSimpleFactory.createCourse(JavaCourse.class);
        course.record();
    }

    public void test1(){
        CourseSimpleFactory courseSimpleFactory = new CourseSimpleFactory();
        ICourse course = courseSimpleFactory.createCourse(PhythonCourse.class);
        course.record();
    }
}
