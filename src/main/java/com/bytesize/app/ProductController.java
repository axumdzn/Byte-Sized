package com.bytesize.app;

import com.bytesize.customExceptions.BadInput;
import com.bytesize.customExceptions.IdNotFound;
import com.bytesize.entities.Product;
import com.bytesize.service.ProductService;
import com.bytesize.service.ProductServiceImp;
import com.google.gson.Gson;
import io.javalin.http.Handler;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ProductController {
    public ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public Handler addProduct = ctx -> {
        ctx.result("chips");
    };
    public Handler createProduct = ctx ->{
        try{
            Gson gson = new Gson();
            String body = ctx.body();
            Product product = gson.fromJson(body, Product.class);
            Product result = productService.serviceCreateProduct(product);
            String resultJson = gson.toJson(result);
            ctx.result(resultJson);
            ctx.status(405);
        } catch (BadInput e){
            ctx.result(e.getMessage());
            ctx.status(405);
        }
    };

    public Handler selectProduct = ctx ->{
    try{
        int id = Integer.parseInt(ctx.pathParam("id"));
        Product product = productService.serviceSelectProductById(id);
        Gson gson = new Gson();
        String productJson = gson.toJson(product);
        ctx.result(productJson);
        ctx.status(200);
    } catch (IdNotFound e){
        ctx.result(e.getMessage());
        ctx.status(404);
    }
    };

    public Handler selectAllProduct = ctx -> {
            List<Product> product = productService.serviceSelectAllProducts();
            Gson gson = new Gson();
            String productJson = gson.toJson(product);
            ctx.result(productJson);
            ctx.status(200);

    };

    public Handler updateProduct = ctx -> {
        try{
            Gson gson = new Gson();
            String body = ctx.body();
            Product product = gson.fromJson(body, Product.class);
            int result = productService.serviceUpdateProductById(product);
            String resultJson = gson.toJson(result);
            ctx.result(resultJson);
            ctx.status(405);
        } catch (BadInput e){
            ctx.result(e.getMessage());
            ctx.status(405);
        }
    }; //post/put

    public Handler removeProduct = ctx -> {
        try{
            int id = Integer.parseInt(ctx.pathParam("id"));
            int product = productService.serviceRemoveProductById(id);
            Gson gson = new Gson();
            String productJson = gson.toJson(product);
            ctx.result(productJson);
            ctx.status(200);
        } catch(IdNotFound e){
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    }; //delete

}
