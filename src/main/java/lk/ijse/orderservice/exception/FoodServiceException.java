package lk.ijse.orderservice.exception;

public class FoodServiceException extends RuntimeException {
    public FoodServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}