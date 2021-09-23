package com.produtos.apirest.resources;

import com.produtos.apirest.models.Product;
import com.produtos.apirest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProductResource {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> listProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findProduct(@PathVariable(value = "id") long id){
        return productRepository.findById(id);
    }

    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable(value = "id") long id){
        productRepository.deleteById(id);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
}
