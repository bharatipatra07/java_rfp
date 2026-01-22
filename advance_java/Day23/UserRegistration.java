import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
@FunctionalInterface
interface UserInputValidator {
    boolean validate(String input);
}
public class EmailValidator {

    public static final UserInputValidator EMAIL =
            email -> email.matches(
                    "^[a-zA-Z0-9]+([._+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2})?$"
            ) && !email.contains("..");
}

public class EmailValidatorParameterizedTest {

    // HAPPY TEST CASES
    @ParameterizedTest
    @ValueSource(strings = {
            "abc@yahoo.com",
            "abc-100@yahoo.com",
            "abc.100@yahoo.com",
            "abc111@abc.com",
            "abc-100@abc.net",
            "abc.100@abc.com.au",
            "abc@1.com",
            "abc+100@gmail.com"
    })
    void givenValidEmails_shouldReturnTrue(String email) {
        Assertions.assertTrue(EmailValidator.EMAIL.validate(email));
    }

    // SAD TEST CASES
    @ParameterizedTest
    @ValueSource(strings = {
            "abc",
            "abc@.com.my",
            "abc123@gmail.a",
            "abc123@.com",
            "abc123@.com.com",
            ".abc@abc.com",
            "abc()*@gmail.com",
            "abc@%*.com",
            "abc..2002@gmail.com",
            "abc.@gmail.com",
            "abc@abc@gmail.com",
            "abc@gmail.com.1a",
            "abc@gmail.com.aa.au"
    })
    void givenInvalidEmails_shouldReturnFalse(String email) {
        Assertions.assertFalse(EmailValidator.EMAIL.validate(email));
    }
}
