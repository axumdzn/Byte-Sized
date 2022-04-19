import com.bytesize.entities.Product;
import com.bytesize.daos.ProductDAOImp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDAOTests {
    ProductDAOImp PDI = new ProductDAOImp();

    @Test
    public void updateProject(){
        Product product = new Product(-1,"golden candy",1000,2, "tastes bad", -2);
        int result = PDI.updateProductInfo(product);
        Assert.assertEquals(result, 1);
    }
}
