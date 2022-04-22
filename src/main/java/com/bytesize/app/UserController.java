package com.bytesize.app;
import com.bytesize.customExceptions.BadInput;
import com.bytesize.customExceptions.UserNotFound;
import com.bytesize.entities.User;
import com.bytesize.service.UserService;
import com.google.gson.Gson;
import io.javalin.http.Handler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserController {
    public static Logger logger = LogManager.getLogger(UserController.class);

    public UserService UserServiceInterface;


    public UserController(UserService UserServiceInterface) {
        this.UserServiceInterface = UserServiceInterface;
    }

    public Handler userLogin = ctx -> {
        try{
            logger.info("starting process to login");
            Gson gson = new Gson();
            logger.info("getting http request body");
            String body = ctx.body();
            logger.info("creating Person object from http request body");
            User user = gson.fromJson(body, User.class);
            logger.info("attempting to send user info to database"+user.getUserName()+ user.getPassWord());
            User result = UserServiceInterface.login(user.getUserName(), user.getPassWord());
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
