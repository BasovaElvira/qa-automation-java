package com.tcs.edu.services;

import com.tcs.edu.decorator.*;
import com.tcs.edu.domain.*;
import com.tcs.edu.enums.*;
import com.tcs.edu.generator.*;
import com.tcs.edu.interfaces.*;


/**
 * This interface merges messages, exclude null and can change order
 * and search doubles
 *
 * @author Basova Elvira
 */

public class DecoratorMessageService implements MessageService {



    @Override
    public void log(Message... messages) {
        new MessageGeneratorImpl().generateMessage(messages, messages);
    }

    @Override
    public void log(Order order, Message... messages) {
        messages = new ChangingOrderImpl().changeOrder(order, messages);
        new MessageGeneratorImpl().generateMessage(messages, messages);
    }
    @Override
    public void log(Doubling doubling, Order order, Message... messages) {
        if(doubling == Doubling.DISTINCT) {
            messages = new ChangingOrderImpl().changeOrder(order, messages);
            Message[] messageWithoutDoubles = new DoubleTrackerImpl().deleteDoubles(doubling, messages);
            new MessageGeneratorImpl().generateMessage(messageWithoutDoubles, messages);
        }
        else log(order, messages);
    }


}

