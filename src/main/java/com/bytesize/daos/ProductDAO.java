package com.bytesize.daos;
import com.bytesize.entities.Product;
import java.util.List;

public interface ProductDAO
{
    String interfaceField = "this is my interface string";

    //displays one item by productid
    Product displayProductByProductID(int productId);

    //this is a linked list
    //displays all items by sellerid: seller may have a list of items
    List<Product> displayAllProductsBySellerId(int sellerId);


}
