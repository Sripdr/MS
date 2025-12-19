package in.shop.exception;

public class InValidUser extends RuntimeException {
    public InValidUser(String message) {
        super(message);
    }
}
