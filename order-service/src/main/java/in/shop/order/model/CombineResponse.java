package in.shop.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // <-- This single annotation adds Getters, Setters, default constructor, equals, etc.
@NoArgsConstructor // <-- Good to have
@AllArgsConstructor
public class CombineResponse {

    private OrderResponse orderResponse;
    private ProductResponse productResponse;
}
