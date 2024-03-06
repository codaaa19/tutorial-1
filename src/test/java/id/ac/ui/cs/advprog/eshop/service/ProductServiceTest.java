package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateProduct() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("TESTING");
        product.setProductQuantity(1);
        when(productRepository.create(product)).thenReturn(product);

        Product createdProduct = productService.create(product);

        assertEquals(product, createdProduct);
        verify(productRepository, times(1)).create(product);
    }

    @Test
    public void testDeleteProduct() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("TESTING");
        product.setProductQuantity(1);

        // Stub the delete method of the repository to return a Product
        when(productRepository.delete(product.getProductId())).thenReturn(product);

        // Call the delete method of the service
        Product deletedProduct = productService.delete(product.getProductId());

        // Verify that the delete method of the repository was called with the correct ID
        verify(productRepository, times(1)).delete(product.getProductId());

        // Check if the deletedProduct is not null
        assertNotNull(deletedProduct);

        // Assert that the deleted product ID matches the ID of the product we created
        assertEquals(product.getProductId(), deletedProduct.getProductId());
    }


    @Test
    public void testEditProduct() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("TESTING");
        product.setProductQuantity(1);

        when(productRepository.edit(product)).thenReturn(product);

        Product editedProduct = productService.edit(product);

        assertEquals(product, editedProduct);
        verify(productRepository, times(1)).edit(product);
    }

    @Test
    public void testFindAllProducts() {
        // Create a list of products
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("TESTING1");
        product1.setProductQuantity(1);

        Product product2 = new Product();
        product2.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd5");
        product2.setProductName("TESTING2");
        product2.setProductQuantity(1);
        productList.add(product1);
        productList.add(product2);

        // Mock the findAll() method of ProductRepository to return the productList
        when(productRepository.findAll()).thenReturn(productList);

        // Call the findAll() method of ProductService
        List<Product> retrievedProducts = productService.findAll();

        // Assert that the retrievedProducts has the same size as the productList
        assertEquals(productList.size(), retrievedProducts.size());

        // Assert that the retrievedProducts contains the same products as productList
        assertEquals(productList, retrievedProducts);
    }


    private Iterator<Product> mockIterator(List list) {
        return list.iterator();
    }

    private Iterator<Product> createMockIterator(Product product) {
        return new Iterator<Product>() {
            private boolean hasNext = true;

            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public Product next() {
                hasNext = false;
                return product;
            }
        };
    }
}
