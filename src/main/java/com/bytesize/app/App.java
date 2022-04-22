package com.bytesize.app;
import io.javalin.Javalin;

public class App
{
    /*
        Javalin is used to handle receiving HTTP requests and returning HTTP responses.
     */

    public static void main(String[] args)
    {
        Javalin app = Javalin.create(config ->
        {
            config.enableCorsForAllOrigins();
            config.enableDevLogging();
        });

        JavalinController controller = new JavalinController();

        app.get("/product/{productId}", controller.getProductByProductId);

        app.get("/products/{sellerId}", controller.getAllProductsBySellerId);

        app.start();

    }
}
