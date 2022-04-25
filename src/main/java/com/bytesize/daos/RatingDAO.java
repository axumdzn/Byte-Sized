package com.bytesize.daos;

import com.bytesize.entities.Rating;

import java.util.List;

public interface RatingDAO {

    Rating createRating(Rating newRating);
    int getAverageRatingBySellerID(int id);
    List<Rating> getAllRatingsById(int id);
}
