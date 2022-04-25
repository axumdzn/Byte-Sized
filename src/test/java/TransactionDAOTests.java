import com.bytesize.daos.TransactionDAOImp;
import com.bytesize.entities.Transaction;
import org.testng.annotations.Test;
import org.testng.Assert;



public class TransactionDAOTests {

    TransactionDAOImp transactionDAO = new TransactionDAOImp();

    @Test
    public void createTransactionSuccess(){
        Transaction transaction = new Transaction(0, 24, "Processing",9,1);
        Transaction result = transactionDAO.createTransaction(transaction);
        Assert.assertEquals(result.getAmount(),24);
    }

    @Test
    public void createTransactionUniqueId(){
        Transaction transaction = new Transaction(0, 24, "Processing",9,1);
        Transaction result = transactionDAO.createTransaction(transaction);
        Assert.assertTrue(result.getTransactionId()!=0);
    }

    @Test
    public void getTransactionInfoSuccess(){
        Transaction result = transactionDAO.getTransactionInfo(3);
        Assert.assertEquals(result.getTransactionId(),3);
    }

    @Test
    public void updateTransactionSuccess(){
        Transaction result = transactionDAO.updateTransactionStatus(3, "Shipping");
        Assert.assertEquals(result.getStatus(),"Shipping");
    }


}
