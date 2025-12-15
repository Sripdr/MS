package in.shop.order.model;

import in.shop.order.dao.Address;

import java.time.LocalDateTime;

public  record OrderResponse(Integer orderId, Integer orderQuantity, LocalDateTime orderDate, String orderPaymentMode,  String orderStatus,Integer productId, Address address
                            ) {
}