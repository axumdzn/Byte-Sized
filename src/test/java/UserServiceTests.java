import com.bytesize.customExceptions.BadInput;
import com.bytesize.customExceptions.UserNotFound;
import com.bytesize.daos.UserDAOImp;
import com.bytesize.entities.User;
import com.bytesize.service.UserServiceImp;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.mockito.Mockito;
import org.testng.annotations.Test;

public class UserServiceTests {
    public UserServiceImp USI;
    public UserDAOImp UDI;
    public static User testUser;

    @BeforeClass
    public void setup() {
        UDI = Mockito.mock(UserDAOImp.class);
        USI = new UserServiceImp(UDI);
    }
    @Test
    public void loginTestSuccess() {
        testUser = new User(2, "joejoe", "password", true, false);
        Mockito.doReturn(testUser).when(UDI).selectUserByLoginInfo(testUser.getUserName(), testUser.getPassWord());
        User result = USI.login(testUser.getUserName(), testUser.getPassWord());
        Assert.assertEquals(result.getUserName(), "joejoe");
    }

    @Test(expectedExceptions = BadInput.class, expectedExceptionsMessageRegExp = "The input value should be less than 20")
    public void loginTestLoginanmeNegative() {
        testUser = new User(0, "tooooooolooooongnaaaaaaameeeee", "test1", true, false);
        USI.login(testUser.getUserName(), testUser.getPassWord());
    }

    @Test(expectedExceptions = BadInput.class, expectedExceptionsMessageRegExp = "The input value should be less than 20")
    public void loginTestLoginpasswordNegative() {
        testUser = new User(0, "test", "tooooooooowroooooooongpaaaaaaswoooooord", true, false);
        USI.login(testUser.getUserName(), testUser.getPassWord());
    }

    @Test(expectedExceptions = UserNotFound.class, expectedExceptionsMessageRegExp = "User not found")
    public void loginTestNoUser() {
        testUser = new User(0, "Imnotauser", "Imtrulynot", true, false);
        USI.login(testUser.getUserName(), testUser.getPassWord());
    }
}