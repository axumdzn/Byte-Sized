package com.bytesize.app;

import com.bytesize.daos.TransactionDAOImp;
import com.bytesize.entities.Transaction;
import com.bytesize.service.TransactionServiceImp;
import com.google.gson.Gson;
import io.javalin.http.Handler;


public class TransactionController {

    TransactionServiceImp transactionServiceImp;
    TransactionDAOImp transactionDAOImp = new TransactionDAOImp();
    public TransactionController(){
        transactionServiceImp = new TransactionServiceImp(transactionDAOImp);
    }

    public Handler createTransaction = ctx -> {
        String body = ctx.body();
        Gson gson = new Gson();
        Transaction transaction = gson.fromJson(body, Transaction.class);
        System.out.println(transaction);
        Transaction result = transactionServiceImp.serviceCreateTransaction(transaction);
        String newBody = gson.toJson(result);
        ctx.result(newBody);
        ctx.status(200);
    };

    public Handler getTransactionInfo = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Transaction result = transactionServiceImp.serviceGetTransactionInfo(id);
        Gson gson = new Gson();
        String newBody = gson.toJson(result);
        ctx.result(newBody);
        ctx.status(200);

    };

    public Handler updateTransactionStatus = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        String status = ctx.pathParam("status");
        Transaction result  = transactionServiceImp.serviceUpdateTransactionStatus(id,status);
        Gson gson = new Gson();
        String newBody = gson.toJson(result);
        ctx.result(newBody);
        ctx.status(200);
    };
}
