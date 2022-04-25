import com.bytesize.daos.ProductDAOImp;
import com.bytesize.entities.Product;
import com.bytesize.exceptions.IdNotFound;
import com.bytesize.service.ProductServiceImp;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ProductServiceTests
{

    //public ProductDAOImp productDAOImpObject;
    //
    public static ProductDAOImp productDAOImp;
    public static ProductServiceImp productService;

    @BeforeClass
    public void setup()
    {
        productDAOImp = Mockito.mock(ProductDAOImp.class); // we are mocking the DAO layer
        productService = new ProductServiceImp(productDAOImp);
    }


    // POSITIVE test for viewing a product
    @Test
    public void displayProductByProductIDSuccess()
    {
        Product newProduct = productService.serviceDisplayProductByProductID(9);
        Assert.assertEquals(newProduct.getProductId(), 9);
    }



    // POSITIVE test for viewing all products
    @Test
    public void displayAllProductsBySellerIdSuccess()
    {
        List<Product> product = productService.serviceDisplayAllProductsBySellerId(1);
        //ProductServiceImp productServiceImpObject = new ProductServiceImp(productDAOImp);
        Assert.assertTrue(product.size() >= 1);
    }

    // NEGATIVE test for viewing a product
    @Test
    public void displayProductByProductIDFailure()
    {
        Product newProduct = productService.serviceDisplayProductByProductID(9);
        Assert.assertEquals(newProduct.getProductId(), 9);
    }

    // NEGATIVE test for viewing all products
    @Test
    public void displayAllProductsBySellerIdFailure()
    {
        List<Product> product = productService.serviceDisplayAllProductsBySellerId(1);
        //ProductServiceImp productServiceImpObject = new ProductServiceImp(productDAOImp);
        Assert.assertTrue(product.size() >= 1);
    }

}
