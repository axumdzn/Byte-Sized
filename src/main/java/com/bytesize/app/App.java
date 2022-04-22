package com.bytesize.app;

import com.bytesize.daos.ProductDAO;
import com.bytesize.daos.ProductDAOImp;
import com.bytesize.entities.Product;
import com.bytesize.service.ProductService;
import com.bytesize.service.ProductServiceImp;
import io.javalin.Javalin;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.enableDevLogging();

        });
    // this is coding to the interface: set the type as the interface, the object constructor used is form the implements class
        ProductDAOImp productDao = new ProductDAOImp();
       ProductService productService = new ProductServiceImp(productDao) ;
        ProductController productController = new ProductController(productService);




        app.get("/", productController.addProduct);
        //app.post("/person", productController.)

        app.post("/Product", productController.createProduct);

        app.get("/Product/{id}", productController.selectProduct);

        app.get("/AllProducts", productController.selectAllProduct);

        app.put("/UpdateProduct", productController.updateProduct);

        app.delete("RemoveProduct/{id}", productController.removeProduct);

        app.start();
    }

}
