package com.tcs.edu.decorator;

import com.tcs.edu.domain.*;

/**
 * This class change order
 *
 * @author Basova Elvira
 */

public interface ChangingOrder {

    /**
     * Method addDivision is adding a separation to message
     * Side effect: message is changed by the separation
     * @param order is enum,
     * @param messages is array;
     */
    static Message[] changeOrder(Order order, Message... messages) {
        switch (order) {
            case DESK:
                Message[] reverse = new Message[messages.length];
                for (int i = messages.length - 1; i >= 0; i--) {
                    reverse[i] = messages[messages.length - 1 - i];
                }
                messages = reverse; break;
    }
    return messages;
}
}
