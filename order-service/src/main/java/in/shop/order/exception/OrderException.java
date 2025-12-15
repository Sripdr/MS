package in.shop.order.exception;

import java.time.LocalDate;

public class OrderException extends RuntimeException{

    public OrderException(String message){
        super(message);
    }
}
