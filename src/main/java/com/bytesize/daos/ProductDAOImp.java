package com.bytesize.daos;
import com.bytesize.entities.Product;
import com.bytesize.entities.User;
import com.bytesize.utils.DatabaseConnection;

import java.sql.*;


public class ProductDAOImp implements ProductDAO {
    @Override
    public Product selectProductById(int id) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from product where product_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();

            ResultSet rs = ps.executeQuery();
            rs.next();
            Product product = new Product(
                    rs.getInt("product_id"),
                    rs.getString("title"),
                    rs.getFloat("price"),
                    rs.getInt("inventory"),
                    rs.getString("description"),
                    rs.getInt("user_id")
            );
            return product;
        }
        catch (Exception e){
        }
        return null;
    }

    @Override
    public int updateProductInfo(Product product) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "update product set title = ?, price = ?, description = ? where product_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, product.getTitle());
            ps.setFloat(2, product.getPrice());
            ps.setString(3, product.getDescription());
            ps.setInt(4, product.getProductId());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
