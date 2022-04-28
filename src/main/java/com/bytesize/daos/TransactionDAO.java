package com.bytesize.daos;

import com.bytesize.entities.Transaction;

import java.util.List;

public interface TransactionDAO {
    Transaction createTransaction(Transaction newTransaction);

    Transaction getTransactionInfo(int transactionId);

    Transaction updateTransactionStatus(int transactionId, String status);

    List<Transaction> getAllTransactionByBuyerId(int buyerId);
    List<Transaction> getAllTransactionByProductId(int productId);

}
