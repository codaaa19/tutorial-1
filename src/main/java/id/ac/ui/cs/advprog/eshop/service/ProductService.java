package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;
//tambahin sesuai kebutuhan

public interface ProductService {
    Product create(Product product);
    boolean delete(Product product);
    Product get(String id);
    Product edit(Product product);
     List<Product> findAll();
}
