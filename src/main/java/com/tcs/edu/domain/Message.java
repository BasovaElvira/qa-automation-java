package com.tcs.edu.domain;

import com.tcs.edu.enums.Severity;

public class Message {

    private static Severity severity;
    private static String message;

    public Message(Severity severity, String message) {
        this.severity = severity;
        this.message = message;
    }

    public Message(String message) {
        this(Severity.MINOR, message);
    }

    public Severity getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }


}
