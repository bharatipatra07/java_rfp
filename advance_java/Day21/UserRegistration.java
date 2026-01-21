package Day21;

public class UserRegistration {

    public static boolean validateFirstName(String firstName) {
        if (!firstName.matches("[A-Z][a-z]{2,}")) {
            throw new UserRegistrationException("Invalid First Name");
        }
        return true;
    }

    public static boolean validateLastName(String lastName) {
        if (!lastName.matches("[A-Z][a-z]{2,}")) {
            throw new UserRegistrationException("Invalid Last Name");
        }
        return true;
    }

    public static boolean validateEmail(String email) {
        if (!email.matches("^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$")) {
            throw new UserRegistrationException("Invalid Email");
        }
        return true;
    }

    public static boolean validateMobile(String mobile) {
        if (!mobile.matches("91\\s[6-9][0-9]{9}")) {
            throw new UserRegistrationException("Invalid Mobile Number");
        }
        return true;
    }

    public static boolean validatePassword(String password) {
        if (!password.matches("(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=]).{8,}")) {
            throw new UserRegistrationException("Invalid Password");
        }
        return true;
    }
}
