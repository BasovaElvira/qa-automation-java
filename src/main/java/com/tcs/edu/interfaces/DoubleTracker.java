package com.tcs.edu.interfaces;

import com.tcs.edu.domain.*;
import com.tcs.edu.enums.*;



public interface DoubleTracker {
    Message[] deleteDoubles (Doubling doubling, Message... messages);

    boolean checkDoubles(Message message, Message... messages);
}
