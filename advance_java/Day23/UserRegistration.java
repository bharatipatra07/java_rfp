import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
@FunctionalInterface
interface UserInputValidator {
    boolean validate(String input);
}
public class UserValidator {

    public static final UserInputValidator FIRST_NAME =
            name -> name.matches("[A-Z][a-zA-Z]{2,}");

    public static final UserInputValidator LAST_NAME =
            name -> name.matches("[A-Z][a-zA-Z]{2,}");

    public static final UserInputValidator EMAIL =
            email -> email.matches(
                    "^[a-zA-Z0-9]+([._+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2})?$"
            ) && !email.contains("..");

    public static final UserInputValidator MOBILE =
            mobile -> mobile.matches("[0-9]{2} [0-9]{10}");

    public static final UserInputValidator PASSWORD =
            password -> password.length() >= 8
                    && password.matches(".*[A-Z].*")
                    && password.matches(".*[0-9].*")
                    && password.replaceAll("[a-zA-Z0-9]", "").length() == 1;
}

public class UseRegistration {

    @Test
    void givenValidFirstName_shouldReturnTrue() {
        Assertions.assertTrue(UserValidator.FIRST_NAME.validate("Kishor"));
    }

    @Test
    void givenInvalidFirstName_shouldReturnFalse() {
        Assertions.assertFalse(UserValidator.FIRST_NAME.validate("ki"));
    }

    @Test
    void givenValidLastName_shouldReturnTrue() {
        Assertions.assertTrue(UserValidator.LAST_NAME.validate("Patra"));
    }

    @Test
    void givenInvalidLastName_shouldReturnFalse() {
        Assertions.assertFalse(UserValidator.LAST_NAME.validate("pa"));
    }

    @Test
    void givenValidEmail_shouldReturnTrue() {
        Assertions.assertTrue(UserValidator.EMAIL.validate("abc.100@abc.com.au"));
    }

    @Test
    void givenInvalidEmail_shouldReturnFalse() {
        Assertions.assertFalse(UserValidator.EMAIL.validate("abc..2002@gmail.com"));
    }

    @Test
    void givenValidMobile_shouldReturnTrue() {
        Assertions.assertTrue(UserValidator.MOBILE.validate("91 9919819801"));
    }

    @Test
    void givenInvalidMobile_shouldReturnFalse() {
        Assertions.assertFalse(UserValidator.MOBILE.validate("919919819801"));
    }

    @Test
    void givenValidPassword_shouldReturnTrue() {
        Assertions.assertTrue(UserValidator.PASSWORD.validate("Pass@123"));
    }

    @Test
    void givenInvalidPassword_shouldReturnFalse() {
        Assertions.assertFalse(UserValidator.PASSWORD.validate("pass@123"));
    }
}

