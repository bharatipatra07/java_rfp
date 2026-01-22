import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
@FunctionalInterface
interface UserInputValidator {
    void validate(String input) throws UserValidationException;
}

public class UserRegistration {

    // ---------- FIRST NAME ----------
    @Test
    void givenValidFirstName_shouldPass() {
        Assertions.assertDoesNotThrow(() ->
                UserValidator.FIRST_NAME.validate("Kishor"));
    }

    @Test
    void givenInvalidFirstName_shouldThrowException() {
        UserValidationException ex = Assertions.assertThrows(
                UserValidationException.class,
                () -> UserValidator.FIRST_NAME.validate("ki"));

        Assertions.assertEquals(
                UserValidationException.ExceptionType.INVALID_FIRST_NAME,
                ex.type);
    }

    // ---------- LAST NAME ----------
    @Test
    void givenValidLastName_shouldPass() {
        Assertions.assertDoesNotThrow(() ->
                UserValidator.LAST_NAME.validate("Patra"));
    }

    @Test
    void givenInvalidLastName_shouldThrowException() {
        UserValidationException ex = Assertions.assertThrows(
                UserValidationException.class,
                () -> UserValidator.LAST_NAME.validate("pa"));

        Assertions.assertEquals(
                UserValidationException.ExceptionType.INVALID_LAST_NAME,
                ex.type);
    }

    // ---------- EMAIL ----------
    @Test
    void givenValidEmail_shouldPass() {
        Assertions.assertDoesNotThrow(() ->
                UserValidator.EMAIL.validate("abc.100@abc.com.au"));
    }

    @Test
    void givenInvalidEmail_shouldThrowException() {
        UserValidationException ex = Assertions.assertThrows(
                UserValidationException.class,
                () -> UserValidator.EMAIL.validate("abc..2002@gmail.com"));

        Assertions.assertEquals(
                UserValidationException.ExceptionType.INVALID_EMAIL,
                ex.type);
    }

    // ---------- MOBILE ----------
    @Test
    void givenValidMobile_shouldPass() {
        Assertions.assertDoesNotThrow(() ->
                UserValidator.MOBILE.validate("91 9919819801"));
    }

    @Test
    void givenInvalidMobile_shouldThrowException() {
        UserValidationException ex = Assertions.assertThrows(
                UserValidationException.class,
                () -> UserValidator.MOBILE.validate("919919819801"));

        Assertions.assertEquals(
                UserValidationException.ExceptionType.INVALID_MOBILE,
                ex.type);
    }

    // ---------- PASSWORD ----------
    @Test
    void givenValidPassword_shouldPass() {
        Assertions.assertDoesNotThrow(() ->
                UserValidator.PASSWORD.validate("Pass@123"));
    }

    @Test
    void givenInvalidPassword_shouldThrowException() {
        UserValidationException ex = Assertions.assertThrows(
                UserValidationException.class,
                () -> UserValidator.PASSWORD.validate("pass@123"));

        Assertions.assertEquals(
                UserValidationException.ExceptionType.INVALID_PASSWORD,
                ex.type);
    }
}

