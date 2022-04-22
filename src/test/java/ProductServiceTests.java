import com.bytesize.daos.ProductDAOImp;
import com.bytesize.entities.Product;
import com.bytesize.service.ProductServiceImp;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductServiceTests
{
    //ProductDAOImp productDAOImpObject = new ProductDAOImp();
    public ProductDAOImp productDAOImpObject = new ProductDAOImp();
    ProductServiceImp productService = new ProductServiceImp(productDAOImpObject);


    // POSITIVE test for viewing a product
    @Test
    public void displayProductByProductIDSuccess()
    {
        Product newProduct = productService.serviceDisplayProductByProductID(0);
        Assert.assertEquals(newProduct.getProductId(), 0);

    }

    // POSITIVE test for viewing all products
    @Test
    public void displayAllProductsBySellerIdSuccess()
    {
        List<Product> product = productDAOImpObject.displayAllProductsBySellerId(1);
        ProductServiceImp productServiceImpObject = new ProductServiceImp(productDAOImpObject);
        Assert.assertTrue(product.size() >= 1);
        //take from service layer and send it dowm to DAL


    }
}
