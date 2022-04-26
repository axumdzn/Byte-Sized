import com.bytesize.customExceptions.IdNotFound;
import com.bytesize.daos.RatingDAOImp;
import com.bytesize.entities.Rating;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;

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

    @Test
    public void getAverageRatingBySellerIdSuccess(){
        int rate = ratingDAO.getAverageRatingBySellerID(2);
        Assert.assertTrue(rate <=5);
    }

    @Test
    public void getAllRatingByIdSuccess(){
        List<Rating> ratingList = ratingDAO.getAllRatingsById(2);
        Assert.assertTrue(ratingList.size()>0);
    }

    @Test(expectedExceptions = IdNotFound.class)
    public void getAllRatingByIdFailure(){
        List<Rating> ratingList = ratingDAO.getAllRatingsById(1);
    }
}
