package com.bytesize.daos;
import com.bytesize.entities.Message;
import com.bytesize.entities.Product;

import java.util.List;

public interface MessageDAO {
    Message sendMessageDAO(Message message);

    List<Message> getMessageById(int id);

}
