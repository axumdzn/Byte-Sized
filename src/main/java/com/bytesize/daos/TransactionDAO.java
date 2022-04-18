package com.bytesize.daos;

import com.bytesize.entities.Transaction;

public interface TransactionDAO {
    Transaction createTransaction(Transaction newTransaction);

    Transaction getTransactionInfo(int transactionId);
}
