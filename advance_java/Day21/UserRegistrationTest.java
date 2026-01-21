import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

    UserRegistration userRegistration = new UserRegistration();

    // ---------- VALID TEST CASES ----------

    @Test
    void givenValidFirstName_shouldReturnTrue() throws UserRegistration.UserRegistrationException {
        Assertions.assertTrue(userRegistration.validateFirstName("Kishor"));
    }

    @Test
    void givenValidLastName_shouldReturnTrue() throws UserRegistration.UserRegistrationException {
        Assertions.assertTrue(userRegistration.validateLastName("Kumar"));
    }

    @Test
    void givenValidEmail_shouldReturnTrue() throws UserRegistration.UserRegistrationException {
        Assertions.assertTrue(userRegistration.validateEmail("abc.xyz@bl.co.in"));
    }

    @Test
    void givenValidMobile_shouldReturnTrue() throws UserRegistration.UserRegistrationException {
        Assertions.assertTrue(userRegistration.validateMobile("91 9919819801"));
    }

    @Test
    void givenValidPassword_shouldReturnTrue() throws UserRegistration.UserRegistrationException {
        Assertions.assertTrue(userRegistration.validatePassword("Abc@1234"));
    }

    // ---------- INVALID TEST CASES (Custom Exception) ----------

    @Test
    void givenInvalidFirstName_shouldThrowInvalidFirstNameException() {
        UserRegistration.UserRegistrationException exception =
                Assertions.assertThrows(
                        UserRegistration.UserRegistrationException.class,
                        () -> userRegistration.validateFirstName("ki")
                );

        Assertions.assertEquals(
                UserRegistration.UserRegistrationException.ExceptionType.INVALID_FIRST_NAME,
                exception.type);
    }

    @Test
    void givenInvalidLastName_shouldThrowInvalidLastNameException() {
        UserRegistration.UserRegistrationException exception =
                Assertions.assertThrows(
                        UserRegistration.UserRegistrationException.class,
                        () -> userRegistration.validateLastName("ku")
                );

        Assertions.assertEquals(
                UserRegistration.UserRegistrationException.ExceptionType.INVALID_LAST_NAME,
                exception.type);
    }

    @Test
    void givenInvalidEmail_shouldThrowInvalidEmailException() {
        UserRegistration.UserRegistrationException exception =
                Assertions.assertThrows(
                        UserRegistration.UserRegistrationException.class,
                        () -> userRegistration.validateEmail("abc@.com")
                );

        Assertions.assertEquals(
                UserRegistration.UserRegistrationException.ExceptionType.INVALID_EMAIL,
                exception.type);
    }

    @Test
    void givenInvalidMobile_shouldThrowInvalidMobileException() {
        UserRegistration.UserRegistrationException exception =
                Assertions.assertThrows(
                        UserRegistration.UserRegistrationException.class,
                        () -> userRegistration.validateMobile("919919819801")
                );

        Assertions.assertEquals(
                UserRegistration.UserRegistrationException.ExceptionType.INVALID_MOBILE,
                exception.type);
    }

    @Test
    void givenInvalidPassword_shouldThrowInvalidPasswordException() {
        UserRegistration.UserRegistrationException exception =
                Assertions.assertThrows(
                        UserRegistration.UserRegistrationException.class,
                        () -> userRegistration.validatePassword("abc123")
                );

        Assertions.assertEquals(
                UserRegistration.UserRegistrationException.ExceptionType.INVALID_PASSWORD,
                exception.type);
    }
}
