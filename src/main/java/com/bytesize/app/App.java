package com.bytesize.app;

import io.javalin.Javalin;

public class App {

    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
           config.enableCorsForAllOrigins();
           config.enableDevLogging();
        });

        TransactionController transactionController = new TransactionController();
        RatingController ratingController = new RatingController();

        app.post("/api/transaction",transactionController.createTransaction);
        app.get("/api/transaction/{id}",transactionController.getTransactionInfo);
        app.put("/api/transaction/{id}/{status}", transactionController.updateTransactionStatus);
        app.post("/api/rating", ratingController.createRating);
        app.get("/api/rating/average/{id}", ratingController.getAverageRating);
        app.get("/api/rating/{id}", ratingController.getAllRatings);
        app.start();
    }
}
