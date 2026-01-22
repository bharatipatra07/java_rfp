
@FunctionalInterface
interface UserInputValidator {
    boolean validate(String input);
}
public class UserRegistration {

    public static void main(String[] args) {
        UserInputValidator hasUpperCase =
                password -> password.matches(".*[A-Z].*");

        UserInputValidator passwordValidator =
                password -> password.length() >= 8
                        && hasUpperCase.validate(password);

        // Test cases
        System.out.println(passwordValidator.validate("Pass@123")); // true
        System.out.println(passwordValidator.validate("pass@123")); // false
        System.out.println(passwordValidator.validate("PASSWORD")); // true
        System.out.println(passwordValidator.validate("Pass12"));   // false
    }
    }
}

