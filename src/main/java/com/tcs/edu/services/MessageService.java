package com.tcs.edu.services;

import com.tcs.edu.decorator.*;
import com.tcs.edu.printer.ConsolePrinter;

import java.time.Instant;

/**
 * This class merges messages, exclude null and can change order
 * and search doubles
 *
 * @author Basova Elvira
 */

public class MessageService {

    public static void mergeMessage(Severity severity, String... messages) {
        for (String currentMessage : messages) {
            if (currentMessage != null) {
                ConsolePrinter.print(String.format("%d %s %s",
                        MessageCountDecorator.addCount(),
                        Instant.now(),
                        SeparationMessageDecorator.addDivision(severity, currentMessage)));
            }
        }
    }

    public static void mergeMessage(Severity severity, Order order, String... messages) {
        for (String currentMessage : ChangingOrder.changeOrder(order, messages)) {
            if (currentMessage != null) {
                ConsolePrinter.print(String.format("%d %s %s",
                        MessageCountDecorator.addCount(),
                        Instant.now(),
                        SeparationMessageDecorator.addDivision(severity, currentMessage)));
            }
        }
    }

    public static void mergeMessage(Severity severity, Order order, Doubling doubling, String... messages) {
        String[] messageWithoutDoubles = DoubleTracker.checkDoubles(doubling, messages).toArray(String[]::new);
        for (String currentMessage : ChangingOrder.changeOrder(order, messageWithoutDoubles)) {
            if (currentMessage != null) {
                ConsolePrinter.print(String.format("%d %s %s",
                        MessageCountDecorator.addCount(),
                        Instant.now(),
                        SeparationMessageDecorator.addDivision(severity, currentMessage)));
            }
        }
    }
}

