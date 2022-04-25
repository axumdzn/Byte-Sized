package com.bytesize.service;
import com.bytesize.customExceptions.BadInput;
import com.bytesize.customExceptions.IdNotFound;
import com.bytesize.daos.ProductDAO;
import com.bytesize.daos.ProductDAOImp;
import com.bytesize.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImp implements ProductService {
    public ProductDAO PD;
    public ProductDAOImp productDAOImp;


    public ProductServiceImp(ProductDAO PD){
        this.PD = PD;
    }
    @Override
    public int updateProduct(Product product) {
        if(product.getTitle().length() > 150){
            throw new BadInput("Title should be less than 150 characters");
        }
        else if(product.getDescription().length() > 500){
            throw new BadInput("Description should be less than 500 characters");
        }
        else if(product.getPrice() >= 1000){
            throw new BadInput("Price should be less than 1000");
        }
        else if(product.getInventory() >= 1000){
            throw new BadInput("Inventory should be less than 1000");
        }
        int result =  PD.updateProductById(product);

        if(result == 0){
            throw new IdNotFound("Id not found");
        }
        return result;
    }


    @Override
    public Product serviceCreateProduct(Product product) {

        if(product.getTitle().length() > 150){
            throw new BadInput("Title should be less than 150 characters");
        }
        else if(product.getDescription().length() > 500){
            throw new BadInput("Description should be less than 500 characters");
        }
        else if(product.getPrice() >= 1000){
            throw new BadInput("Price should be less than 1000");
        }
        else if(product.getInventory() >= 1000){
            throw new BadInput("Inventory should be less than 1000");
        } else {
            return PD.createProduct(product);
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
    public ArrayList<Product> serviceSelectAllProducts() {
        return PD.selectAllProducts();
    }


    @Override
    public int serviceRemoveProductById(int id) {
        if (id == 0){
            throw new IdNotFound("Please provide valid id");
        }
        return 0;
    }


}