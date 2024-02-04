package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;
 //tambahin sesuai kebutuhan

public interface ProductService {
    public Product create(Product product);
    public boolean delete(Product product);
    public Product get(String id);
    public List<Product> findAll();
}
