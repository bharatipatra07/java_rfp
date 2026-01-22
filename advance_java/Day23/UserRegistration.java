
@FunctionalInterface
interface UserInputValidator {
    boolean validate(String input);
}
public class UserRegistration {

    public static void main(String[] args) {
        UserInputValidator emailValidator =
                email -> email.matches(
                        "^[a-z]{3}(\\.[a-z]{3})?@[a-z]{2}\\.[a-z]{2}(\\.[a-z]{2})?$"
                );

        // Test cases
        System.out.println(emailValidator.validate("abc@bl.co"));           // true
        System.out.println(emailValidator.validate("abc.xyz@bl.co.in"));    // true
        System.out.println(emailValidator.validate("abc@bl.co.in"));        // true
        System.out.println(emailValidator.validate("abc@bl"));              // false
        System.out.println(emailValidator.validate("abc.xyz@bl.co.ind"));   // false
        System.out.println(emailValidator.validate("ab@bl.co"));            // false
    }
}

