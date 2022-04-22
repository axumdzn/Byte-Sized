package com.bytesize.service;

import com.bytesize.entities.Product;
import com.bytesize.daos.ProductDAO;
import com.bytesize.exceptions.IdNotFound;

import java.util.List;

public class ProductServiceImp implements ProductService
{

    public ProductDAO productDAO;

    public ProductServiceImp(ProductDAO productDAO)
    {
        this.productDAO = productDAO;
    }



    @Override
    public Product serviceDisplayProductByProductID(int productId)
    {
        Product product = productDAO.displayProductByProductID(productId);
        if(product == null)
            {throw new IdNotFound("No products to show with this ID");}
        else
            {return product;}
    }

    @Override
    public List<Product> serviceDisplayAllProductsBySellerId(int sellerId)
    {
        Product product = (Product) productDAO.displayAllProductsBySellerId(sellerId);
        if(product == null)
            {throw new IdNotFound("No products to show with this ID");}
        else
            {return (List<Product>) product;}
    }


}
