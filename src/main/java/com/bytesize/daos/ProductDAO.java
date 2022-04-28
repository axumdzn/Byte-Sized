package com.bytesize.daos;
import com.bytesize.entities.Product;


import java.util.ArrayList;
import java.util.List;

public interface ProductDAO {

    String interfaceField = "this is my interface string";

    Product createProduct(Product Product);

    Product selectProductById(int id);

    ArrayList<Product> selectAllProducts();

    int updateProductById(Product Product);

    int removeProductById(int id);

    List<Product> selectAllProductByUserId(int id);
}
