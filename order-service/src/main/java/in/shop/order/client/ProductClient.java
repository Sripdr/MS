package in.shop.order.client;

import in.shop.order.model.ProductResponse;
import lombok.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@AllArgsConstructor
@RequiredArgsConstructor
@Service
public class ProductClient {


  private  RestClient restClient =RestClient.builder().build();


public ProductResponse getProductById(Integer productId){
    String BASEURL="http://localhost:8013/shop/product/findById/{productId}";
  return   restClient.get()
            .uri(BASEURL,productId)
            .retrieve()
            .body(ProductResponse.class);

}

}
