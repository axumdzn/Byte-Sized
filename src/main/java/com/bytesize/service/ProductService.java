package com.bytesize.service;

import com.bytesize.entities.Product;

import java.util.List;

public interface ProductService {

    // create
    Product serviceCreateProduct(Product Product);

    // select
    Product serviceSelectProductById(int id);

    List<Product> serviceSelectAllProducts();

    // update
    int serviceUpdateProductById(Product Product);





    // delete
    int serviceRemoveProductById(int id);
}

