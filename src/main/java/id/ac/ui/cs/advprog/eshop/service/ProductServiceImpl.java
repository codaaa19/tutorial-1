package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        productRepository.create(product);
        return product;
    }

    @Override
    public Product delete(String productId){
        return productRepository.delete(productId);
    }
    @Override
    public Product get(String id) {
        Product productValid = null;
        List<Product> products = productRepository.findAll();
        for (Product curP : products){
            if(curP.getProductId().equals(id)){
                return curP;
            }
        }
        return null;
    }

    @Override
    public Product edit(Product product) {
        productRepository.edit(product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
