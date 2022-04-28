package test_;

import com.bytesize.daos.MessageDAOImp;
import com.bytesize.entities.Message;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;

public class MessageDaoTests {
    MessageDAOImp MDI = new MessageDAOImp();

    @Test
    public void sendMessage() {
        Message message = new Message(1, 3, 2, "test", "hello");
        Message result = MDI.sendMessageDAO(message);
        Assert.assertEquals(result.getTitle(), "hello");
    }

    @Test
    public void getMessageById() {
        int id = 2;
        List<Message> result = MDI.getMessageById(id);
        Assert.assertEquals(result.get(0).getMessageId(), 3);
    }
}