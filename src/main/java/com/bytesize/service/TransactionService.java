package com.bytesize.service;

import com.bytesize.entities.Transaction;

public interface TransactionService {

    Transaction serviceCreateTransaction(Transaction transaction);

    Transaction serviceGetTransactionInfo(int transactionId);
}
