package com.bytesize.daos;

import com.bytesize.customExceptions.BadInput;
import com.bytesize.customExceptions.IdNotFound;
import com.bytesize.entities.Rating;
import com.bytesize.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RatingDAOImp implements RatingDAO{
    @Override
    public Rating createRating(Rating newRating) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "insert into ratings values(default, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,newRating.getRate());
            ps.setString(2,newRating.getComment());
            ps.setInt(3,newRating.getBuyerId());
            ps.setInt(4,newRating.getSellerId());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            newRating.setRatingId(rs.getInt("ratingId"));
            return newRating;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getAverageRatingBySellerID(int id) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select avg(rate) from ratings where sellerId = ?";
            PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id);
            ps.execute();
            ResultSet rs = ps.executeQuery();
            if(rs.next()==false) {
                throw new BadInput("No rating found");
            }
            else{
                int result = rs.getInt(1);
                return result;
            }

        }
        catch(SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Rating> getAllRatingsById(int id) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from ratings where sellerID = ?";
            PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            List<Rating> ratings = new ArrayList<>();
            while(rs.next()){
                Rating rating = new Rating(rs.getInt("ratingId"),rs.getInt("rate"),rs.getString("comment"),
                        rs.getInt("buyerId"),rs.getInt("sellerID"));
                ratings.add(rating);
            };
            if(ratings.size()==0){
                throw new IdNotFound("No rating found with this id");
            }
            return ratings;


        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
