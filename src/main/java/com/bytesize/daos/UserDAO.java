package com.bytesize.daos;

import com.bytesize.entities.User;


public interface UserDAO {

    User selectUserByLoginInfo(User user);

}
