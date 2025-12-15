package in.shop.excep;

import in.shop.dto.ErrorDetails;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(UserExistException.class)
    public ErrorDetails handleUserExistException(ErrorDetails errorDetails) {
        return new ErrorDetails(errorDetails.getMessage(), LocalDateTime.now());
    }
    
    @ExceptionHandler(Exception.class)
    public ErrorDetails handleExceptions(ErrorDetails ex){
        return new ErrorDetails(ex.getMessage(), LocalDateTime.now());
    }
}
