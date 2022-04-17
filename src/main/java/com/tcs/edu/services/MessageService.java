package com.tcs.edu.services;

import com.tcs.edu.decorator.ChoiceOfSeverity;
import com.tcs.edu.decorator.MessageCountDecorator;
import com.tcs.edu.decorator.SeparationMessageDecorator;
import com.tcs.edu.decorator.Severity;

import java.time.Instant;

/**
 * This class merges messages
 *
 * @author Basova Elvira
 */

public class MessageService {

    public static String mergeMessage(String message, Severity severity) {
        final var finalMessage = String.format("%d %s %s",
                MessageCountDecorator.addCount(),
                Instant.now(),
                SeparationMessageDecorator.addDivision(severity, message));
        return  finalMessage;
    }
}
