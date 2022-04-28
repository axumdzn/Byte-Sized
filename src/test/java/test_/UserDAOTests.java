package test_;

import com.bytesize.daos.UserDAOImp;
import com.bytesize.entities.User;
import org.testng.annotations.Test;
import org.testng.Assert;


public class UserDAOTests {
    public static UserDAOImp UDI = new UserDAOImp();
    public static User testUser;

    @Test
    public void selectUserByLoginInfoPositive() {
        User result = UDI.selectUserByLoginInfo("joejoe", "password");
        Assert.assertEquals(result.getUserId(), 2);
    }

    @Test
    public void selectUserByIdSuccess() {
        int id = 2;
        User result = UDI.selectUserById(id);
        Assert.assertEquals(result.getUserId(), 2);
    }
}