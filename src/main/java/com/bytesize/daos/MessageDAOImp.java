package com.bytesize.daos;

import java.sql.*;
import java.text.SimpleDateFormat;
import com.bytesize.daos.ProductDAO;
import com.bytesize.entities.Message;
import com.bytesize.entities.User;
import com.bytesize.utils.DatabaseConnection;


public class MessageDAOImp implements MessageDAO {
    @Override

    public Message sendMessageDAO(Message message) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "insert into message values(default, ?, ?, ? ,?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, message.getUserIdTo());
            ps.setString(2, message.getMessage());
            ps.setString(3, message.getUserNameFrom());
            ps.setInt(4, message.getUserId());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            message.setMessageId(rs.getInt("message_id"));
            return message;

        } catch (Exception e){
            System.out.println(e);
        }
            return null;
    }
    public static void main(String[] args){
        MessageDAOImp MDI = new MessageDAOImp();
        Message message = new Message(-1, -1,-2,"hello there","test1");
        Message result = MDI.sendMessageDAO(message);
        System.out.println(result);
    }
}
