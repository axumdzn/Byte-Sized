package com.bytesize.daos;

import com.bytesize.entities.Product;

public interface ProductDAO {
    Product selectProductById(int id);

    int updateProductInfo(Product product);
}
