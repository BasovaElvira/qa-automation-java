package com.tcs.edu.interfaces;

import com.tcs.edu.domain.*;
import com.tcs.edu.enums.*;

import java.util.Collection;
import java.util.UUID;

public interface MessageService {

    String[] log(Message... messages);

    String[] log(Order order, Message... messages);

    String[] log(Doubling doubling, Order order, Message... messages);

    Message findByPrimaryKey(String key);

    Collection<Message> findAll();

    Collection<Message> findBySeverity(Severity by);
}
