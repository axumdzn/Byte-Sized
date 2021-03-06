package com.bytesize.service;

import com.bytesize.customExceptions.BadInput;
import com.bytesize.customExceptions.IdNotFound;
import com.bytesize.daos.TransactionDAOImp;
import com.bytesize.entities.Transaction;

import java.util.List;

public class TransactionServiceImp implements TransactionService{

    TransactionDAOImp  transactionDAOImp;

    public TransactionServiceImp(TransactionDAOImp transactionDAOImp){

        this.transactionDAOImp = transactionDAOImp;
    }

    @Override
    public Transaction serviceCreateTransaction(Transaction transaction) {
        String status = transaction.getStatus();
        int transactionId = transaction.getTransactionId();
        if(!status.matches("pending|shipped|delivered")){
            throw new BadInput("Wrong status entered");
        }
        if(transactionId<=0){
            throw new IdNotFound("Wrong Id entered");
        }
        return transactionDAOImp.createTransaction(transaction);
    }

    @Override
    public Transaction serviceGetTransactionInfo(int transactionId) {
        if(transactionId<=0){
            throw new IdNotFound("Wrong Id entered");
        }
        return transactionDAOImp.getTransactionInfo(transactionId);
    }

    @Override
    public Transaction serviceUpdateTransactionStatus(int transactionId, String status) {
        if(!status.matches("pending|shipped|delivered")){
            throw new BadInput("Wrong status entered");
        }
        if(transactionId<=0){
            throw new IdNotFound("Wrong Id entered");
        }
        return transactionDAOImp.updateTransactionStatus(transactionId, status);
    }

    @Override
    public List<Transaction> serviceGetAllTransactionsByBuyerId(int buyerId) {
        if(buyerId<=0){
            throw new IdNotFound("Wrong Id entered");
        }
        return transactionDAOImp.getAllTransactionByBuyerId(buyerId);
    }

    @Override
    public List<Transaction> serviceGetAllTransactionsByProductId(int productId) {
        if(productId<=0){
            throw new IdNotFound("Wrong Id entered");
        }
        return transactionDAOImp.getAllTransactionByProductId(productId);
    }
}
