package com.study.exercise.charper2_2;

public class DBOperate implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("DBOperate close");
    }
}
