import com.bytesize.daos.ProductDAO;
import com.bytesize.daos.ProductDAOImp;
import com.bytesize.entities.Product;
import com.bytesize.service.ProductServiceImp;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


public class ProductDAOTests
{
    ProductDAOImp productDAOImpObject = new ProductDAOImp();

    public static ProductDAOImp productDAOImp;

    @BeforeClass
    public static void setup()
    {
        productDAOImp = new ProductDAOImp();
    }



    // POSITIVE test for viewing a product
    @Test
    public void displayProductByProductIDSuccess()
    {
        Product newProduct = productDAOImpObject.displayProductByProductID(3);
        Assert.assertEquals(newProduct.getProductId(), 3); // works
    }

    //Mocked Positive test for viewing product -  **********HELP DOES NOT DISPLAY AS NEEDED**********
//    @Test
//    public void displayProductSuccessfully()
//    {
//        Assert.assertEquals(productDAOImp.displayProductByProductID(3),"Product{productId=3, title='food', description='very unfresh', price=999.99, inventory=0, sellerId=0}");
//    }


    // POSITIVE test for viewing all products
    @Test
    public void displayAllProductsBySellerIdSuccess()
    {
        List<Product> product = productDAOImpObject.displayAllProductsBySellerId(1);
        Assert.assertTrue(product.size()>=1);
    }

    // NEGATIVE test for viewing a product
//    @Test
//    public void displayProductByProductIDFailure()
//    {
//        Product newProduct = productDAOImpObject.displayProductByProductID(-10);
//        Assert.assertEquals(newProduct, "ID not found");
//
//    }



}
