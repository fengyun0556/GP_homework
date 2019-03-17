package com.gupao.pattern.factory.abstractFactory;

import com.gupao.pattern.factory.ICourse;

public interface ICourseFactory {

    ICourse createCourse();

    INote createNote();

    IVideo createVideo();
}
