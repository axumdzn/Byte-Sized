package com.bytesize.service;

import com.bytesize.entities.Product;
import java.util.List;

public interface ProductService {
    int updateProduct(Product product);

    Product serviceCreateProduct(Product Product);

    Product serviceSelectProductById(int id);

    List<Product> serviceSelectAllProducts();

    int serviceRemoveProductById(int id);

    List<Product> serviceSelectAllProductByUserId(int id);
}
