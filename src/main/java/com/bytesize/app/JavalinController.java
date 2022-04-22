package com.bytesize.app;

import com.bytesize.entities.Product;
import com.google.gson.Gson;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.List;

public class JavalinController
{

    static List<Product> product = new ArrayList<>(); //is this needed? how to access product list in database?

    public Handler getProductByProductId = ctx ->
    {
        int productId = Integer.parseInt(ctx.pathParam("productId"));

        for(Product p : product){
            if(p.getProductId() == productId)
            {
                Gson gson = new Gson();
                String productJSON = gson.toJson(p);
                ctx.result(productJSON);
                ctx.status(200);
            }
        }
    };

    public Handler getAllProductsBySellerId = ctx ->
    {
        int sellerId = Integer.parseInt(ctx.pathParam("sellerId"));

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
    };


}
