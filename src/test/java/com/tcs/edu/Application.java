package com.tcs.edu;

import com.tcs.edu.enums.Doubling;
import com.tcs.edu.enums.Order;
import com.tcs.edu.enums.Severity;
import com.tcs.edu.domain.*;
import com.tcs.edu.services.DecoratorMessageService;

public class Application {
    public static void main(String[] args) {

        new DecoratorMessageService().log(
                new Message("Hello11"),
                new Message("Hello11"),
                new Message("Hello11"),
                new Message("Hello11")
        );

        new DecoratorMessageService().log(
                Order.DESK,
                new Message(Severity.REGULAR,"Hello12"),
                new Message(Severity.MAJOR,"Hello22"),
                new Message(Severity.REGULAR,"Hello32"),
                new Message(Severity.MAJOR,"Hello42")
        );

        new DecoratorMessageService().log(
                Doubling.DISTINCT,
                Order.DESK,
                new Message("Hello13"),
                new Message(Severity.REGULAR,"Hello3"),
                new Message(Severity.MAJOR,"Hello23"),
                new Message(Severity.REGULAR,"Hello3")
        );
    }

}