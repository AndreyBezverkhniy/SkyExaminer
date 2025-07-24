package pro.sky.java.examinerservice.exception;

public class UnavailableAmountRequestException extends RuntimeException {

    public UnavailableAmountRequestException() {
        super();
    }

    public UnavailableAmountRequestException(String message) {
        super(message);
    }

    public UnavailableAmountRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnavailableAmountRequestException(Throwable cause) {
        super(cause);
    }

    public UnavailableAmountRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
