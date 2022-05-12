package com.tcs.edu.decorator;

import com.tcs.edu.interfaces.*;

public class MessageCountDecoratorImpl implements MessageCountDecorator {

    public static Integer messageCount = 0;

    /**
     * @return add count to message
     */
    @Override
    public Integer addCount() {
        ++messageCount;
        return  messageCount;
    }
}