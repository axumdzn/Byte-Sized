package com.bytesize.service;

import com.bytesize.customExceptions.BadInput;
import com.bytesize.customExceptions.IdNotFound;
import com.bytesize.daos.RatingDAOImp;
import com.bytesize.entities.Rating;

import java.util.List;

public class RatingServiceImp implements RatingService{
    RatingDAOImp ratingDAOImp;

    public RatingServiceImp(RatingDAOImp ratingDAOImp){
        this.ratingDAOImp = ratingDAOImp;
    }
    @Override
    public Rating serviceCreateRating(Rating rating) {
        int rate = rating.getRate();
        String comment = rating.getComment();
        if(rate>5 || rate<1){
            throw new BadInput("Rating must be between 1 and 5");
        }
        else if(comment.length()>150){
            throw new BadInput("Comment too long");

        }
        else {
            return ratingDAOImp.createRating(rating);
        }
    }

    @Override
    public int serviceGetAverageRatingBySellerID(int id) {
        if(id<0){
            throw new IdNotFound("This id is not found");

        }
        else{
            return ratingDAOImp.getAverageRatingBySellerID(id);
        }
    }

    @Override
    public List<Rating> serviceGetAllRatingsById(int id) {
        if(id<0){
            throw new IdNotFound("This id is not found");

        }
        else{
            return ratingDAOImp.getAllRatingsById(id);
        }
    }
}
