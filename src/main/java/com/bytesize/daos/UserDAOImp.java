package com.bytesize.daos;
import com.bytesize.entities.User;
import com.bytesize.utils.DatabaseConnection;
import java.sql.*;

public class UserDAOImp implements UserDAO {
    @Override
    public User selectUserByLoginInfo(String userName, String passWord) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from users where username = ? and password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, passWord);
            ps.execute();

            ResultSet rs = ps.executeQuery();
            rs.next();

            User loginUser = new User(
                    rs.getInt("userid"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getBoolean("isBuyer"),
                    rs.getBoolean("isSeller")
                    );
            return loginUser;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User selectUserById(int id) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from users where userId= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

            ResultSet rs = ps.executeQuery();
            rs.next();

            User loginUser = new User(
                    rs.getInt("userid"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getBoolean("isBuyer"),
                    rs.getBoolean("isSeller")
            );
            return loginUser;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
