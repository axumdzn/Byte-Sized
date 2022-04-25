package com.bytesize.service;

import com.bytesize.entities.Product;
import com.bytesize.daos.ProductDAO;
import com.bytesize.exceptions.IdNotFound;

import java.util.List;

public class ProductServiceImp implements ProductService
{

    public ProductDAO productDAOInterface; // service layer uses this to implement dao interface methods

    public ProductServiceImp(ProductDAO productDAOInterface)
    {
        this.productDAOInterface = productDAOInterface;
    }

    @Override
    public Product serviceDisplayProductByProductID(int productId)
    {
        Product product = productDAOInterface.displayProductByProductID(productId);
        if(product == null)
        {
            throw new IdNotFound("No products to show with this product ID");
        }
        else
        {
            return product;
        }
    }

    @Override
    public List<Product> serviceDisplayAllProductsBySellerId(int sellerId)
    {
        List<Product> product = productDAOInterface.displayAllProductsBySellerId(sellerId);
        if(product == null)
            {throw new IdNotFound("No products to show with this seller ID");}
        else
            {return (List<Product>) product;}
    }


}
