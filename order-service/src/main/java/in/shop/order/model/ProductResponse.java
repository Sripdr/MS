package in.shop.order.model;

public record ProductResponse(Integer productId, String productName, String productDescription, Double productPrice, String productCategory) {
}
