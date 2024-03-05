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

        when(productRepository.delete(product.getProductId())).thenReturn(true);

        boolean isDeleted = productService.delete(product.getProductId());

        assertEquals(true, isDeleted);
        verify(productRepository, times(1)).delete(product.getProductId());

    }

    @Test
    public void testDeleteNotFoundProduct() {
        // Create an instance of the class that implements the delete method
        // Assuming productRepository is properly initialized or mocked
        ProductServiceImpl productService = new ProductServiceImpl();

        // Call the delete method with null as the argument
        boolean result = productService.delete(null);

        // Check that the result is false
        assertFalse(result, "Delete method should return false for null product");
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

        when(productRepository.findAll()).thenReturn(mockIterator(productList));

        List<Product> retrievedProducts = productService.findAll();

        assertEquals(productList.size(), retrievedProducts.size());
        assertEquals(productList, retrievedProducts);
    }

    private Iterator<Product> mockIterator(List list) {
        return list.iterator();
    }

    @Test
    public void testGetProductById() {
        // Arrange
        Product expectedProduct = new Product();
        expectedProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        expectedProduct.setProductName("TESTING1");
        expectedProduct.setProductQuantity(1);
        when(productRepository.findAll()).thenReturn(createMockIterator(expectedProduct));

        // Act
        Product actualProduct = productService.get(expectedProduct.getProductId());

        // Assert
        assertEquals(expectedProduct, actualProduct);
        verify(productRepository, times(1)).findAll();
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
