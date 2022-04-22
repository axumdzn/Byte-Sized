import com.bytesize.customExceptions.BadInput;
import com.bytesize.customExceptions.IdNotFound;
import com.bytesize.customExceptions.UserNotFound;
import com.bytesize.daos.MessageDAO;
import com.bytesize.daos.MessageDAOImp;
import com.bytesize.entities.Message;
import com.bytesize.service.MessageServiceImp;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MessageServiceTests {
    public static MessageServiceImp MSI;
    public static MessageDAO MD;
    public static Message testMessage;

    @BeforeClass
    public void setup(){
        MD = Mockito.mock(MessageDAOImp.class) ;
        MSI = new MessageServiceImp(MD);
    }
    @Test
    public void sendMessageSuccess() {
        testMessage = new Message(0,2, 1,1,"hahahaha");
        Mockito.doReturn(testMessage).when(MD).sendMessageDAO(testMessage);
        Message result = MSI.sendMessage(testMessage);
        Assert.assertEquals(result.getMessageId(), 0);
    }

    @Test(expectedExceptions = UserNotFound.class, expectedExceptionsMessageRegExp = "User id not found")
    public void sendMessageWrongIdNegative() {
        testMessage = new Message(0,2, 1,1,"hahahaha");
        Mockito.doReturn(null).when(MD).sendMessageDAO(testMessage);
        MSI.sendMessage(testMessage);

    }
    @Test(expectedExceptions = BadInput.class, expectedExceptionsMessageRegExp = "The input value should be less than 250")
    public void sendMessageMessageLengthSuccess() {
        String testMessages = "haha";
        while (testMessages.length() < 251) {
            testMessages = testMessages.concat("haha");
        }
        testMessage = new Message(0,2, 1,1,testMessages);
        MSI.sendMessage(testMessage);
    }
}
