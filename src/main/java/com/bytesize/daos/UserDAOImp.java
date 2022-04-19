package com.bytesize.daos;

import com.bytesize.entities.User;
import com.bytesize.utils.DatabaseConnection;

import java.sql.*;

public class UserDAOImp implements UserDAO {

    @Override
    public User selectUserByLoginInfo(User user) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from user_table where user_name = ? and user_password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassWord());
            ps.execute();

            ResultSet rs = ps.executeQuery();
            rs.next();
            User loginUser = new User(
                    rs.getInt("user_id"),
                    rs.getString("user_name"),
                    user.getUserName(),
                    user.isBuyer(),
                    user.isSeller()
            );
            return loginUser;

        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] agrs){
        UserDAOImp UDI = new UserDAOImp();
        User testUser = new User(-1, "test1", "test11", true, false);
        User result = UDI.selectUserByLoginInfo(testUser);
        System.out.println(result);
    }
    
}
