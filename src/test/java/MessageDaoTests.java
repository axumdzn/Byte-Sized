import com.bytesize.daos.MessageDAOImp;
import com.bytesize.entities.Message;
import org.testng.annotations.Test;
import org.testng.Assert;

public class MessageDaoTests {
    MessageDAOImp MDI = new MessageDAOImp();

    @Test
    public void sendMessage() {
        Message message = new Message(-1, 1, 2, 1, "hello");
        Message result = MDI.sendMessageDAO(message);
        Assert.assertEquals(result.getBuyerId(), 1);
    }
}