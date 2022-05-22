package com.tcs.edu.services;

import com.tcs.edu.domain.*;

public abstract class ValidatedService {

    public boolean isArgsValid(String message) {
        if (message == null) { return false;}
        if (message.isEmpty()) { return false;}
        return true;
    }
}
