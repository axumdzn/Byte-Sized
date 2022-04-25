package com.bytesize.service;
import com.bytesize.customExceptions.BadInput;
import com.bytesize.customExceptions.UserNotFound;
import com.bytesize.daos.UserDAO;
import com.bytesize.daos.UserDAOImp;
import com.bytesize.entities.User;

public class UserServiceImp implements UserService {
    public UserDAO UD;

    public UserServiceImp(UserDAO UD) {
        this.UD = UD;
    }

    @Override
    public User login(String userName, String passWord) {
        if (userName.length() >= 20 || passWord.length() >= 20) {
            throw new BadInput("The input value should be less than 20");
        }
        User result = UD.selectUserByLoginInfo(userName, passWord);
        if (result == null){
            throw new UserNotFound("User not found");
        }
        return result;
    }
    public static void main(String[] args) {
        UserDAOImp UDI = new UserDAOImp();
        UserServiceImp USI = new UserServiceImp(UDI);
        User result = USI.login("joejoe", "password");
        System.out.println(result);
    }
}
