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

import java.util.ArrayList;
import java.util.List;

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
        testMessage = new Message(1, 3, 2, "test", "hello");
        Mockito.doReturn(testMessage).when(MD).sendMessageDAO(testMessage);
        Message result = MSI.sendMessage(testMessage);
        Assert.assertEquals(result.getMessageId(), 1);
    }

    @Test(expectedExceptions = UserNotFound.class, expectedExceptionsMessageRegExp = "User id not found")
    public void sendMessageWrongIdNegative() {
        testMessage = new Message(1, 3, 200, "test", "hello");
        Mockito.doReturn(null).when(MD).sendMessageDAO(testMessage);
        MSI.sendMessage(testMessage);

    }
    @Test(expectedExceptions = BadInput.class, expectedExceptionsMessageRegExp = "The input message should be less than 250")
    public void sendMessageMessageLengthNegative() {
        String testMessages = "haha";
        while (testMessages.length() < 251) {
            testMessages = testMessages.concat("haha");
        }
        testMessage = new Message(1, 3, 2, testMessages, "hello");
        MSI.sendMessage(testMessage);
    }
    @Test(expectedExceptions = BadInput.class, expectedExceptionsMessageRegExp = "The input title should be less than 100")
    public void sendMessageTitleLengthNegative() {
        String testMessages = "haha";
        while (testMessages.length() < 100) {
            testMessages = testMessages.concat("haha");
        }
        testMessage = new Message(1, 3, 2, "test", testMessages);
        MSI.sendMessage(testMessage);
    }
    @Test
    public void getMessagesByIdSuccess() {
        int id = 2;
        List<Message> testMessageList = new ArrayList<>();
        testMessage = new Message(1, 3, 2, "test", "s");
        testMessageList.add(testMessage);

        Mockito.doReturn(testMessageList).when(MD).getMessageById(id);
        List<Message> result = MSI.getMessagesById(2);
        Assert.assertEquals(result.get(0).getMessageId(), 1);
    }

    @Test(expectedExceptions = UserNotFound.class, expectedExceptionsMessageRegExp = "User id not found")
    public void getMessagesByIdNoUserIdNegative() {
        int id = 2;
        List<Message> testMessageList = new ArrayList<>();
        Mockito.doReturn(testMessageList).when(MD).getMessageById(id);
        MSI.getMessagesById(2);
    }
}
