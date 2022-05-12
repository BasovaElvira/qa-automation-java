package com.tcs.edu.decorator;

import com.tcs.edu.domain.*;
import com.tcs.edu.interfaces.*;
import java.time.*;

public class TimeStampDecoratorImpl implements TimeStampDecorator {

    @Override
    public String addTimeStamp() {
        return String.format("%s", Instant.now());
    }
}
