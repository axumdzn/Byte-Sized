package com.bytesize.app;
import com.bytesize.daos.*;
import com.bytesize.service.*;
import io.javalin.Javalin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//
import com.bytesize.daos.ProductDAO;
import com.bytesize.daos.ProductDAOImp;
import com.bytesize.service.ProductService;
import com.bytesize.service.ProductServiceImp;


public class App
{
    /*
        Javalin is used to handle receiving HTTP requests and returning HTTP responses.
     */

    public static Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args)
    {
        // see the log notes in week 8 to get a list of logging level options
        logger.info("Creating Javalin object now");
        Javalin app = Javalin.create(config ->
        {
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
        ProductController productController = new ProductController(PS);
        JavalinController controller = new JavalinController(PS);

        // yw
        app.post("/login", userController.userLogin);

        app.post("/messageSend", messageController.messageSend);


        app.get("/getmessagesbyid/{id}", messageController.getmessagebyid);


        app.post("/productUpdate", productController.updateProduct);

        logger.info("Starting web server");
        app.start();





        // jeny

        app.get("/", productController.addProduct);
        //app.post("/person", productController.)

        app.post("/Product", productController.createProduct);

        app.get("/Product/{id}", productController.selectProduct);

        app.get("/AllProducts", productController.selectAllProduct);

        app.put("/UpdateProduct", productController.updateProduct);

        app.delete("RemoveProduct/{id}", productController.removeProduct);
        // tashawn

        app.get("/product/{productId}", controller.getProductByProductId);

        app.get("/products/{sellerId}", controller.getAllProductsBySellerId);

        logger.info("Starting web server");

    

//        TransactionController transactionController = new TransactionController();
//        RatingController ratingController = new RatingController();
//
//        app.post("/api/transaction",transactionController.createTransaction);
//        app.get("/api/transaction/{id}",transactionController.getTransactionInfo);
//        app.put("/api/transaction/{id}/{status}", transactionController.updateTransactionStatus);
//        app.post("/api/rating", ratingController.createRating);
//        app.get("/api/rating/average/{id}", ratingController.getAverageRating);
//        app.get("/api/rating/{id}", ratingController.getAllRatings);

        app.start();
    }
}
