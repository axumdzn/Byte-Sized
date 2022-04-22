import com.bytesize.customExceptions.UserNotFound;
import com.bytesize.daos.UserDAOImp;
import com.bytesize.entities.User;
import org.testng.annotations.Test;
import org.testng.Assert;
import sun.rmi.server.UnicastServerRef2;


public class UserDAOTests {
    public static UserDAOImp UDI = new UserDAOImp();
    public static User testUser;

    @Test
    public void selectUserByLoginInfoPositive() {
        User user = new User(2, "joejoe", "password", true, false);
        User result = UDI.selectUserByLoginInfo("joejoe", "password");
        Assert.assertEquals(result.getUserId(), 2);
    }

//    @Test(expectedExceptions = UserNotFound.class, expectedExceptionsMessageRegExp = "User not found")
//    public void loginTestNoUserNegative() {
//        testUser = new User(0, "Imnotauser", "Imtrulynot", true, false);
//        UDI.selectUserByLoginInfo(testUser.getUserName(), testUser.getPassWord());
//    }
}