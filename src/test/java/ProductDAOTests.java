import com.bytesize.daos.ProductDAO;
import com.bytesize.daos.ProductDAOImp;
import com.bytesize.entities.Product;
import com.bytesize.exceptions.IdNotFound;
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
        Product newProduct = productDAOImpObject.displayProductByProductID(9);
        Assert.assertEquals(newProduct.getProductId(), 9);
    }

    // POSITIVE test for viewing all products
    @Test
    public void displayAllProductsBySellerIdSuccess()
    {
        List<Product> product = productDAOImpObject.displayAllProductsBySellerId(1);
        Assert.assertTrue(product.size()>=1);
    }

    // NEGATIVE test for viewing a product
    @Test(expectedExceptions = IdNotFound.class, expectedExceptionsMessageRegExp = "ID not found")
    public void throwIdNotFoundProductSuccessfully(){
        productDAOImp.displayProductByProductID(100);
    }

    // NEGATIVE test for viewing all products
    @Test(expectedExceptions = IdNotFound.class, expectedExceptionsMessageRegExp = "ID not found")
    public void throwIdNotFoundProductsSuccessfully(){
        productDAOImp.displayProductByProductID(100);
    }



}
