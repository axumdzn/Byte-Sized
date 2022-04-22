import com.bytesize.daos.ProductDAOImp;
import com.bytesize.entities.Product;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

public class ProductDAOTests {

    ProductDAOImp productDAO = new ProductDAOImp();



    @Test
    public void createProductSuccess() {

        Product newProduct = new Product(0, "food", "We see only fresh food", 5.49f, 5, 1);
        Product resultingProduct = productDAO.createProduct(newProduct);
        Assert.assertNotEquals(resultingProduct.getProductId(), 0);

    }

    @Test
    public void selectProductByIdSuccess() {
        Product product = productDAO.selectProductById(2);
        Assert.assertEquals(product.getProductId(), 2);
    }

    @Test
    public void selectAllProductSuccess() {
        List<Product> products = productDAO.selectAllProducts();
        Assert.assertTrue(products.size() >= 1);
    }

    @Test
    public void updateProductSuccess() {
        Product product = new Product(-2, "Fries", "This is fresh fries", 3.99f, 5, 1);
        int result = productDAO.updateProductById(product);
        Assert.assertTrue(result == 0);
    }

    @Test
    public void removeProductSuccess() {
        int result = productDAO.removeProductById(-3);
        Assert.assertTrue(result == 0);
    }
}


