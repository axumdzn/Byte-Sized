import com.bytesize.customExceptions.BadInput;
import com.bytesize.customExceptions.IdNotFound;
import com.bytesize.daos.ProductDAO;
import com.bytesize.daos.ProductDAOImp;
import com.bytesize.entities.Product;
import com.bytesize.service.ProductServiceImp;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
public class ProductServiceTests {
    public ProductDAO PD;
    public ProductServiceImp PSI;
    public Product testProduct;

    @BeforeClass
    public void setup() {
        PD = Mockito.mock(ProductDAOImp.class);
        PSI = new ProductServiceImp(PD);
    }
    @Test
    public void updateProductSuccess() {
        testProduct = new Product(2, "golden candy", "tastes bad", 2, 999, 1);
        Mockito.doReturn(1).when(PD).updateProductById(testProduct);
        int result = PSI.updateProduct(testProduct);
        Assert.assertEquals(result, 1);
    }
    @Test(expectedExceptions = IdNotFound.class, expectedExceptionsMessageRegExp = "Id not found")
    public void updateProductNoUserNegative() {
        testProduct = new Product(2, "golden candy", "tastes bad", 2, 999, 1);
        Mockito.doReturn(0).when(PD).updateProductById(testProduct);
        PSI.updateProduct(testProduct);
    }

    @Test(expectedExceptions = BadInput.class, expectedExceptionsMessageRegExp = "Description should be less than 500 characters")
    public void updateProductDescriptionNegative() {
        String testDescription = "haha";
        while (testDescription.length() < 501) {
            testDescription = testDescription.concat("haha");
        }
        testProduct = new Product(2, "golden candy", testDescription, 2, 999, 1);
        PSI.updateProduct(testProduct);
    }

    @Test(expectedExceptions = BadInput.class, expectedExceptionsMessageRegExp = "Title should be less than 150 characters")
    public void updateProductTitleNegative() {
        String testTitle = "haha";
        while (testTitle.length() < 151) {
            testTitle = testTitle.concat("haha");
        }
        testProduct = new Product(2, testTitle, "ahahah", 2, 999, 1);
        PSI.updateProduct(testProduct);
    }

    @Test(expectedExceptions = BadInput.class, expectedExceptionsMessageRegExp = "Price should be less than 1000")
    public void updateProductPriceNegative() {
        testProduct = new Product(2, "golden candy", "hahahah", 1000, 999, 1);
        PSI.updateProduct(testProduct);
    }

    @Test(expectedExceptions = BadInput.class, expectedExceptionsMessageRegExp = "Inventory should be less than 1000")
    public void updateProductInventoryNegative() {
        testProduct = new Product(2, "golden candy", "hahahah", 999, 1000, 1);
        PSI.updateProduct(testProduct);
    }
    @Test
    public void serviceRemoveProductById() {
        int result = PSI.serviceRemoveProductById(-3);
        Assert.assertTrue(result == 0);
    }
    @Test
    public void serviceSelectAllProducts() {
        ArrayList<Product> products = PSI.serviceSelectAllProducts();
        Assert.assertTrue(products.size() >= 1);
    }

    @Test
    public void serviceCreateProduct() {
        Product newProduct = new Product(0, "food", "We see only fresh food", 100, 5, 1);
        Product resultingProduct = PSI.serviceCreateProduct(newProduct);
        Assert.assertNotEquals(resultingProduct.getProductId(), 0);
    }

    @Test
    public void serviceSelectProductById() {
        Product product = PSI.serviceSelectProductById(2);
        Assert.assertEquals(product.getProductId(), 2);
    }


}