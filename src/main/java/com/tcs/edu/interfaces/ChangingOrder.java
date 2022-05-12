package com.tcs.edu.interfaces;

import com.tcs.edu.domain.*;
import com.tcs.edu.enums.*;

public interface ChangingOrder {
    Message[] changeOrder(Order order, Message... messages);
}
