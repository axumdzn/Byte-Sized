package com.bytesize.daos;

import com.bytesize.entities.Message;

public interface MessageDAO
{
    // sending a message to the seller
    Message sendMessageDAO(Message message);
}
