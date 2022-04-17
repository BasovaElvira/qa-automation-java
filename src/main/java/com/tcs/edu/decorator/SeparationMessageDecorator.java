package com.tcs.edu.decorator;

import java.time.Instant;

/**
 * This class separats messages
 *
 * @author Basova Elvira
 */

public class SeparationMessageDecorator {

    static final Integer PAGE_SIZE = 2;

    /**
     * Method addDivision is adding a separation to message
     * Side effect: message is changed by the separation
     * @param message needed text,
     * @param severity is enum
     */
    public static String addDivision (String message, Severity severity) {

        if (MessageCountDecorator.messageCount % PAGE_SIZE == 0) {
            final var dividedMessage = String.format("%s %s\n---", message, ChoiceOfSeverity.chooseSeverity(severity));
            return dividedMessage;
        }

        final var undividedMessage = String.format("%s %s", message, ChoiceOfSeverity.chooseSeverity(severity));
        return undividedMessage;
    }
}
