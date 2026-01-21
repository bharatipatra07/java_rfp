import java.util.Scanner;
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

        ExceptionType type;

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
            "^(?=.*[A-Z])(?=.*[0-9])(?=(?:.*[^a-zA-Z0-9]){1}).{8,}$";

    // ---------- UC1 ----------
    public boolean validateFirstName(String firstName) throws UserRegistrationException {
        if (!Pattern.matches(NAME_REGEX, firstName)) {
            throw new UserRegistrationException(
                    UserRegistrationException.ExceptionType.INVALID_FIRST_NAME,
                    "First Name Invalid");
        }
        return true;
    }

    // ---------- UC2 ----------
    public boolean validateLastName(String lastName) throws UserRegistrationException {
        if (!Pattern.matches(NAME_REGEX, lastName)) {
            throw new UserRegistrationException(
                    UserRegistrationException.ExceptionType.INVALID_LAST_NAME,
                    "Last Name Invalid");
        }
        return true;
    }

    // ---------- UC3 & UC9 ----------
    public boolean validateEmail(String email) throws UserRegistrationException {
        if (!Pattern.matches(EMAIL_REGEX, email)) {
            throw new UserRegistrationException(
                    UserRegistrationException.ExceptionType.INVALID_EMAIL,
                    "Email Invalid");
        }
        return true;
    }

    // ---------- UC4 ----------
    public boolean validateMobile(String mobile) throws UserRegistrationException {
        if (!Pattern.matches(MOBILE_REGEX, mobile)) {
            throw new UserRegistrationException(
                    UserRegistrationException.ExceptionType.INVALID_MOBILE,
                    "Mobile Number Invalid");
        }
        return true;
    }

    // ---------- UC5–UC8 ----------
    public boolean validatePassword(String password) throws UserRegistrationException {
        if (!Pattern.matches(PASSWORD_REGEX, password)) {
            throw new UserRegistrationException(
                    UserRegistrationException.ExceptionType.INVALID_PASSWORD,
                    "Password Invalid");
        }
        return true;
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserRegistration user = new UserRegistration();

        try {
            System.out.print("Enter First Name: ");
            user.validateFirstName(sc.nextLine());
            System.out.println("First Name Valid");

            System.out.print("Enter Last Name: ");
            user.validateLastName(sc.nextLine());
            System.out.println("Last Name Valid");

            System.out.print("Enter Email: ");
            user.validateEmail(sc.nextLine());
            System.out.println("Email Valid");

            System.out.print("Enter Mobile (91 9876543210): ");
            user.validateMobile(sc.nextLine());
            System.out.println("Mobile Number Valid");

            System.out.print("Enter Password: ");
            user.validatePassword(sc.nextLine());
            System.out.println("Password Valid");

            System.out.println("User Registration Successful");

        } catch (UserRegistrationException e) {
            System.out.println("Validation Failed");
            System.out.println("Error Type : " + e.type);
            System.out.println("Message    : " + e.getMessage());
        }

        sc.close();
    }
}

