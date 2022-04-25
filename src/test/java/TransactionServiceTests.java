import com.bytesize.customExceptions.BadInput;
import com.bytesize.customExceptions.IdNotFound;
import com.bytesize.daos.TransactionDAOImp;
import com.bytesize.entities.Transaction;
import com.bytesize.service.TransactionServiceImp;
import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.sql.SQLException;

public class TransactionServiceTests {
    TransactionDAOImp transactionDAOImp;
    TransactionServiceImp transactionServiceImp;
    @BeforeClass
    public void setup(){
       transactionDAOImp = Mockito.mock(TransactionDAOImp.class);
       transactionServiceImp = new TransactionServiceImp(transactionDAOImp);
    }


    @Test
    public void serviceCreateTransactionSuccess(){
    Transaction transaction = new Transaction(1, 200, "pending",4,1);
    Transaction result = transactionServiceImp.serviceCreateTransaction(transaction);
    Assert.assertEquals(result.getAmount(), 200);
    }
    @Test(expectedExceptions = BadInput.class, expectedExceptionsMessageRegExp = "Wrong status entered")
    public void serviceCreateTransactionStatusCheck(){
        Transaction transaction = new Transaction(1, 200, "living",1,1);
        Transaction result = transactionServiceImp.serviceCreateTransaction(transaction);
    }
    @Test
    public void serviceCreateTransactionMockSuccess(){
        Transaction transaction = new Transaction(1, 200, "shipped",1,1);
        Mockito.doReturn(new Transaction(1, 300, "pending", 1, 1)).when(transactionDAOImp).createTransaction(transaction);
        Transaction result = transactionServiceImp.serviceCreateTransaction(transaction);
        Assert.assertEquals(result.getAmount(), 300);
        }
    @Test(expectedExceptions = BadInput.class)
    public void serviceCreateTransactionMockFailure(){
        Transaction transaction = new Transaction(1, 200, "living",1,1);
        Mockito.doThrow(new BadInput("Some sql exception")).when(transactionDAOImp).createTransaction(transaction);
        Transaction result = transactionServiceImp.serviceCreateTransaction(transaction);

    }
    @Test
    public void serviceGetTransactionInfoSuccess(){
        Transaction result = transactionServiceImp.serviceGetTransactionInfo(4);
        Assert.assertEquals(result.getTransactionId(), 4);
    }
    @Test(expectedExceptions = IdNotFound.class, expectedExceptionsMessageRegExp = "Wrong Id entered")
    public void serviceGetTransactionInfoFailure(){
        Transaction result = transactionServiceImp.serviceGetTransactionInfo(-1);
    }
    @Test
    public void serviceGetTransactionInfoMockSuccess(){
        Mockito.doReturn(new Transaction(1, 300, "pending", 1, 1)).when(transactionDAOImp).getTransactionInfo(1);
        Transaction result = transactionServiceImp.serviceGetTransactionInfo(1);
        Assert.assertEquals(result.getAmount(),300);

    }
    @Test(expectedExceptions = BadInput.class)
    public void serviceGetTransactionInfoMockFailure(){
        Mockito.doThrow(new BadInput("Some sql exception")).when(transactionDAOImp).getTransactionInfo(1);
        Transaction result = transactionServiceImp.serviceGetTransactionInfo(1);

    }
    @Test
    public void serviceUpdateTransactionStatusSuccess(){
        Transaction result = transactionServiceImp.serviceUpdateTransactionStatus(5,"shipped");
        Assert.assertEquals(result.getStatus(),"shipped");
    }
    @Test(expectedExceptions = BadInput.class, expectedExceptionsMessageRegExp = "Wrong status entered")
    public void serviceUpdateTransactionStatusStatusCheck(){
        Transaction result = transactionServiceImp.serviceUpdateTransactionStatus(1,"dying");
    }
    @Test
    public void serviceUpdateTransactionStatusMockSuccess(){
        Mockito.doReturn(new Transaction(1, 300, "delivered", 1, 1)).when(transactionDAOImp).updateTransactionStatus(1,"pending");
        Transaction result = transactionServiceImp.serviceUpdateTransactionStatus(1,"pending");
        Assert.assertEquals(result.getStatus(), "delivered");

    }
    @Test(expectedExceptions = BadInput.class)
    public void serviceUpdateTransactionStatusMockFailure(){
        Mockito.doThrow(new BadInput("Some sql error")).when(transactionDAOImp).updateTransactionStatus(1,"shipped");
        Transaction result = transactionServiceImp.serviceUpdateTransactionStatus(1, "shipped");
    }
}
