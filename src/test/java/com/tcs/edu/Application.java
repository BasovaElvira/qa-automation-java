package com.tcs.edu;

import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.printer.ConsolePrinter;

public class Application {
    public static void main(String[] args) {

        while(TimestampMessageDecorator.getMessageCount() < 10) {
            ConsolePrinter.print(TimestampMessageDecorator.decorate("Hello World!"));
        }

    }
}