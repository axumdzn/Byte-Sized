package com.bytesize.daos;
import com.bytesize.entities.User;

public interface UserDAO {

    User selectUserByLoginInfo(String userName, String passWord);

}
