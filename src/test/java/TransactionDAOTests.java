import com.bytesize.daos.TransactionDAOImp;
import com.bytesize.entities.Transaction;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.sql.SQLDataException;
import java.sql.SQLException;

public class TransactionDAOTests {

    TransactionDAOImp transactionDAO = new TransactionDAOImp();

    @Test
    public void createTransactionSuccess(){
        Transaction transaction = new Transaction(0, 24, "L", "Processing",1,1);
        Transaction result = transactionDAO.createTransaction(transaction);
        Assert.assertEquals(result.getAmount(),24);
    }

    @Test
    public void createTransactionUniqueId(){
        Transaction transaction = new Transaction(0, 24, "L", "Processing",1,1);
        Transaction result = transactionDAO.createTransaction(transaction);
        Assert.assertTrue(result.getTransactionId()!=0);
    }
    @Test(expectedExceptions = SQLException.class)
    public void createTransactionFail(){
        Transaction transaction = new Transaction(0, 24, "l", "Processing",-23,1);
        Transaction result = transactionDAO.createTransaction(transaction);
        Assert.fail();
    }

    @Test
    public void getTransactionInfoSuccess(){
        Transaction result = transactionDAO.getTransactionInfo(1);
        Assert.assertEquals(result.getTransactionId(),1);
    }

    @Test(expectedExceptions = SQLDataException.class)
    public void getTransactionInfoFail(){
            Transaction result = transactionDAO.getTransactionInfo(-1);
            Assert.fail();

    }
}
