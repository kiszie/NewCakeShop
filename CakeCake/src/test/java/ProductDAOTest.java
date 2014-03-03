import cbsd.entity.Product;
import cbsd.service.ProductService;
import cbsd.service.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dell on 2/3/2557.
 */
public class ProductDAOTest {
    ProductService productService = null;
    @Before
    public void setUp() throws Exception{
        productService = new ProductServiceImpl();
    }
    @Test
    public void getProductTest() throws  Exception{
        List<Product> product = new ArrayList<Product>();
        product = productService.getProduct();
        assertEquals(0,product);
    }
    @Test
    public void addProductTest() throws Exception{
        Product product = new Product();
        product.setName("Coco");
        product.setDes("Milke Chocolate 50% + Dark Chocolate 50%");
        product.setPrice(22);


        Product expectProduct = new Product();
        product.setName("Coco");
        product.setDes("Milke Chocolate 50% + Dark Chocolate 50%");
        product.setPrice(22);

        List<Product> productList = new ArrayList<Product>();
        productList.add(expectProduct);

        productService.addProduct(product);
        assertEquals(productList,productService.getProduct());




    }

}
