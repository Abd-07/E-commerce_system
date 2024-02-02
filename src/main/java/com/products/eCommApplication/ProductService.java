package com.products.eCommApplication;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    // create the dummy existing data first, stored in a hashmap
    public ProductService() {
        ProductMap.put(1, product1);
        ProductMap.put(2, product2);
        ProductMap.put(3, product3);
    }

    HashMap<Integer,Product> ProductMap = new HashMap<Integer,Product>();
    Product product1 = new Product(1,"Laptop",1200);
    Product product2 = new Product(2,"Phone",300);
    Product product3 = new Product(3,"Calculator", 15);

    public List getProducts() {
        List<Product> list = new ArrayList<Product>(ProductMap.values());
        return list;
    }

    public Product getProductsWithId(int productId) {
        return ProductMap.get(productId);
    }

    public Product getProductsWithName(String ProductName) {
        for(int i=0;i<ProductMap.size();i++){
            if (Objects.equals(ProductName, ProductMap.get(i + 1).getProductName())) {
                return ProductMap.get(i+1);
            }
        }
        return new Product(0,"NONE",0);
    }

    public Product addProduct(Product addedProduct) {
        int maxId = ProductMap.size()+1;
        addedProduct.setId(maxId);
        ProductMap.put(maxId,addedProduct);
        return ProductMap.get(maxId);
    }

    public Product updateProduct(Product updatedProduct) {
        ProductMap.put(updatedProduct.getId(),updatedProduct);
        return ProductMap.get(updatedProduct.getId());
    }

    public ResponseMessage deleteProduct(int productId) {
        ProductMap.remove(productId);
        return new ResponseMessage("Product deleted");
    }
}

