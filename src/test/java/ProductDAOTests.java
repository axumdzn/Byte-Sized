import com.bytesize.entities.Product;
import com.bytesize.daos.ProductDAOImp;
import com.bytesize.exceptions.IdNotFound;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;


public class ProductDAOTests {
    ProductDAOImp productDAO = new ProductDAOImp();

    @Test
    public void updateProduct(){
        Product product = new Product(2,"golden candy","tastes bad",2,999 ,1);
        int result = productDAO.updateProductById(product);
        Assert.assertEquals(result, 1);
    }





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


    // POSITIVE test for viewing a product
    @Test
    public void displayProductByProductIDSuccess()
    {
        Product newProduct = productDAO.displayProductByProductID(9);
        Assert.assertEquals(newProduct.getProductId(), 9);
    }

    // POSITIVE test for viewing all products
    @Test
    public void displayAllProductsBySellerIdSuccess()
    {
        List<Product> product = productDAO.displayAllProductsBySellerId(1);
        Assert.assertTrue(product.size()>=1);
    }

    // NEGATIVE test for viewing a product
    @Test(expectedExceptions = IdNotFound.class, expectedExceptionsMessageRegExp = "ID not found")
    public void throwIdNotFoundProductSuccessfully(){
        productDAO.displayProductByProductID(100);
    }

    // NEGATIVE test for viewing all products
    @Test(expectedExceptions = IdNotFound.class, expectedExceptionsMessageRegExp = "ID not found")
    public void throwIdNotFoundProductsSuccessfully(){
        productDAO.displayProductByProductID(100);
    }
}


