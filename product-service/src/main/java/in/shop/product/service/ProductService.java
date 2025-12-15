package in.shop.product.service;

import in.shop.product.dao.ProductDetails;
import in.shop.product.exception.ProductNotFoundException;
import in.shop.product.repo.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public ProductDetails saveProduct(ProductDetails details) {

        return productRepository.save(details);
    }

    public ProductDetails getProductById(Integer productId) {

        ProductDetails details = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("product not found with given Id" + productId));
        return details;
    }
}