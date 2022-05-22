package com.tcs.edu.services;

/**
 * This class checks Message
 *
 * @author Basova Elvira
 */

public abstract class ValidatedService {

    public void isArgsValid(String message) {
        if (message == null) { throw new IllegalArgumentException("message is null");}
        if (message.isEmpty()) {throw new NullPointerException("message.getBody() is null");}

    }
}
