package com.tcs.edu.domain;

import com.tcs.edu.enums.Severity;
import java.util.*;

public class Message {

    private Severity severity;
    private String message;

    public Message(Severity severity, String message) {
        this.severity = severity;
        this.message = message;
    }

    public Message() {};

    public Message(String message) {
        this(Severity.MINOR, message);
    }

    public Severity getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "severity=" + severity +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return severity == message1.severity && Objects.equals(message, message1.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(severity, message);
    }
}
