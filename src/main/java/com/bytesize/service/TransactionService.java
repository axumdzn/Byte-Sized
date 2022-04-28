package com.bytesize.service;

import com.bytesize.entities.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction serviceCreateTransaction(Transaction transaction);

    Transaction serviceGetTransactionInfo(int transactionId);

    Transaction serviceUpdateTransactionStatus(int transactionId, String status);

    List<Transaction> serviceGetAllTransactionsByBuyerId(int buyerId);
    List<Transaction> serviceGetAllTransactionsByProductId(int productId);
}
