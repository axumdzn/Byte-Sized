package com.bytesize.service;

import com.bytesize.customExceptions.BadInput;
import com.bytesize.customExceptions.IdNotFound;
import com.bytesize.daos.ProductDAO;
import com.bytesize.daos.ProductDAOImp;
import com.bytesize.entities.Product;


import java.util.List;

public class ProductServiceImp implements ProductService {

   public ProductDAOImp productDAOImp;

    public ProductServiceImp(ProductDAOImp productDAOImp) {
        this.productDAOImp = productDAOImp;
    }


    @Override
    public Product serviceCreateProduct(Product product) {
        String title = product.getTitle();
        String description = product.getDescription();
        if (product.getPrice() > 100000) { // should be less than 1000.
            throw new BadInput("");
        }
        if (title.length() > 150) {
            throw new BadInput("");
        }
        if (description.length() > 500) {
            throw new BadInput("");
        } else {
            return productDAOImp.createProduct(product);
        }
    }

    @Override
    public Product serviceSelectProductById(int id) {
        Product product = productDAOImp.selectProductById(id);
        if (product == null) {
            throw new IdNotFound("Please provide valid id");
        } else {
            return product;
        }
    }

    @Override
    public List<Product> serviceSelectAllProducts() {
        return productDAOImp.selectAllProducts();
    }

    @Override
    public int serviceUpdateProductById(Product product) {
        String title = product.getTitle();
        String description = product.getDescription();
        if (product.getPrice() > 100000) {
            throw new BadInput("");
        }
        if (title.length() > 150) {
            throw new BadInput("");
        }
        if (description.length() > 500) {
            throw new BadInput("");
        }

        return 0;
    }



    @Override
    public int serviceRemoveProductById(int id) {
        if (id == 0){
            throw new IdNotFound("Please provide valid id");
        }
        return 0;
    }


}