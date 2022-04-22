package com.bytesize.service;
import com.bytesize.customExceptions.BadInput;
import com.bytesize.customExceptions.IdNotFound;
import com.bytesize.daos.ProductDAO;
import com.bytesize.entities.Product;

public class ProductServiceImp implements ProductService {
    public ProductDAO PD;

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
        int result =  PD.updateProductInfo(product);

        if(result == 0){
            throw new IdNotFound("Id not found");
        }
        return result;
    }
}
