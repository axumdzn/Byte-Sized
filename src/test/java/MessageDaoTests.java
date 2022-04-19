import com.bytesize.daos.MessageDAOImp;
import com.bytesize.entities.Message;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MessageDaoTests {
    MessageDAOImp MDI = new MessageDAOImp();

    @Test
    public void sendMessage() {
        Message message = new Message(-1, -1, -2, "hello there", "test1");
        Message result = MDI.sendMessageDAO(message);
        Assert.assertEquals(result.getUserId(), -1);
    }
}