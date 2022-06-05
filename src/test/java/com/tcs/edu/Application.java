package com.tcs.edu;

import com.tcs.edu.enums.Doubling;
import com.tcs.edu.enums.Order;
import com.tcs.edu.enums.Severity;
import com.tcs.edu.domain.*;
import com.tcs.edu.interfaces.MessageService;
import com.tcs.edu.services.DecoratorMessageService;

import java.util.Collection;
import java.util.UUID;

public class Application {
    public static void main(String[] args) {

        MessageService service = new DecoratorMessageService();

        final String[] generatedKeys1 = service.log(
                new Message("Hello1"),
                new Message("Hello2"),
                new Message("Hello3"),
                new Message("Hello4")
        );
        System.out.println("===================");
        for (int i = 0; i < generatedKeys1.length; i++) {
            String m = "отдельный вывод лога: " + service.findByPrimaryKey(generatedKeys1[i]);
            System.out.println(m);
        }
        System.out.println("===================");

        final Collection<Message> allMessages = service.findAll();
        System.out.println("Вывод полного лога:");
        for (Message current : allMessages) {
            System.out.println(current);
        }
        System.out.println("===================");

        final String[] generatedKeys2 = service.log(
                Order.DESK,
                new Message(Severity.REGULAR,"Hello21"),
                new Message(Severity.MAJOR,"Hello22"),
                new Message(Severity.REGULAR,"Hello32"),
                new Message(Severity.MAJOR,"Hello42")
        );

        for (Message current : service.findBySeverity(Severity.MAJOR)) {
            System.out.println("лог с приоритетом MAJOR: " + current);
        }
        System.out.println("===================");

        final String[] generatedKeys3 = service.log(
                Doubling.DISTINCT,
                Order.DESK,
                new Message("Hello13"),
                new Message(Severity.REGULAR,"Hello3"),
                new Message(Severity.MAJOR,"Hello23"),
                new Message(Severity.REGULAR,"Hello31")
        );

        for (int i = 0; i < generatedKeys3.length; i++) {
            System.out.println("отдельный вывод лога: " + service.findByPrimaryKey(generatedKeys3[i]));
        }
        System.out.println("===================");

    }
}