package com.gupao.pattern.factory.simpleFactory;

import com.gupao.pattern.factory.ICourse;
import com.gupao.pattern.factory.JavaCourse;
import com.gupao.pattern.factory.PhythonCourse;
import org.junit.Test;

public class CourseSimpleFactoryTest {
    @Test
    public void test0(){
        CourseSimpleFactory courseSimpleFactory = new CourseSimpleFactory();
        ICourse course = courseSimpleFactory.createCourse(JavaCourse.class);
        course.record();
    }

    @Test
    public void test1(){
        CourseSimpleFactory courseSimpleFactory = new CourseSimpleFactory();
        ICourse course = courseSimpleFactory.createCourse(PhythonCourse.class);
        course.record();
    }
}
