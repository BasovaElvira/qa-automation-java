package com.tcs.edu.decorator;

/**
 * This class change order
 *
 * @author Basova Elvira
 */

public class ChangingOrder {

    /**
     * Method addDivision is adding a separation to message
     * Side effect: message is changed by the separation
     * @param order is enum,
     * @param messages is array;
     */
    public static String[] changeOrder(Order order, String... messages) {
        switch (order) {
            case DESK:
                String[] reverse = new String[messages.length];
                for (int i = messages.length - 1; i >= 0; i--) {
                    reverse[i] = messages[messages.length - 1 - i];
                }
                messages = reverse; break;
    }
    return messages;
}
}
