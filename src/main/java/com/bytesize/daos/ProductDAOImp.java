package com.bytesize.daos;
import com.bytesize.entities.Product;
import com.bytesize.exceptions.IdNotFound;
import com.bytesize.utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public class ProductDAOImp implements ProductDAO {

    @Override
    public Product createProduct(Product Product) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "insert into products values(default, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, Product.getTitle());
            ps.setString(2, Product.getDescription());
            ps.setFloat(3, Product.getPrice());
            ps.setInt(4, Product.getInventory());
            ps.setInt(5, Product.getSellerId());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            Product.setProductId(rs.getInt("productId"));
            return Product;

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public Product selectProductById(int id) {

        try(Connection connection = DatabaseConnection.createConnection()) {
            String sql = "select * from products where productId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Product product = new Product(
                    rs.getInt("productId"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getFloat("price"),
                    rs.getInt("inventory"),
                    rs.getInt("sellerId")
            );

        return product;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Product> selectAllProducts() {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from products";
            Statement s = connection.createStatement();
            s.execute(sql);
            ResultSet rs = s.getResultSet();
            ArrayList<Product> products = new ArrayList<>();
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

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int removeProductById(int id) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "delete from products where productId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int updateProductById(Product product) {
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
    public static void  main (String[] args){
        ProductDAOImp PDI = new ProductDAOImp();
        ArrayList<Product> result = PDI.selectAllProducts();
        System.out.println(result.toString());
    }
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
                    rs.getFloat("price"),
                    rs.getInt("inventory"),
                    rs.getInt("sellerId")
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
    public List<Product> displayAllProductsBySellerId(int sellerId) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "select * from products where sellerId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, sellerId);
            ResultSet rs = ps.executeQuery();
            //rs.next();
            List<Product> products = new ArrayList<>();
            while (rs.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
