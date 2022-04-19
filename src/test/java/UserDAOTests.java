import com.bytesize.daos.UserDAOImp;
import com.bytesize.entities.User;
import org.testng.annotations.Test;
import org.testng.Assert;
import sun.rmi.server.UnicastServerRef2;


public class UserDAOTests {
    UserDAOImp UDI = new UserDAOImp();

    @Test
    public void selectUserByLoginInfoPositive() {
    User user = new User(-1, "test1","test11", true, false);
    User result = UDI.selectUserByLoginInfo(user);
    Assert.assertEquals(result.getUserId(), -1);
    }

}