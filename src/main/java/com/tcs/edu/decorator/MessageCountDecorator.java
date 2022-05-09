package com.tcs.edu.decorator;

import java.util.Arrays;

public class MessageCountDecorator {

    public static Integer messageCount = 0;

    /**
     * @return add count to message
     */
    public static Integer addCount() {
        ++messageCount;
        return  messageCount;
    }
}