package com.tcs.edu.decorator;

import com.tcs.edu.domain.*;

public interface DoubleTracker {

    /**
     * @param messages array of Message
     * @return delete doubles in messages
     */
    public static Message[] deleteDoubles (Doubling doubling, Message... messages) {
        Message[] messagesOutput = new Message[messages.length];
        if (messages.length != 0) {
            messagesOutput[0] = messages[0];
            int k = 1;
            for (int i = 1; i < messages.length; i++) {
                if (!checkDoubles(messages[i], messagesOutput)) {
                    messagesOutput[k] = messages[i];
                    k++;
                }
            }
        }
        return messagesOutput;
    }

    /**
     * @param messages array of Message
     * @return looking for doubles in messages
     */
    public static boolean checkDoubles(Message message, Message... messages) {
        if (message != null) {
            for (Message inMessage : messages) {
                if (inMessage != null && inMessage.getMessage().equals(message.getMessage())) {
                    return true;
                }
            }
        }
        return false;
    }
}
