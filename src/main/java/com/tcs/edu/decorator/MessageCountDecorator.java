package com.tcs.edu.decorator;

public class MessageCountDecorator {

    public static Integer messageCount = 0;

    public static Integer addCount() {
        ++messageCount;
        return  messageCount;
    }
}
