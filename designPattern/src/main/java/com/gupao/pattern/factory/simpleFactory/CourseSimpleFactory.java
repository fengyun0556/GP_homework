package com.gupao.pattern.factory.simpleFactory;

import com.gupao.pattern.factory.ICourse;

public class CourseSimpleFactory {
    public ICourse createCourse(Class clazz){
        try {
            return (ICourse) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
