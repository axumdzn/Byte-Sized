package com.bytesize.app;

import com.bytesize.entities.Product;
import com.bytesize.exceptions.IdNotFound;
import com.bytesize.service.ProductService;
import com.google.gson.Gson;
import io.javalin.http.Handler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class JavalinController
{
    public static Logger logger = LogManager.getLogger(JavalinController.class);

    public ProductService productService;

    public JavalinController(ProductService productService)
    {
        this.productService = productService;
    }

    public Handler getProductByProductId = ctx ->
    {
        try
        {
            logger.info("Starting process of getting a product by productId from the database");
            logger.info("Getting the productId from the path parameter");
            int productId = Integer.parseInt(ctx.pathParam("productId"));
            logger.info("Attempting to retrieve product based on the productId");
            Product product = productService.serviceDisplayProductByProductID(productId);
            Gson gson = new Gson();
            logger.info("converting Product object to JSON");
            String productJson = gson.toJson(product);
            ctx.result(productJson);
            ctx.status(200);
            logger.info("All done");
        }
        catch(IdNotFound e)
        {
            ctx.result(e.getMessage());
            ctx.status(404); //Denied
        }
    };

    public Handler getAllProductsBySellerId = ctx ->
    {
       try
        {
            logger.info("Starting process of getting a list of products by sellerId from the database");
            logger.info("Getting the sellerId from the path parameter");
            int sellerId = Integer.parseInt(ctx.pathParam("sellerId"));
            logger.info("Attempting to retrieve products based on the sellerId");
            List<Product> product = productService.serviceDisplayAllProductsBySellerId(sellerId);
            for(Product p: product)
            {
                if(p.getSellerId() == sellerId)
                {
                    Gson gson = new Gson();
                    String productJSON = gson.toJson(p);
                    ctx.result(productJSON);
                    ctx.status(200);
                }
            }
            logger.info("converting Product objects to JSON");
            Gson gson = new Gson();
            String productJson = gson.toJson(product);
            ctx.result(productJson);
            ctx.status(200);
            logger.info("All done");
        }
        catch(IdNotFound e)
        {
            ctx.result(e.getMessage());
            ctx.status(404); //Denied
        }
    };


}
