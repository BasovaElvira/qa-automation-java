package com.tcs.edu;

import com.tcs.edu.decorator.Severity;
import com.tcs.edu.printer.ConsolePrinter;
import com.tcs.edu.services.MessageService;

public class Application {
    public static void main(String[] args) {
        ConsolePrinter.print(MessageService.mergeMessage("Hello World!", Severity.MAJOR));
        ConsolePrinter.print(MessageService.mergeMessage("Hello World!", Severity.MINOR));
        ConsolePrinter.print(MessageService.mergeMessage("Hello World!", Severity.REGULAR));
        ConsolePrinter.print(MessageService.mergeMessage("Hello World!", Severity.REGULAR));
        ConsolePrinter.print(MessageService.mergeMessage("Hello World!", Severity.MAJOR));
        ConsolePrinter.print(MessageService.mergeMessage("Hello World!", Severity.MINOR));
        ConsolePrinter.print(MessageService.mergeMessage("Hello World!", Severity.REGULAR));
        ConsolePrinter.print(MessageService.mergeMessage("Hello World!", Severity.MAJOR));
        ConsolePrinter.print(MessageService.mergeMessage("Hello World!", Severity.MAJOR));
        ConsolePrinter.print(MessageService.mergeMessage("Hello World!", Severity.MINOR));

    }
}