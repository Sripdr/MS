package in.shop.api;

public class NotFound extends RuntimeException {
    public NotFound(String message) {
        super(message);
    }
}
