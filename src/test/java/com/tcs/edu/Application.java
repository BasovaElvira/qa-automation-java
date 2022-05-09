package com.tcs.edu;

import com.tcs.edu.decorator.Doubling;
import com.tcs.edu.decorator.Order;
import com.tcs.edu.decorator.Severity;
import com.tcs.edu.domain.*;
import com.tcs.edu.services.MessageService;

public class Application {
    public static void main(String[] args) {

        MessageService.mergeMessage(
                new Message("Hello11"),
                new Message("Hello11"),
                new Message("Hello11"),
                new Message("Hello11")
        );

        MessageService.mergeMessage(
                Order.DESK,
                new Message(Severity.REGULAR,"Hello12"),
                new Message(Severity.MAJOR,"Hello22"),
                new Message(Severity.REGULAR,"Hello32"),
                new Message(Severity.MAJOR,"Hello42")
        );

        MessageService.mergeMessage(
                Doubling.DISTINCT,
                Order.DESK,
                new Message("Hello13"),
                new Message(Severity.REGULAR,"Hello3"),
                new Message(Severity.MAJOR,"Hello23"),
                new Message(Severity.REGULAR,"Hello3")
        );
    }

}