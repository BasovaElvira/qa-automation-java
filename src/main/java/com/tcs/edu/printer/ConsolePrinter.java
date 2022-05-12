package com.tcs.edu.printer;/**
 * This class print a message at console
 *
 * @author Basova Elvira
 */


public interface ConsolePrinter {

    /**
     * Method print is printing the message which you want
     * Side effect: message at console
     * @param message needed text
     */
    static void print(String message) {
        System.out.println(message);
    }


}
