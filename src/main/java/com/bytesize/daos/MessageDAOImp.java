package com.bytesize.daos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bytesize.customExceptions.UserNotFound;
import com.bytesize.entities.Message;
import com.bytesize.utils.DatabaseConnection;

public class MessageDAOImp implements MessageDAO {
    @Override
    public Message sendMessageDAO(Message message) {
        try (Connection connection = DatabaseConnection.createConnection()) {
//            insert into messages1 values(default, idto 1, title 'food', message 'too expensive',default, idfrome);
            String sql = "insert into messages1 values(default,? ,?, ?, default, ?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, message.getIdTo());
            ps.setString(2, message.getTitle());
            ps.setString(3, message.getMessage());
            ps.setInt(4, message.getIdFrom());
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


    @Override
    public List<Message> getMessageById(int id) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "SELECT messageid, userid, username, title, message, date from users join messages1 on idfrom = userid where idto = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            List<Message> messages = new ArrayList<>();
            while(rs.next()){
                Message message = new Message(
                       rs.getInt("messageid"),
                        rs.getInt("userid"),
                        id,
                        rs.getString("message"),
                        rs.getString("title")
                );
                message.setNameFrom(rs.getString("username"));
                message.setDateCreated(rs.getDate("date"));
                messages.add(message);
            }
            return messages;

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}

