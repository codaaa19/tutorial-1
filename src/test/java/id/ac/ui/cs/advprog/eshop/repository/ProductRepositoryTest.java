package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;
    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        List<Product> productList = productRepository.findAll();
        assertFalse(productList.isEmpty()); // Check if the list is not empty

        // Iterate over the list to find the saved product
        Product savedProduct = null;
        for (Product p : productList) {
            if (p.getProductId().equals(product.getProductId())) {
                savedProduct = p;
                break;
            }
        }

        assertNotNull(savedProduct); // Check if the saved product is not null
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        List<Product> productList = productRepository.findAll();
        assertTrue(productList.isEmpty());
    }


    @Test
    public void testEditProduct() {
        // Create a new product
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("TESTING");
        product.setProductQuantity(1);

        Product createdProduct = productRepository.create(product);

        String editedName = "Test";
        int editedQuantity = 2;
        createdProduct.setProductName(editedName);
        createdProduct.setProductQuantity(editedQuantity);
        productRepository.edit(createdProduct);

        List<Product> productList = productRepository.findAll();
        Product editedProduct = null;

        // Iterate over the list to find the edited product
        for (Product p : productList) {
            if (p.getProductId().equals(createdProduct.getProductId())) {
                editedProduct = p;
                break;
            }
        }

        assertNotNull(editedProduct);
        assertEquals(editedProduct.getProductName(), editedName);
        assertEquals(editedProduct.getProductQuantity(), editedQuantity);
    }


    @Test
    void testDelete() {
        // Create a new product
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("TESTING");
        product.setProductQuantity(1);
        Product createdProduct = productRepository.create(product);

        productRepository.delete(createdProduct.getProductId());

        List<Product> productList = productRepository.findAll();
        assertTrue(productList.isEmpty());
    }


    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd7");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(200);
        productRepository.create(product2);

        List<Product> productList = productRepository.findAll();
        assertFalse(productList.isEmpty()); // Check if the list is not empty

        // Iterate over the list and compare the products
        for (Product p : productList) {
            if (p.getProductId().equals(product1.getProductId())) {
                assertEquals(product1.getProductName(), p.getProductName());
                assertEquals(product1.getProductQuantity(), p.getProductQuantity());
            } else if (p.getProductId().equals(product2.getProductId())) {
                assertEquals(product2.getProductName(), p.getProductName());
                assertEquals(product2.getProductQuantity(), p.getProductQuantity());
            } else {
                fail("Unexpected product found in the list");
            }
        }
    }

}