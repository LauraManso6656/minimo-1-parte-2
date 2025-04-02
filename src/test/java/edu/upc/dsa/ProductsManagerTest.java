package edu.upc.dsa;

import edu.upc.dsa.exceptions.ProductNotFoundException;
import edu.upc.dsa.models.Product;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ProductsManagerTest {
    ProductsManager tm;

    @Before
    public void setUp() {
        this.tm = ProductsManagerImpl.getInstance();
        this.tm.addProduct("C1", "Nutella", 4.50);
        this.tm.addProduct("C2", "Fanta", 3);
        this.tm.addProduct("C3", "Coca cola", 3.50);
    }

    @After
    public void tearDown() {
        // És un Singleton
        this.tm.clear();
    }

    @Test
    public void addProductTest() {
        Assert.assertEquals(3, tm.size());

        this.tm.addProduct("C4", "Pepsi");

        Assert.assertEquals(4, tm.size());

    }

    @Test
    public void getProductTest() throws Exception {
        Assert.assertEquals(3, tm.size());

        Product t = this.tm.getProduct("C1");
        Assert.assertEquals("C1", t.getId());
        Assert.assertEquals("Nutella", t.getName());

        t = this.tm.getProduct2("C2");
        Assert.assertEquals("C2", t.getId());
        Assert.assertEquals("Fanta", t.getName());

        Assert.assertThrows(ProductNotFoundException.class, () ->
                this.tm.getProduct2("XXXXXXX"));

    }

    @Test
    public void getProductsTest() {
        Assert.assertEquals(3, tm.size());
        List<Product> products  = tm.findAll();

        Product t = products.get(0);
        Assert.assertEquals("C1", t.getId());
        Assert.assertEquals("Nutella", t.getName());
        t = products.get(1);
        Assert.assertEquals("C2", t.getId());
        Assert.assertEquals("Fanta", t.getName());

        t = products.get(2);
        Assert.assertEquals("C3", t.getId());
        Assert.assertEquals("Coca cola", t.getName());

        Assert.assertEquals(3, tm.size());

    }

    @Test
    public void updateProductTest() {
        Assert.assertEquals(3, tm.size());
        Product t = this.tm.getProduct("C3");
        Assert.assertEquals("C3", t.getId());
        Assert.assertEquals("Coca cola", t.getName());

        t.setName("Fanta");
        this.tm.updateProduct(t);

        t = this.tm.getProduct("C2");
        Assert.assertEquals("C2", t.getId());
        Assert.assertEquals("Fanta", t.getName());
    }


    @Test
    public void deleteProductTest() {
        Assert.assertEquals(3, tm.size());
        this.tm.deleteProduct("C3");
        Assert.assertEquals(2, tm.size());

        Assert.assertThrows(ProductNotFoundException.class, () ->
                this.tm.getProduct2("C3"));

    }
}
