package in.shop.excep;

public class UserExistException extends RuntimeException {
    public UserExistException(String message) {
        super(message);
    }
}
