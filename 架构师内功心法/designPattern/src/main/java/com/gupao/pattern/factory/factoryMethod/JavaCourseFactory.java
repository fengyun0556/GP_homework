package com.gupao.pattern.factory.factoryMethod;

import com.gupao.pattern.factory.ICourse;
import com.gupao.pattern.factory.JavaCourse;

public class JavaCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
