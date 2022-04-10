package com.tcs.edu.decorator;

import java.time.Instant;

/**
 * This class return message with present time
 *
 * @author Basova Elvira
 */

public class TimestampMessageDecorator {
    static int messageCount = 1;
    /**
     * Method decorate is adding the time to message
     * Side effect: message is changed by the time
     * @param message needed text
     */
    public static String decorate(String message) {
        final var decoratedMessage = String.format("%d %s %s", messageCount, Instant.now(), message);
        messageCount++;
        return decoratedMessage;
    }
}
