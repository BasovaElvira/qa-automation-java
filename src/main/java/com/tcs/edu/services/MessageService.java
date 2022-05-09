package com.tcs.edu.services;

import com.tcs.edu.decorator.*;
import com.tcs.edu.domain.*;
import com.tcs.edu.printer.ConsolePrinter;
import java.time.Instant;

/**
 * This interface merges messages, exclude null and can change order
 * and search doubles
 *
 * @author Basova Elvira
 */

public interface MessageService {

    private static void generateMessage(Message[] messageWithoutDoubles, Message[] messages) {
        for (int n = 0; n < messages.length; n++) {
            Message currentMessage = messageWithoutDoubles[n];
            if (currentMessage != null) {
                ConsolePrinter.print(String.format("%d %s %s",
                        MessageCountDecorator.addCount(),
                        Instant.now(),
                        SeparationMessageDecorator.addDivision(currentMessage.getSeverity(), currentMessage.getMessage())));
            }
        }
    }

    static void mergeMessage(Message... messages) {
        generateMessage(messages, messages);
    }

    static void mergeMessage(Order order, Message... messages) {
        messages = ChangingOrder.changeOrder(order, messages);
        generateMessage(messages, messages);
    }

    static void mergeMessage(Doubling doubling, Order order, Message... messages) {
        if(doubling == Doubling.DISTINCT) {
            messages = ChangingOrder.changeOrder(order, messages);
            Message[] messageWithoutDoubles = DoubleTracker.deleteDoubles(doubling, messages);
            generateMessage(messageWithoutDoubles, messages);
        }
        else mergeMessage(order, messages);
    }


}

