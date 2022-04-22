import com.bytesize.entities.Product;
import com.bytesize.daos.ProductDAOImp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDAOTests {
    ProductDAOImp PDI = new ProductDAOImp();

    @Test
    public void updateProduct(){
        Product product = new Product(2,"golden candy","tastes bad",2,999 ,1);
        int result = PDI.updateProductInfo(product);
        Assert.assertEquals(result, 1);
    }
}
