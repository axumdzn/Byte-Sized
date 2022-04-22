package com.bytesize.daos;
import java.sql.*;
import com.bytesize.entities.Message;
import com.bytesize.utils.DatabaseConnection;

public class MessageDAOImp implements MessageDAO {
    @Override
    public Message sendMessageDAO(Message message) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "insert into messages values(default,?, default, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, message.getMessage());
            ps.setInt(2, message.getBuyerId());
            ps.setInt(3, message.getSellerId());
            ps.setInt(4, message.getSenderId());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            message.setMessageId(rs.getInt("messageid"));
            return message;

        } catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }
}
