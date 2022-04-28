package com.bytesize.app;

import com.bytesize.daos.RatingDAOImp;
import com.bytesize.entities.Rating;
import com.bytesize.service.RatingServiceImp;
import com.google.gson.Gson;
import io.javalin.http.Handler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class RatingController {
    public static Logger logger = LogManager.getLogger(TransactionController.class);

    RatingDAOImp ratingDAOImp = new RatingDAOImp();
    RatingServiceImp ratingServiceImp = new RatingServiceImp(ratingDAOImp);

    public Handler createRating = ctx -> {
        String body = ctx.body();
        Gson gson = new Gson();
        Rating rating = gson.fromJson(body, Rating.class);
        Rating result = ratingServiceImp.serviceCreateRating(rating);
        String newBody = gson.toJson(result);
        ctx.result(newBody);
        ctx.status(200);
    };
    public Handler getAverageRating = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        int result = ratingServiceImp.serviceGetAverageRatingBySellerID(id);
        if(result == 0){
            ctx.result("Failed to get rating");
            ctx.status(400);
        }
        else {
            logger.info("result is " + result);
            Gson gson = new Gson();
            String body = gson.toJson(result);
            ctx.result(body);
            ctx.status(200);
        }
    };
    public Handler getAllRatings = ctx ->{
        int id = Integer.parseInt(ctx.pathParam("id"));
        List<Rating> result = ratingServiceImp.serviceGetAllRatingsById(id);
        logger.info("result is " + result);
        if(result.size() == 0){
            ctx.result("No Ratings found");
            ctx.status(400);
        }
        else{
            Gson gson = new Gson();
            String body = gson.toJson(result);
            ctx.result(body);
            ctx.status(200);
        }

    };
}
