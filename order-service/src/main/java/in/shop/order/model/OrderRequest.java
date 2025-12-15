package in.shop.order.model;

import in.shop.order.dao.Address;

public record OrderRequest(Integer orderQuantity,

                           String orderPaymentMode,

                           String orderStatus,
                           Integer productId,
                           Address address) {
}
