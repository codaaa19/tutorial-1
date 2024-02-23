package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@org.springframework.stereotype.Repository
public class ProductRepository implements Repository<Product>{
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product){
        product.setProductId(String.valueOf(UUID.randomUUID()));
        productData.add(product);
        return product;
    }

    public Product findById(String id) {
        for (Product product: productData){
            if (product.getProductId().equals(id)){
                return product;
            }
        }
        return null;
    }

    @Override
    public Product delete(String id) {
        List<Product> allData = findAll();
        for (Product curP : allData){
            if (curP.getProductId().equals(id)){
                allData.remove(curP);
                return curP;
            }
        }
        return null;
    }

    public Product edit(Product product) {
        for (int i = 0; i < productData.size(); i++) {
            Product tmp = productData.get(i);
            if (tmp.getProductId().equals(product.getProductId())) {
                return productData.set(i, product);
            }
        }
        return null;
    }
    public Product update(String id, Product updated) {
        for (Product curP : productData){
            if(curP.getProductId().equals(id)){
                curP.setProductName(updated.getProductName());
                curP.setProductId(updated.getProductId());
                curP.setProductQuantity(updated.getProductQuantity());
            }
        }
        return null;
    }

    public List<Product> findAll(){
        return productData;
    }
}