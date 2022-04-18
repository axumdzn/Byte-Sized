import com.bytesize.daos.RatingDAOImp;
import com.bytesize.entities.Rating;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.sql.SQLException;

public class RatingDAOTests{
    RatingDAOImp ratingDAO = new RatingDAOImp();

    @Test
    public void createRatingSuccess(){
        Rating rating = new Rating(0,4,"very nice very quick",1,2);
        Rating result = ratingDAO.createRating(rating);
        Assert.assertEquals(result.getRate(),4);
    }
    @Test
    public void createRatingUniqueId(){
        Rating rating = new Rating(0,4,"very nice very quick",1,2);
        Rating result = ratingDAO.createRating(rating);
        Assert.assertNotEquals(result.getRatingId(),4);

    }
    @Test(expectedExceptions = SQLException.class)
    public void createRatingFail(){
        Rating rating = new Rating(0,4,"very nice very quick",-12,2);
        Rating result = ratingDAO.createRating(rating);
    }
}
