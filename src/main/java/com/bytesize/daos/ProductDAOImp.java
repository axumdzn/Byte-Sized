package com.bytesize.daos;

import com.bytesize.entities.Product;
import com.bytesize.exceptions.IdNotFound;
import com.bytesize.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImp implements ProductDAO{

    @Override
    public Product displayProductByProductID(int productId)
    {
        try(Connection connection = DatabaseConnection.createConnection())
        {
            String sql = "select * from products where productId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            //rs.next();
            if(!rs.next())
            {
                throw new IdNotFound("ID not found");
            }

            Product item = new Product(
                    rs.getInt("productId"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getFloat("price")
            );
            return item;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> displayAllProductsBySellerId(int sellerId)
    {
        try(Connection connection = DatabaseConnection.createConnection())
        {
            String sql = "select * from products where sellerId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, sellerId);
            ResultSet rs = ps.executeQuery();
            //rs.next();
            List<Product> products = new ArrayList<>();
            while(rs.next()){
                Product product = new Product(
                        rs.getInt("productId"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getFloat("price"),
                        rs.getInt("inventory"),
                        rs.getInt("sellerId")
                );
                products.add(product);
            }
            return products;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }


}
