package com.bytesize.app;
import com.bytesize.customExceptions.BadInput;
import com.bytesize.customExceptions.IdNotFound;
import com.bytesize.entities.Product;
import com.bytesize.service.ProductService;
import com.google.gson.Gson;
import io.javalin.http.Handler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ProductController {
    public static Logger logger = LogManager.getLogger(ProductController.class);

    public ProductService productServiceInterface;
    public static String resultJson;
    public ProductController(ProductService productServiceInterface) {
        this.productServiceInterface = productServiceInterface;
    }

    public Handler updateProduct = ctx -> {
        try{
            logger.info("starting process to login");
            Gson gson = new Gson();
            logger.info("getting http request body");
            String body = ctx.body();
            logger.info("creating Person object from http request body");
            Product product = gson.fromJson(body, Product.class);
            logger.info("attempting to send user info to database " + product.getProductId());
            int result = productServiceInterface.updateProduct(product);
            logger.info("successfully added person with info: " + result + " to database");
            resultJson = gson.toJson(result);
            logger.info(resultJson);
            ctx.result(resultJson);
            ctx.status(201);
            logger.info("all done!");
        }catch(BadInput e) {
            ctx.result(e.getMessage());
            ctx.status(405);
        }catch(IdNotFound e){
            ctx.result(e.getMessage());
            ctx.status(405);
        }
    };
}