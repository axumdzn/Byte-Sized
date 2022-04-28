package com.bytesize.app;

import com.bytesize.daos.TransactionDAOImp;
import com.bytesize.entities.Transaction;
import com.bytesize.service.TransactionServiceImp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import io.javalin.http.Handler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.tree.TreeNode;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class TransactionController {

    public static Logger logger = LogManager.getLogger(TransactionController.class);
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

    public Handler getAllTransactionsByBuyerId = ctx -> {
        try{

        int id = Integer.parseInt(ctx.pathParam("id"));
        List<Transaction> result = transactionServiceImp.serviceGetAllTransactionsByBuyerId(id);
        Gson gson = new Gson();
        logger.info("sending back info " + result);
        String newBody = gson.toJson(result);
        logger.info("sending back info " + newBody);
        ctx.result(newBody);
        ctx.status(200);
        } catch(Exception e){
            e.printStackTrace();
        }
    };
    public Handler getAllTransactionsByProductId = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        List<Transaction> result = transactionServiceImp.serviceGetAllTransactionsByProductId(id);
        Gson gson = new Gson();
        logger.info("info sent: " + result);
        String newBody = gson.toJson(result);
        logger.info("info sent: " + newBody);
        ctx.result(newBody);
        ctx.status(200);
    };
}
