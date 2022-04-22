
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
    //ProductDAOImp productDAOImpObject = new ProductDAOImp(); // need to do mocking;
    public ProductDAOImp productDAOImp;
    public ProductServiceImp productService;

    @BeforeClass
    public void setup(){
        productDAOImp = Mockito.mock(ProductDAOImp.class);
        productService = new ProductServiceImp(productDAOImp);
    }


    // POSITIVE test for viewing a product
    @Test
    public void displayProductByProductIDSuccess()
    {
        Product newProduct = productDAOImpObject.displayProductByProductID(3);
        Assert.assertEquals(newProduct.getProductId(), 3);
    }

    // POSITIVE test for viewing all products
    @Test
    public void displayAllProductsBySellerIdSuccess()
    {
        List<Product> product = productDAOImpObject.displayAllProductsBySellerId(1); // need to make a test seller
        Assert.assertTrue(product.size() >= 1);
    }



}
