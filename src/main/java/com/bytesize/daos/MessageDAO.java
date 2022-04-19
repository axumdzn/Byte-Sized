package com.bytesize.daos;

import com.bytesize.entities.Message;
import com.bytesize.entities.User;

import java.sql.ResultSet;

public interface MessageDAO {
    Message sendMessageDAO(Message message);
}
