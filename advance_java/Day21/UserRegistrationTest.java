package Day21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class UserRegistrationTest {

    UserRegistration userRegistration = new UserRegistration();

    // HAPPY TEST CASES

    @Test
    void givenValidFirstName_whenValidated_shouldReturnTrue() throws UserRegistration.UserRegistrationException {
        boolean result = userRegistration.validateFirstName("Kishor");
        Assertions.assertTrue(result);
    }

    @Test
    void givenValidLastName_whenValidated_shouldReturnTrue() throws UserRegistration.UserRegistrationException {
        boolean result = userRegistration.validateLastName("Kumar");
        Assertions.assertTrue(result);
    }

    @Test
    void givenValidEmail_whenValidated_shouldReturnTrue() throws UserRegistration.UserRegistrationException {
        boolean result = userRegistration.validateEmail("abc.xyz@bl.co.in");
        Assertions.assertTrue(result);
    }

    @Test
    void givenValidMobile_whenValidated_shouldReturnTrue() throws UserRegistration.UserRegistrationException {
        boolean result = userRegistration.validateMobile("91 9919819801");
        Assertions.assertTrue(result);
    }

    @Test
    void givenValidPassword_whenValidated_shouldReturnTrue() throws UserRegistration.UserRegistrationException {
        boolean result = userRegistration.validatePassword("Abc@1234");
        Assertions.assertTrue(result);
    }

    //  SAD TEST CASES

    @Test
    void givenInvalidFirstName_whenValidated_shouldThrowException() {
        Assertions.assertThrows(
                UserRegistration.UserRegistrationException.class,
                () -> userRegistration.validateFirstName("ki")
        );
    }

    @Test
    void givenInvalidLastName_whenValidated_shouldThrowException() {
        Assertions.assertThrows(
                UserRegistration.UserRegistrationException.class,
                () -> userRegistration.validateLastName("ku")
        );
    }

    @Test
    void givenInvalidEmail_whenValidated_shouldThrowException() {
        Assertions.assertThrows(
                UserRegistration.UserRegistrationException.class,
                () -> userRegistration.validateEmail("abc@.com")
        );
    }

    @Test
    void givenInvalidMobile_whenValidated_shouldThrowException() {
        Assertions.assertThrows(
                UserRegistration.UserRegistrationException.class,
                () -> userRegistration.validateMobile("919919819801")
        );
    }

    @Test
    void givenInvalidPassword_whenValidated_shouldThrowException() {
        Assertions.assertThrows(
                UserRegistration.UserRegistrationException.class,
                () -> userRegistration.validatePassword("abc123")
        );
    }
}

