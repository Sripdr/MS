package in.shop.product.mapper;

import in.shop.product.dao.ProductDetails;
import in.shop.product.model.ProductRequest;
import in.shop.product.model.ProductResponse;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReqAndResMapper {


    public ProductDetails reqToObj(ProductRequest request){

        ProductDetails details=new ProductDetails();

        details.setProductName(request.productName());
        details.setProductDescription(request.productDescription());
        details.setProductPrice(request.productPrice());
        details.setProductCategory(request.productCategory());
        return details;
    }

    public ProductResponse objToRes(ProductDetails details){
      return  new ProductResponse(details.getProductId(),
              details.getProductName(),
              details.getProductDescription(),
              details.getProductPrice(),
              details.getProductCategory());

    }
}
