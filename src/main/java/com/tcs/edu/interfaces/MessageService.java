package com.tcs.edu.interfaces;

import com.tcs.edu.domain.*;
import com.tcs.edu.enums.*;

public interface MessageService {

    void log(Message... messages);

    void log(Order order, Message... messages);

    void log(Doubling doubling, Order order, Message... messages);
}
