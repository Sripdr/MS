package in.shop.order.service;

import in.shop.order.dao.OrderDetails;
import in.shop.order.exception.OrderException;

import in.shop.order.model.CombineResponse;
import in.shop.order.repo.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;



    public OrderDetails saveOrder(OrderDetails orderDetails){

        return orderRepository.save(orderDetails);
    }

    public  OrderDetails getOrdersById(Integer orderId){

        return orderRepository.findById(orderId).orElseThrow(() -> new OrderException("orderId not found with the given "+orderId));

    }


}
