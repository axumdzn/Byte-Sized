package com.bytesize.app;
import com.bytesize.daos.ProductDAO;
import com.bytesize.daos.ProductDAOImp;
import com.bytesize.service.ProductService;
import com.bytesize.service.ProductServiceImp;
import io.javalin.Javalin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App
{
    /*
        Javalin is used to handle receiving HTTP requests and returning HTTP responses.
     */

    public static Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args)
    {
        logger.info("Creating Javalin object now");
        Javalin app = Javalin.create(config ->
        {
            config.enableCorsForAllOrigins();
            config.enableDevLogging();
        });
        logger.info("Javalin object created");

        // Below facilitates flow from API to DAL and back up
        ProductDAO productDAO = new ProductDAOImp(); //type is interface; object is imp class
        ProductService productService = new ProductServiceImp(productDAO); //type is interface; object is imp class
        JavalinController controller = new JavalinController(productService);

        app.get("/product/{productId}", controller.getProductByProductId);

        app.get("/products/{sellerId}", controller.getAllProductsBySellerId);

        logger.info("Starting web server");
        app.start();

    }
}
