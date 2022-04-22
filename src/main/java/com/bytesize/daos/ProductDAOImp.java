package com.bytesize.daos;
import com.bytesize.entities.Product;
import com.bytesize.utils.DatabaseConnection;
import java.sql.*;

public class ProductDAOImp implements ProductDAO {

    @Override
    public int updateProductInfo(Product product) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "update products set title = ?, price = ?, description = ? where productid = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, product.getTitle());
            ps.setFloat(2, product.getPrice());
            ps.setString(3, product.getDescription());
            ps.setInt(4, product.getProductId());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}

