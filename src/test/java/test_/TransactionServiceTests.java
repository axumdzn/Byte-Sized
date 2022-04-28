package test_;

import com.bytesize.customExceptions.BadInput;
import com.bytesize.customExceptions.IdNotFound;
import com.bytesize.daos.TransactionDAOImp;
import com.bytesize.entities.Transaction;
import com.bytesize.service.TransactionServiceImp;
import kotlin.collections.ArrayDeque;
import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class TransactionServiceTests {
    TransactionDAOImp transactionDAOImp;
    TransactionServiceImp transactionServiceImp;
    List<Transaction> testTransactionlist;
    @BeforeClass
    public void setup() {
        transactionDAOImp = Mockito.mock(TransactionDAOImp.class);
        transactionServiceImp = new TransactionServiceImp(transactionDAOImp);
        List<Transaction> testTransactionlist = new ArrayList<>();
        Transaction testTransaction = new Transaction(1, 300, "shipped", 1, 1);
        testTransactionlist.add(testTransaction);


    }

    @Test(expectedExceptions = BadInput.class, expectedExceptionsMessageRegExp = "Wrong status entered")
    public void serviceCreateTransactionStatusCheck() {
        Transaction transaction = new Transaction(1, 200, "living", 1, 1);
        Transaction result = transactionServiceImp.serviceCreateTransaction(transaction);
    }

    @Test
    public void serviceCreateTransactionMockSuccess() {
        Transaction transaction = new Transaction(1, 200, "shipped", 1, 1);
        Mockito.doReturn(new Transaction(1, 300, "pending", 1, 1)).when(transactionDAOImp).createTransaction(transaction);
        Transaction result = transactionServiceImp.serviceCreateTransaction(transaction);
        Assert.assertEquals(result.getAmount(), 300);
    }

    @Test(expectedExceptions = BadInput.class)
    public void serviceCreateTransactionMockFailure() {
        Transaction transaction = new Transaction(1, 200, "living", 1, 1);
        Mockito.doThrow(new BadInput("Some sql exception")).when(transactionDAOImp).createTransaction(transaction);
        Transaction result = transactionServiceImp.serviceCreateTransaction(transaction);
    }


    @Test(expectedExceptions = IdNotFound.class, expectedExceptionsMessageRegExp = "Wrong Id entered")
    public void serviceGetTransactionInfoFailure() {
        Transaction result = transactionServiceImp.serviceGetTransactionInfo(-1);
    }

    @Test
    public void serviceGetTransactionInfoMockSuccess() {
        Mockito.doReturn(new Transaction(1, 300, "pending", 1, 1)).when(transactionDAOImp).getTransactionInfo(1);
        Transaction result = transactionServiceImp.serviceGetTransactionInfo(1);
        Assert.assertEquals(result.getAmount(), 300);

    }

    @Test(expectedExceptions = BadInput.class)
    public void serviceGetTransactionInfoMockFailure() {
        Mockito.doThrow(new BadInput("Some sql exception")).when(transactionDAOImp).getTransactionInfo(1);
        Transaction result = transactionServiceImp.serviceGetTransactionInfo(1);

    }

    @Test(expectedExceptions = BadInput.class, expectedExceptionsMessageRegExp = "Wrong status entered")
    public void serviceUpdateTransactionStatusStatusCheck() {
        Transaction result = transactionServiceImp.serviceUpdateTransactionStatus(1, "dying");
    }

    @Test
    public void serviceUpdateTransactionStatusMockSuccess() {
        Mockito.doReturn(new Transaction(1, 300, "delivered", 1, 1)).when(transactionDAOImp).updateTransactionStatus(1, "pending");
        Transaction result = transactionServiceImp.serviceUpdateTransactionStatus(1, "pending");
        Assert.assertEquals(result.getStatus(), "delivered");

    }

    @Test(expectedExceptions = BadInput.class)
    public void serviceUpdateTransactionStatusMockFailure() {
        Mockito.doThrow(new BadInput("Some sql error")).when(transactionDAOImp).updateTransactionStatus(1, "shipped");
        Transaction result = transactionServiceImp.serviceUpdateTransactionStatus(1, "shipped");
    }

    @Test
    public void serviceGetAllTransactionsByBuyerIdSuccess(){
        List<Transaction> testTransactionlist = new ArrayList<>();
        Transaction testTransaction = new Transaction(1, 300, "shipped", 1, 1);
        testTransactionlist.add(testTransaction);

        Mockito.doReturn(testTransactionlist).when(transactionDAOImp).getAllTransactionByBuyerId(1);
        List<Transaction> result = transactionServiceImp.serviceGetAllTransactionsByBuyerId(1);
        Assert.assertEquals(result.get(0).getStatus(), "shipped");
    }

    @Test(expectedExceptions = IdNotFound.class, expectedExceptionsMessageRegExp = "Wrong Id entered")
    public void serviceGetAllTransactionsByBuyerIdNegative() {
        transactionServiceImp.serviceGetAllTransactionsByBuyerId(-1);
    }

    @Test
    public void serviceGetAllTransactionsByProductIdSuccess() {
        List<Transaction> testTransactionlist = new ArrayList<>();
        Transaction testTransaction = new Transaction(1, 300, "shipped", 1, 1);
        testTransactionlist.add(testTransaction);

        Mockito.doReturn(testTransactionlist).when(transactionDAOImp).getAllTransactionByProductId(1);
        List<Transaction> result = transactionServiceImp.serviceGetAllTransactionsByProductId(1);
        Assert.assertEquals(result.get(0).getStatus(), "shipped");
    }

    @Test(expectedExceptions = IdNotFound.class, expectedExceptionsMessageRegExp = "Wrong Id entered")
    public void serviceGetAllTransactionsByProductIdNegative() {
        transactionServiceImp.serviceGetAllTransactionsByProductId(-1);
    }

}
