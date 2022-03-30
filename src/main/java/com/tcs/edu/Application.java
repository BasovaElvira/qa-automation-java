package com.tcs.edu;

import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.printer.ConsolePrinter;

public class Application {
    public static void main(String[] args) {
        int count = 3;
        int i = 0;
        while(i < count){
            ConsolePrinter.print(TimestampMessageDecorator.decorate("Hello World!"));
            i++;
        }
    }
}