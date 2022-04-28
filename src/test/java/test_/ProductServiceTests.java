package test_;

import com.bytesize.customExceptions.BadInput;
import com.bytesize.customExceptions.DataNotFound;
import com.bytesize.customExceptions.IdNotFound;
import com.bytesize.daos.ProductDAO;
import com.bytesize.daos.ProductDAOImp;
import com.bytesize.entities.Message;
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
    public void serviceCreateProduct() {
        testProduct = new Product(0, "food", "We see only fresh food", 100, 5, 1);
        Mockito.doReturn(testProduct).when(PD).createProduct(testProduct);
        Product resultingProduct = PSI.serviceCreateProduct(testProduct);
        Assert.assertEquals(resultingProduct.getProductId(), 0);
    }

    @Test(expectedExceptions = BadInput.class, expectedExceptionsMessageRegExp = "Title should be less than 150 characters")
    public void serviceCreateProductTitleNegative() {
        String testdata = "haha";
        while (testdata.length() < 151) {
            testdata = testdata.concat("haha");
        }
        testProduct = new Product(0, testdata, "We see only fresh food", 100, 5, 1);
        PSI.serviceCreateProduct(testProduct);
    }

    @Test(expectedExceptions = BadInput.class, expectedExceptionsMessageRegExp = "Description should be less than 500 characters")
    public void serviceCreateProductDescriptionNegative() {
        String testdata = "haha";
        while (testdata.length() < 501) {
            testdata = testdata.concat("haha");
        }
        testProduct = new Product(0, "sdf", testdata, 100, 5, 1);
        PSI.serviceCreateProduct(testProduct);
    }

    @Test(expectedExceptions = BadInput.class, expectedExceptionsMessageRegExp = "Price should be less than 1000")
    public void serviceCreateProductPriceNegative() {
        testProduct = new Product(0, "sdf", "testdata", 10000, 5, 1);
        PSI.serviceCreateProduct(testProduct);
    }

    @Test(expectedExceptions = BadInput.class, expectedExceptionsMessageRegExp = "Inventory should be less than 1000")
    public void serviceCreateProductInventoryNegative() {
        testProduct = new Product(0, "sdf", "testdata", 100, 5000, 1);
        PSI.serviceCreateProduct(testProduct);
    }

    @Test(expectedExceptions = DataNotFound.class, expectedExceptionsMessageRegExp = "Server error")
    public void serviceCreateProductNegative() {
        testProduct = new Product(2, "food", "We see only fresh food", 100, 5, 1);
        Mockito.doReturn(null).when(PD).createProduct(testProduct);
        PSI.serviceCreateProduct(testProduct);
    }

    @Test
    public void serviceSelectProductById() {
        testProduct = new Product(2, "food", "We see only fresh food", 100, 5, 1);
        Mockito.doReturn(testProduct).when(PD).selectProductById(2);
        Product product = PSI.serviceSelectProductById(2);
        Assert.assertEquals(product.getProductId(), 2);
    }

    @Test(expectedExceptions = IdNotFound.class, expectedExceptionsMessageRegExp = "Please provide valid id")
    public void serviceSelectProductByIdNegative() {
        Mockito.doReturn(null).when(PD).selectProductById(2);
        PSI.serviceSelectProductById(2);

    }

    @Test
    public void serviceSelectAllProducts() {
        List<Product> testproductList = new ArrayList<>();
        testProduct = new Product(2, "golden candy", "hahahah", 1000, 999, 1);
        testproductList.add(testProduct);
        Mockito.doReturn(testproductList).when(PD).selectAllProducts();
        List<Product> products = PSI.serviceSelectAllProducts();
        Assert.assertTrue(products.size() >= 1);
    }

    @Test(expectedExceptions = DataNotFound.class, expectedExceptionsMessageRegExp = "Server error")
    public void serviceSelectAllProductsNegative() {
        List<Product> testproductList = new ArrayList<>();
        Mockito.doReturn(testproductList).when(PD).selectAllProducts();
        PSI.serviceSelectAllProducts();
    }

    @Test
    public void serviceRemoveProductById() {
        int id = 2;
        Mockito.doReturn(1).when(PD).removeProductById(id);
        int result = PSI.serviceRemoveProductById(id);
        Assert.assertTrue(result == 1);
    }

    @Test(expectedExceptions = IdNotFound.class, expectedExceptionsMessageRegExp = "Please provide valid id")
    public void serviceRemoveProductByIdNegative() {
        int id = 2;
        Mockito.doReturn(0).when(PD).removeProductById(id);
        PSI.serviceRemoveProductById(id);
    }

    @Test
    public void serviceSelectAllProductByUser() {
        int id = 2;
        List<Product> testproductList = new ArrayList<>();
        testProduct = new Product(2, "golden candy", "hahahah", 1000, 999, 1);
        testproductList.add(testProduct);

        Mockito.doReturn(testproductList).when(PD).selectAllProductByUserId(id);
        List<Product> result = PSI.serviceSelectAllProductByUserId(id);
        Assert.assertTrue(result == testproductList);

    }

    @Test(expectedExceptions = IdNotFound.class, expectedExceptionsMessageRegExp = "Please provide valid id")
    public void serviceSelectAllProductByUserIdNegative() {
        int id = 2;
        List<Product> testproductList = new ArrayList<>();
        Mockito.doReturn(testproductList).when(PD).selectAllProductByUserId(id);
        PSI.serviceSelectAllProductByUserId(id);
    }
}
