package com.bytesize.daos;

import com.bytesize.entities.Rating;
import com.bytesize.utils.DatabaseConnection;

import java.sql.*;

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
}
