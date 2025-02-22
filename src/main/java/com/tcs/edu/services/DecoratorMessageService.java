package com.tcs.edu.services;

import com.tcs.edu.decorator.*;
import com.tcs.edu.domain.*;
import com.tcs.edu.enums.*;
import com.tcs.edu.generator.*;
import com.tcs.edu.interfaces.*;
import com.tcs.edu.repository.HashMapMessageRepository;

import java.util.Collection;
import java.util.UUID;


/**
 * This interface merges messages, exclude null and can change order
 * and search doubles
 *
 * @author Basova Elvira
 */

public class DecoratorMessageService implements MessageService {


    private MessageRepository messageRepository = new HashMapMessageRepository();

    public String collectLog(Message message) {
        return messageRepository.create(message);
    }

    @Override
    public String[] log(Message... messages) {
        new MessageGeneratorImpl().generateMessage(messages, messages);
        String[] hashString = new String[messages.length];
        for (int i = 0; i < messages.length; i++) {
            hashString[i] = messageRepository.create(messages[i]);
        }
        return  hashString;
    }

    @Override
    public String[] log(Order order, Message... messages) {
        messages = new ChangingOrderImpl().changeOrder(order, messages);
        new MessageGeneratorImpl().generateMessage(messages, messages);
        String[] hashString = new String[messages.length];
        for (int i = 0; i < messages.length; i++) {
            hashString[i] = messageRepository.create(messages[i]);
        }
        return  hashString;
    }
    @Override
    public String[] log(Doubling doubling, Order order, Message... messages) {
        if(doubling == Doubling.DISTINCT) {
            messages = new ChangingOrderImpl().changeOrder(order, messages);
            Message[] messageWithoutDoubles = new DoubleTrackerImpl().deleteDoubles(doubling, messages);
            new MessageGeneratorImpl().generateMessage(messageWithoutDoubles, messages);
        }
        else log(order, messages);
        String[] hashString = new String[messages.length];
        for (int i = 0; i < messages.length; i++) {
            hashString[i] = messageRepository.create(messages[i]);
        }
        return  hashString;
    }

    @Override
    public Message findByPrimaryKey(String key) {
        return messageRepository.findByPrimaryKey(key);
    }

    @Override
    public Collection<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Collection<Message> findBySeverity(Severity by) {
        return messageRepository.findBySeverity(by);
    }


}

