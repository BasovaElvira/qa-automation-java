package com.tcs.edu.interfaces;

import com.tcs.edu.domain.Message;
import com.tcs.edu.enums.Severity;

import java.util.Collection;

public interface MessageRepository {
    String create(Message message);
    Message findByPrimaryKey(String key);
    Collection<Message> findAll();

    Collection<Message> findBySeverity(Severity by);
}
