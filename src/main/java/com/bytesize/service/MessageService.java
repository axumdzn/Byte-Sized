package com.bytesize.service;
import com.bytesize.entities.Message;

import java.util.List;

public interface MessageService {
    Message sendMessage(Message message);
    List<Message> getMessagesById(int id);
}
