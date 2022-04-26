package com.bytesize.service;

import com.bytesize.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating serviceCreateRating(Rating rating);

    int serviceGetAverageRatingBySellerID(int id);
    List<Rating> serviceGetAllRatingsById(int id);
}
