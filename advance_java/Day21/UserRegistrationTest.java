import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserRegistrationTest {

    UserRegistration userRegistration = new UserRegistration();

    // ---------- HAPPY TEST CASES ----------
    @ParameterizedTest
    @ValueSource(strings = {
            "abc@yahoo.com",
            "abc.100@yahoo.com",
            "abc.xyz@bl.co.in",
            "abc-100@abc.net",
            "abc@1.com",
            "abc@gmail.com"
    })
    void givenValidEmails_whenValidated_shouldReturnTrue(String email)
            throws UserRegistration.UserRegistrationException {

        boolean result = userRegistration.validateEmail(email);
        Assertions.assertTrue(result);
    }

    // ---------- SAD TEST CASES ----------
    @ParameterizedTest
    @ValueSource(strings = {
            "abc",
            "abc@.com",
            "abc@com",
            "abc@com.",
            "abc@%*.com",
            "abc..2002@gmail.com",
            ".abc@abc.com"
    })
    void givenInvalidEmails_whenValidated_shouldThrowException(String email) {

        Assertions.assertThrows(
                UserRegistration.UserRegistrationException.class,
                () -> userRegistration.validateEmail(email)
        );
    }
}
