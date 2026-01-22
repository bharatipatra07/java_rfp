public class UserValidator {

    public static final UserInputValidator FIRST_NAME = name -> {
        if (!name.matches("[A-Z][a-zA-Z]{2,}"))
            throw new UserValidationException(
                    UserValidationException.ExceptionType.INVALID_FIRST_NAME,
                    "Invalid First Name");
    };

    public static final UserInputValidator LAST_NAME = name -> {
        if (!name.matches("[A-Z][a-zA-Z]{2,}"))
            throw new UserValidationException(
                    UserValidationException.ExceptionType.INVALID_LAST_NAME,
                    "Invalid Last Name");
    };

    public static final UserInputValidator EMAIL = email -> {
        boolean valid = email.matches(
                "^[a-zA-Z0-9]+([._+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2})?$"
        ) && !email.contains("..");

        if (!valid)
            throw new UserValidationException(
                    UserValidationException.ExceptionType.INVALID_EMAIL,
                    "Invalid Email");
    };

    public static final UserInputValidator MOBILE = mobile -> {
        if (!mobile.matches("[0-9]{2} [0-9]{10}"))
            throw new UserValidationException(
                    UserValidationException.ExceptionType.INVALID_MOBILE,
                    "Invalid Mobile Number");
    };

    public static final UserInputValidator PASSWORD = password -> {
        boolean valid = password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*[0-9].*")
                && password.replaceAll("[a-zA-Z0-9]", "").length() == 1;

        if (!valid)
            throw new UserValidationException(
                    UserValidationException.ExceptionType.INVALID_PASSWORD,
                    "Invalid Password");
    };
}