package com.study.exercise.charper2_2;

public class Test {
    public static void main(String[] args) {
        try (DBOperate operate = new DBOperate() ){
            System.out.println("db start");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
