package com.tcs.edu;

import com.tcs.edu.decorator.Doubling;
import com.tcs.edu.decorator.Order;
import com.tcs.edu.decorator.Severity;
import com.tcs.edu.services.MessageService;

public class Application {
    public static void main(String[] args) {
        MessageService.mergeMessage(Severity.MINOR, "Hello", null, "Belong", "YEP");
        MessageService.mergeMessage(Severity.REGULAR, Order.DESK, "Hello", "Hi", "Hello World!", null, "voice", "etc.");
        MessageService.mergeMessage(Severity.MAJOR, Order.ASK, Doubling.DISTINCT, "Cat", "Dog", "Pig", "Cow", "Cat");
    }

}