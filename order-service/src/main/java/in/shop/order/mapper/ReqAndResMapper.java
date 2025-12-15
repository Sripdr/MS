package in.shop.order.mapper;

import in.shop.order.dao.Address;
import in.shop.order.dao.OrderDetails;
import in.shop.order.model.OrderRequest;
import in.shop.order.model.OrderResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReqAndResMapper {

    public OrderDetails ReqToObject(OrderRequest orderRequest){

        OrderDetails details=new OrderDetails();
        details.setOrderQuantity(orderRequest.orderQuantity());
        details.setOrderDate(LocalDateTime.now());
        details.setOrderPaymentMode(orderRequest.orderPaymentMode());
        details.setOrderStatus(orderRequest.orderStatus());
        details.setProductId(orderRequest.productId());
        details.setAddress(orderRequest.address());

        /*details.setOrderQuantity(orderRequest.orderQuantity());
        details.setOrderDate(LocalDateTime.now());
        details.setOrderPaymentMode(orderRequest.orderPaymentMode());
        details.setOrderStatus(orderRequest.orderStatus());
        details.setAddress(orderRequest.address());*/
        return details;
    }

    public OrderResponse objToRes(OrderDetails details){



        OrderResponse response = new OrderResponse(details.getOrderId(),details.getOrderQuantity(), details.getOrderDate(),
                details.getOrderPaymentMode(), details.getOrderStatus(),details.getProductId(), details.getAddress());
        /*response.setOrderId(details.getOrderId());
        response.setOrderQuantity(details.getOrderQuantity());
        response.setOrderPaymentMode(details.getOrderPaymentMode());
        response.setOrderDate(details.getOrderDate());
        response.setOrderStatus(details.getOrderStatus());
        response.setAddress(details.getAddress());*/
        return response;
    }


}
