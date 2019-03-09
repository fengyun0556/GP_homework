package com.gupao.pattern.factory.factoryMethod;

import com.gupao.pattern.factory.ICourse;
import com.gupao.pattern.factory.PhythonCourse;

public class PhythonCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new PhythonCourse();
    }
}
