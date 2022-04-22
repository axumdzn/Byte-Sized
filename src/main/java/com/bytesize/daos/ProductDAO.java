package com.bytesize.daos;

import com.bytesize.entities.Product;

import java.util.List;

public interface ProductDAO {

    String interfaceField = "this is my interface string";

    // create Product
    Product createProduct(Product Product);

    // select Product/s
    Product selectProductById(int id);

    List<Product> selectAllProducts();

    // update Product
    int updateProductById(Product Product);


    // delete Product
    int removeProductById(int id);
}
