package com.bytesize.service;

import com.bytesize.entities.Product;

import java.util.List;

public interface ProductService
{
    Product serviceDisplayProductByProductID(int productId);


    List<Product> serviceDisplayAllProductsBySellerId(int sellerId);
}
