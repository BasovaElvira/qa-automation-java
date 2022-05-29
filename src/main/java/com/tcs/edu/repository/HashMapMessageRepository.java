package com.tcs.edu.repository;

import com.tcs.edu.domain.Message;
import com.tcs.edu.enums.Severity;
import com.tcs.edu.interfaces.MessageRepository;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapMessageRepository implements MessageRepository {
    private Map<String, Message> messages = new HashMap<>();
    @Override
    public UUID create(Message message) {
        final UUID keyString = UUID.randomUUID();
        messages.put(keyString.toString(), message);
        return keyString;
    }

    @Override
    public Message findByPrimaryKey(UUID key) {
        return messages.get(key);
    }

    @Override
    public Collection<Message> findAll() {
        return messages.values();
    }

    @Override
    public Collection<Message> findBySeverity(Severity by) {
        Collection<Message> filteredMessages = new ArrayList<>();
//      for (Message current : messages.values()) {
//            if (current.getSeverity() == by) filteredMessages.add(current);
//        }
//        return filteredMessages;
        return messages.values().stream()
                .filter(message -> message.getSeverity() ==  by)
                .collect(Collectors.toList());

    }
}
