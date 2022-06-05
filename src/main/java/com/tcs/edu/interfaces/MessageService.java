package com.tcs.edu.interfaces;

import com.tcs.edu.domain.*;
import com.tcs.edu.enums.*;

import java.util.Collection;
import java.util.UUID;

public interface MessageService {

    UUID[] log(Message... messages);

    UUID[] log(Order order, Message... messages);

    UUID[] log(Doubling doubling, Order order, Message... messages);

    Message findByPrimaryKey(UUID key);

    Collection<Message> findAll();

    Collection<Message> findBySeverity(Severity by);
}
