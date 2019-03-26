package com.gupao.pattern.decoratorAndObserver.homework.guvaua;

import com.google.common.eventbus.Subscribe;

public class Teacher {

    private String teacherName;

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }

    @Subscribe
    public void subscribe(Question question){
        System.out.println(teacherName + "老师，您好。"+ question.getName() +
                "提了一个问题，问题内容是：" + question.getContext());
    }
}
