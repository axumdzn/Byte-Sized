package com.bytesize.app;
import com.bytesize.daos.*;
import com.bytesize.service.*;
import io.javalin.Javalin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class App {
    public static Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        // see the log notes in week 8 to get a list of logging level options
        logger.info("creating Javalin object now");
        Javalin app = Javalin.create(config ->{
            config.enableCorsForAllOrigins();
            config.enableDevLogging();
        });
        logger.info("Javalin object created!");
    /*
        This is where all three layers of the application come together. I create a dao object, then pass it
        into the service object, which I then pass into the controller object. This allows each layer of the
        application to transfer data from one layer to the next.
     */
        // this is coding to the interface: set the type as the interface, the object constructor used is from the implementation class

        UserDAO UD = new UserDAOImp();
        UserService US = new UserServiceImp(UD);
        UserController userController = new UserController(US);

        MessageDAO MD = new MessageDAOImp();
        MessageService MS = new MessageServiceImp(MD);
        MessageController messageController = new MessageController(MS);

        ProductDAO PD = new ProductDAOImp();
        ProductService PS = new ProductServiceImp(PD);
        ProductController ProductController = new ProductController(PS);


        app.post("/login", userController.userLogin);

        app.post("/messageSend", messageController.messageSend );

        app.post("/productUpdate", ProductController.updateProduct);

        logger.info("Starting web server");
        app.start();

        }// main end
    }

