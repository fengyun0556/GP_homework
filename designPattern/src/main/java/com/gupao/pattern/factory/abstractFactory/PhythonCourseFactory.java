package com.gupao.pattern.factory.abstractFactory;

import com.gupao.pattern.factory.ICourse;
import com.gupao.pattern.factory.PhythonCourse;

public class PhythonCourseFactory implements ICourseFactory {
    @Override
    public ICourse createCourse() {
        return new PhythonCourse();
    }

    @Override
    public INote createNote() {
        return new PhythonNote();
    }

    @Override
    public IVideo createVideo() {
        return new PhythonVideo();
    }
}
