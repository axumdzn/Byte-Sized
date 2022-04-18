package com.bytesize.service;

import com.bytesize.daos.TransactionDAOImp;
import com.bytesize.entities.Transaction;

public class TransactionServiceImp implements TransactionService{

    TransactionDAOImp  transactionDAOImp = new TransactionDAOImp();

    @Override
    public Transaction serviceCreateTransaction(Transaction transaction) {
        return null;
    }

    @Override
    public Transaction serviceGetTransactionInfo(int transactionId) {
        return null;
    }
}
