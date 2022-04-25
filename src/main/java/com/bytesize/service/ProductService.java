package com.bytesize.service;

import com.bytesize.entities.Product;
import java.util.List;

public interface ProductService {
    int updateProduct(Product product);

    // create
    Product serviceCreateProduct(Product Product);

    // select
    Product serviceSelectProductById(int id);

    List<Product> serviceSelectAllProducts();

    // update
//    int serviceUpdateProductById(Product Product);




    // delete
    int serviceRemoveProductById(int id);

    Product serviceDisplayProductByProductID(int productId);


    List<Product> serviceDisplayAllProductsBySellerId(int sellerId);


}
