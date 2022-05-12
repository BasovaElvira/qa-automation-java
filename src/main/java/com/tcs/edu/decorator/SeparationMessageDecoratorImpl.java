package com.tcs.edu.decorator;

import com.tcs.edu.enums.*;
import com.tcs.edu.interfaces.*;

/**
 * This class separats messages
 *
 * @author Basova Elvira
 */

public class SeparationMessageDecoratorImpl implements SeparationMessageDecorator {

    /**
     * Method addDivision is adding a separation to message
     * Side effect: message is changed by the separation
     * @param message needed text,
     * @param severity is enum
     */
    @Override
    public String addDivision(Severity severity, String message) {

        if (MessageCountDecoratorImpl.messageCount % 2 == 0) {
            final var dividedMessage = String.format("%s %s\n---", message, new ChoiceOfSeverityImpl().chooseSeverity(severity));
            return dividedMessage;
        }

        final var undividedMessage = String.format("%s %s", message, new ChoiceOfSeverityImpl().chooseSeverity(severity));
        return undividedMessage;
    }
}
