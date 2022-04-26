import com.bytesize.customExceptions.BadInput;
import com.bytesize.customExceptions.IdNotFound;
import com.bytesize.daos.RatingDAOImp;
import com.bytesize.entities.Rating;
import com.bytesize.service.RatingServiceImp;
import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;


import java.util.ArrayList;
import java.util.List;

public class RatingServiceTests {
    RatingDAOImp ratingDAOImp;
    RatingServiceImp ratingServiceImp;
    @BeforeClass
    public void setup(){
        ratingDAOImp = Mockito.mock(RatingDAOImp.class);
        ratingServiceImp= new RatingServiceImp(ratingDAOImp);
    }
    @Test
    public void serviceCreateRatingSuccess(){
        Rating rating = new Rating(0,4,"was very nice",1,2);
        Rating result = ratingServiceImp.serviceCreateRating(rating);
        Assert.assertEquals(result.getRate(),4);
    }
    @Test(expectedExceptions = BadInput.class, expectedExceptionsMessageRegExp = "Rating must be between 1 and 5")
    public void serviceCreateRatingRateInvalid(){
        Rating rating = new Rating(0,6,"was very nice",1,2);
        Rating result = ratingServiceImp.serviceCreateRating(rating);
    }
    @Test(expectedExceptions = BadInput.class,expectedExceptionsMessageRegExp = "Comment too long")
    public void serviceCreateRatingCommentLength(){
        Rating rating = new Rating(0,4,"was very ndfhjgasgdfjkshagdfkjhasgdfkjhasgdfkjhasgdfkjhsdgakjfhfgasjkdfhgfaskjdhfgkajshdgfjkasdhgfjkashdgficekjsahgkjahsgdfjkasgdjasjhdgfajkshdfgkjashdgfjkhasdgfkjashdgfkjashdghxkljfhsajlkdfjhaslkdjfhlaksjdhflksajdhfkljsak",1,2);
        Rating result = ratingServiceImp.serviceCreateRating(rating);}
    @Test
    public void serviceCreateRatingMockSuccess(){
        Rating rating = new Rating(0,4,"was very nice",1,2);
        Rating mock = new Rating(3,3,"lovely ppl",1,2);
        Mockito.doReturn(mock).when(ratingDAOImp).createRating(rating);
        Rating result = ratingServiceImp.serviceCreateRating(rating);
        Assert.assertEquals(result.getRate(),3);
    }
    @Test(expectedExceptions = BadInput.class)
    public void serviceCreateRatingMockFailure(){
        Rating rating = new Rating(0,4,"was very nice",1,2);
        Mockito.doThrow(new BadInput("Some sql exception")).when(ratingDAOImp).createRating(rating);
        Rating result = ratingServiceImp.serviceCreateRating(rating);
    }
    @Test
    public void serviceGetAverageSuccess(){
        int result = ratingServiceImp.serviceGetAverageRatingBySellerID(2);
        Assert.assertTrue(result<=5);
    }
    @Test(expectedExceptions = IdNotFound.class,expectedExceptionsMessageRegExp = "This id is not found")
    public void serviceGetAverageIdError(){

        int result = ratingServiceImp.serviceGetAverageRatingBySellerID(-1);
    }
    @Test
    public void serviceGetAverageMockSuccess(){
        Mockito.doReturn(4).when(ratingDAOImp).getAverageRatingBySellerID(2);
        int result = ratingServiceImp.serviceGetAverageRatingBySellerID(2);
        Assert.assertEquals(result, 4);
    }
    @Test(expectedExceptions = BadInput.class)
    public void serviceGetAverageMockFailure(){
        Mockito.doThrow(new BadInput("some error")).when(ratingDAOImp).getAverageRatingBySellerID(2);
        int result = ratingServiceImp.serviceGetAverageRatingBySellerID(2);
    }
    @Test
    public void serviceGetAllSuccess(){
        List<Rating> result = ratingServiceImp.serviceGetAllRatingsById(2);
        Assert.assertTrue(result.size()>0);
    }
    @Test(expectedExceptions = IdNotFound.class,expectedExceptionsMessageRegExp = "This id is not found")
    public void serviceGetAllIdError(){
        List<Rating> result = ratingServiceImp.serviceGetAllRatingsById(-2);

    }
    @Test
    public void serviceGetAllMockSuccess(){
        List<Rating> ratingList = new ArrayList<>();
        ratingList.add(new Rating(1,2,"please be me",1,2));
        Mockito.doReturn(ratingList).when(ratingDAOImp).getAllRatingsById(2);
        List<Rating> result = ratingServiceImp.serviceGetAllRatingsById(2);
        Assert.assertTrue(result.size()>0);
    }
    @Test(expectedExceptions = BadInput.class)
    public void serviceGetAllMockFailure(){
        Mockito.doThrow(new BadInput("some exception")).when(ratingDAOImp).getAllRatingsById(35);
        List<Rating> ratingList = ratingServiceImp.serviceGetAllRatingsById(35);
    }
}
