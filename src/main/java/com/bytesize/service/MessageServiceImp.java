package com.bytesize.service;
import com.bytesize.customExceptions.BadInput;
import com.bytesize.customExceptions.UserNotFound;
import com.bytesize.daos.MessageDAO;
import com.bytesize.entities.Message;

public class MessageServiceImp implements MessageService {
    public MessageDAO MD;

    public MessageServiceImp(MessageDAO MD) {
        this.MD = MD;
    }

    @Override
    public Message sendMessage(Message message) {
        if (message.getMessage().length() >= 250) {
            throw new BadInput("The input value should be less than 250");
        }

        Message result = MD.sendMessageDAO(message);
        if(result == null){
            throw new UserNotFound("User id not found");
            }
        return result;
    }
}


