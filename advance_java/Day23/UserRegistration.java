
@FunctionalInterface
interface UserInputValidator {
    boolean validate(String input);
}
public class UserRegistration {

    public static void main(String[] args) {
        UserInputValidator passwordValidator =
                password -> password.length() >= 8;

        // Test cases
        System.out.println(passwordValidator.validate("Pass@123")); // true
        System.out.println(passwordValidator.validate("Pass12"));   // false
        System.out.println(passwordValidator.validate("12345678")); // true
        System.out.println(passwordValidator.validate("abc"));      // false

    }
}

