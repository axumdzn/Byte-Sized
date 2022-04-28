package com.bytesize.service;

import com.bytesize.entities.User;

public interface UserService {
    User login(String userName, String passWord);

    User serviceSelectUserById(int id);
}
