package com.tcs.edu.generator;

import com.tcs.edu.decorator.*;
import com.tcs.edu.domain.*;
import com.tcs.edu.interfaces.*;
import com.tcs.edu.printer.*;
import com.tcs.edu.services.*;

public class MessageGeneratorImpl extends ValidatedService implements MessageGenerator {
    @Override
    public void generateMessage(Message[] messageWithoutDoubles, Message[] messages) {
        for (int n = 0; n < messages.length; n++) {
            Message currentMessage = messageWithoutDoubles[n];
            if (super.isArgsValid(currentMessage.getMessage()) == true) {
                new ConsolePrinter().print(String.format("%d %s %s",
                        new MessageCountDecoratorImpl().addCount(),
                        new TimeStampDecoratorImpl().addTimeStamp(),
                        new SeparationMessageDecoratorImpl().addDivision(currentMessage.getSeverity(), currentMessage.getMessage())));
            }
        }
    }
}
