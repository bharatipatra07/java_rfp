package Day23;
public class UserValidationException extends Exception {

    public enum ExceptionType {
        INVALID_FIRST_NAME,
        INVALID_LAST_NAME,
        INVALID_EMAIL,
        INVALID_MOBILE,
        INVALID_PASSWORD
    }

    public ExceptionType type;

    public UserValidationException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}