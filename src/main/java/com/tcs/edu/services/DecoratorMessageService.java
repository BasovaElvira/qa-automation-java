package com.tcs.edu.services;

import com.tcs.edu.decorator.*;
import com.tcs.edu.domain.*;
import com.tcs.edu.enums.*;
import com.tcs.edu.interfaces.*;
import com.tcs.edu.printer.ConsolePrinter;
import java.time.Instant;

/**
 * This interface merges messages, exclude null and can change order
 * and search doubles
 *
 * @author Basova Elvira
 */

public class DecoratorMessageService implements MessageService {

    @Override
    public void generateMessage(Message[] messageWithoutDoubles, Message[] messages) {
        for (int n = 0; n < messages.length; n++) {
            Message currentMessage = messageWithoutDoubles[n];
            if (currentMessage != null) {
                new ConsolePrinter().print(String.format("%d %s %s",
                        new MessageCountDecoratorImpl().addCount(),
                        Instant.now(),
                        new SeparationMessageDecoratorImpl().addDivision(currentMessage.getSeverity(), currentMessage.getMessage())));
            }
        }
    }

    @Override
    public void log(Message... messages) {
        generateMessage(messages, messages);
    }

    @Override
    public void log(Order order, Message... messages) {
        messages = new ChangingOrderImpl().changeOrder(order, messages);
        generateMessage(messages, messages);
    }
    @Override
    public void log(Doubling doubling, Order order, Message... messages) {
        if(doubling == Doubling.DISTINCT) {
            messages = new ChangingOrderImpl().changeOrder(order, messages);
            Message[] messageWithoutDoubles = new DoubleTrackerImpl().deleteDoubles(doubling, messages);
            generateMessage(messageWithoutDoubles, messages);
        }
        else log(order, messages);
    }


}

