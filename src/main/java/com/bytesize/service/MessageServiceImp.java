package com.bytesize.service;
import com.bytesize.customExceptions.BadInput;
import com.bytesize.customExceptions.UserNotFound;
import com.bytesize.daos.MessageDAO;
import com.bytesize.entities.Message;

import java.util.List;

public class MessageServiceImp implements MessageService {
    public MessageDAO MD;

    public MessageServiceImp(MessageDAO MD) {
        this.MD = MD;
    }

    @Override
    public Message sendMessage(Message message) {
        if (message.getTitle().length() >= 100) {
            throw new BadInput("The input title should be less than 100");
        }
        if (message.getMessage().length() >= 250) {
            throw new BadInput("The input message should be less than 250");
        }
        Message result = MD.sendMessageDAO(message);
        if(result == null){
            throw new UserNotFound("User id not found");
            }
        return result;
    }

    @Override
    public List<Message> getMessagesById(int id) {
        List<Message> result = MD.getMessageById(id);
        if(result.size() == 0){
            throw new UserNotFound("User id not found");
        }
        return result;
    }
}


