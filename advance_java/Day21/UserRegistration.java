package Day21;

import java.util.regex.Pattern;

public class UserRegistration {

    public static class UserRegistrationException extends Exception {

        public enum ExceptionType {
            INVALID_FIRST_NAME,
            INVALID_LAST_NAME,
            INVALID_EMAIL,
            INVALID_MOBILE,
            INVALID_PASSWORD
        }

        public ExceptionType type;

        public UserRegistrationException(ExceptionType type, String message) {
            super(message);
            this.type = type;
        }
    }

    private static final String NAME_REGEX = "^[A-Z][a-z]{2,}$";

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$";

    private static final String MOBILE_REGEX = "^[0-9]{2}\\s[0-9]{10}$";

    private static final String PASSWORD_REGEX =
            "^(?=.*[A-Z])(?=.*[0-9])(?=(?:.*[^a-zA-Z0-9]){1})[a-zA-Z0-9^a-zA-Z0-9]{8,}$";

    public boolean validateFirstName(String firstName)
            throws UserRegistrationException {

        if (!Pattern.matches(NAME_REGEX, firstName))
            throw new UserRegistrationException(
                    UserRegistrationException.ExceptionType.INVALID_FIRST_NAME,
                    "Invalid First Name");

        return true;
    }

    public boolean validateLastName(String lastName)
            throws UserRegistrationException {

        if (!Pattern.matches(NAME_REGEX, lastName))
            throw new UserRegistrationException(
                    UserRegistrationException.ExceptionType.INVALID_LAST_NAME,
                    "Invalid Last Name");

        return true;
    }

    public boolean validateEmail(String email)
            throws UserRegistrationException {

        if (!Pattern.matches(EMAIL_REGEX, email))
            throw new UserRegistrationException(
                    UserRegistrationException.ExceptionType.INVALID_EMAIL,
                    "Invalid Email");

        return true;
    }

    public boolean validateMobile(String mobile)
            throws UserRegistrationException {

        if (!Pattern.matches(MOBILE_REGEX, mobile))
            throw new UserRegistrationException(
                    UserRegistrationException.ExceptionType.INVALID_MOBILE,
                    "Invalid Mobile Number");

        return true;
    }

    public boolean validatePassword(String password)
            throws UserRegistrationException {

        if (!Pattern.matches(PASSWORD_REGEX, password))
            throw new UserRegistrationException(
                    UserRegistrationException.ExceptionType.INVALID_PASSWORD,
                    "Invalid Password");

        return true;
    }
}
