package in.shop.order.controler;


import in.shop.order.client.ProductClient;
import in.shop.order.dao.OrderDetails;
import in.shop.order.mapper.ReqAndResMapper;
import in.shop.order.model.CombineResponse;
import in.shop.order.model.OrderRequest;
import in.shop.order.model.OrderResponse;
import in.shop.order.model.ProductResponse;
import in.shop.order.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/shop/order")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;
    private ProductClient productClient;
    private ReqAndResMapper mapper;

    @PostMapping("/save")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest){

        OrderDetails details = mapper.ReqToObject(orderRequest);
        OrderDetails saveOrder = orderService.saveOrder(details);

        OrderResponse orderResponse = mapper.objToRes(saveOrder);
      return   new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }

    @GetMapping("/findByOrdId/{orderId}")
    public ResponseEntity<OrderResponse> getByOrdId(@PathVariable Integer orderId){
        OrderDetails ordersById = orderService.getOrdersById(orderId);

        OrderResponse orderResponse = mapper.objToRes(ordersById);
        return ResponseEntity.ok(orderResponse);
    }

    @GetMapping("/getById/{orderId}")
    public ResponseEntity<CombineResponse> findByOrderId(@PathVariable Integer orderId){

        OrderDetails ordersById = orderService.getOrdersById(orderId);

        OrderResponse orderResponse = mapper.objToRes(ordersById);
       Integer productId= orderResponse.productId();

        ProductResponse productById = productClient.getProductById(productId);

       CombineResponse response= new CombineResponse(orderResponse,productById);


        return  ResponseEntity.ok(response);


    }

}
