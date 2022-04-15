package com.tcs.edu.decorator;

import java.time.Instant;

/**
 * This class return message with present time
 *
 * @author Basova Elvira
 */

public class TimestampMessageDecorator {

    static final Integer PAGE_SIZE = 2;
    static int messageCount = 1;

    public static int getMessageCount() {
        return messageCount;
    }
    /**
     * Method decorate is adding the time and a separation to message
     * Side effect: message is changed by the time
     * @param message needed text
     */
    public static String decorate(String message) {

        if (messageCount % PAGE_SIZE == 0) {
            final var decoratedMessage = String.format("%d %s %s\n---", messageCount, Instant.now(), message);
            messageCount++;
            return decoratedMessage;
        }

        final var decoratedMessage = String.format("%d %s %s", messageCount, Instant.now(), message);
        messageCount++;
        return decoratedMessage;
    }
}
