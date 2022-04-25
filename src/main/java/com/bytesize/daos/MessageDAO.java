package com.bytesize.daos;

import com.bytesize.entities.Message;

public interface MessageDAO
{
    // sending a message to the seller
    String messageSeller(String message);
    Message sendMessageDAO(Message message);
}
