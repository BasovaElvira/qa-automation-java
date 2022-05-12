package com.tcs.edu.printer;

import com.tcs.edu.interfaces.*;

/**
 * This class print a message at console
 *
 * @author Basova Elvira
 */


public class ConsolePrinter implements Printer {

    /**
     * Method print is printing the message which you want
     * Side effect: message at console
     * @param message needed text
     */
    @Override
    public void print(String message) {
        System.out.println(message);
    }


}
