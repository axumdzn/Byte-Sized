import com.bytesize.daos.ProductDAO;
import com.bytesize.daos.ProductDAOImp;
import com.bytesize.entities.Product;
import com.bytesize.service.ProductServiceImp;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ProductServiceTests {

    public ProductDAOImp productDAOImp;


    public ProductServiceImp productService;
    @BeforeClass
    public void setup(){
        productDAOImp = Mockito.mock(ProductDAOImp.class);
        productService = new ProductServiceImp(productDAOImp);
    }


    @Test
    public void serviceCreateProduct() {
        Product newProduct = new Product(0, "food", "We see only fresh food", 5.49f, 5, 1);
        Product resultingProduct = productService.serviceCreateProduct(newProduct);
        Assert.assertNotEquals(resultingProduct.getProductId(), 0);
    }

    @Test
    public void serviceSelectProductById() {
        Product product = productService.serviceSelectProductById(2);
        Assert.assertEquals(product.getProductId(), 2);
    }

    @Test
    public void serviceSelectAllProducts() {
        List<Product> products = productService.serviceSelectAllProducts();
        Assert.assertTrue(products.size() >= 1);
    }

    @Test
    public void serviceUpdateProductById() {
        Product product = new Product(-2, "Fries", "This is fresh fries", 3.99f, 5, 1);
        int result = productService.serviceUpdateProductById(product);
        Assert.assertTrue(result == 0);
    }



    @Test
    public void serviceRemoveProductById() {
        int result = productService.serviceRemoveProductById(-3);
        Assert.assertTrue(result == 0);
    }


}
