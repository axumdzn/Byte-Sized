package com.bytesize.app;
import com.bytesize.customExceptions.BadInput;
import com.bytesize.customExceptions.UserNotFound;
import com.bytesize.entities.Message;
import com.bytesize.service.MessageService;
import com.google.gson.Gson;
import io.javalin.http.Handler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MessageController {
    public static Logger logger = LogManager.getLogger(MessageController.class);

    public MessageService messageServiceInterface;

    public MessageController(MessageService messageServiceInterface) {
        this.messageServiceInterface = messageServiceInterface;
    }

    public Handler messageSend = ctx -> {
        try{
            logger.info("starting process to login");
            Gson gson = new Gson();
            logger.info("getting http request body");
            String body = ctx.body();
            logger.info("creating Person object from http request body");
            Message message = gson.fromJson(body, Message.class);
            logger.info("attempting to send user info to database " + message.getMessage());
            Message result = messageServiceInterface.sendMessage(message);
            logger.info("successfully added person with info: " + result + " to database");
            String resultJson = gson.toJson(result);
            ctx.result(resultJson);
            ctx.status(201);
            logger.info("all done!");
        }catch(BadInput e) {
            ctx.result(e.getMessage());
            ctx.status(405);
        }catch(UserNotFound e){
            ctx.result(e.getMessage());
            ctx.status(405);
        }
    };
}