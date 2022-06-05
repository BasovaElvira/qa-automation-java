package com.tcs.edu.repository;

import com.tcs.edu.domain.Message;
import com.tcs.edu.enums.Severity;
import com.tcs.edu.interfaces.MessageRepository;

import java.util.*;
import java.util.stream.Collectors;

/**
 * task1
 * This class saves a message at log with different filters
 *
 * @author Basova Elvira
 */

public class HashMapMessageRepository implements MessageRepository {
    private Map<String, Message> messages = new HashMap<>();
    @Override
    public UUID create(Message message) {
        final UUID keyString = UUID.randomUUID();
        messages.put(keyString.toString(), message);
        return keyString;
    }

    /**
     * task 2
     * Method finds certain message
     * Side effect: save certain message
     * @param key needed UUID
     */
    @Override
    public Message findByPrimaryKey(UUID key) {
        return messages.get(key);
    }

    /**
     * task 3
     * Method finds all messages
     * Side effect: save all messages
     */
    @Override
    public Collection<Message> findAll() {
        return messages.values();
    }

    /**
     * task 4
     * Method deletes needless messages
     * Side effect: delete messages which have wrong severity
     * @param by needed severity
     */
    @Override
    public Collection<Message> findBySeverity(Severity by) {
//      Collection<Message> filteredMessages = new ArrayList<>();
//      for (Message current : messages.values()) {
//            if (current.getSeverity() == by) filteredMessages.add(current);
//        }
//        return filteredMessages;
        return messages.values().stream()
                .filter(message -> message.getSeverity() ==  by)
                .collect(Collectors.toList());

    }
}
