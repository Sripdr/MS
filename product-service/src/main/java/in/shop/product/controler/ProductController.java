package in.shop.product.controler;


import in.shop.product.dao.ProductDetails;
import in.shop.product.exception.ProductNotFoundException;
import in.shop.product.mapper.ReqAndResMapper;
import in.shop.product.model.ProductRequest;
import in.shop.product.model.ProductResponse;
import in.shop.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/shop/product")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
    private ReqAndResMapper reqAndResMapper;

    @PostMapping("/save")
    public ResponseEntity<ProductResponse> saveProduct(@RequestBody ProductRequest productRequest){

        ProductDetails details = reqAndResMapper.reqToObj(productRequest);

        ProductDetails saveProduct = productService.saveProduct(details);

        ProductResponse productResponse = reqAndResMapper.objToRes(saveProduct);

        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);

    }

@GetMapping("/findById/{productId}")
    public ResponseEntity<ProductResponse> getById(@PathVariable Integer productId){

        ProductDetails productById = productService.getProductById(productId);

    ProductResponse productResponse = reqAndResMapper.objToRes(productById);
    return ResponseEntity.ok(productResponse);
    }
}
