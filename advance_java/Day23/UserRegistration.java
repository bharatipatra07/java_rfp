
@FunctionalInterface
interface UserInputValidator {
    boolean validate(String input);
}
public class UserRegistration {

    public static void main(String[] args) {
        UserInputValidator hasUpperCase =
                password -> password.matches(".*[A-Z].*");

        UserInputValidator hasNumber =
                password -> password.matches(".*[0-9].*");

        UserInputValidator passwordValidator =
                password -> password.length() >= 8
                        && hasUpperCase.validate(password)
                        && hasNumber.validate(password);

        // Test cases
        System.out.println(passwordValidator.validate("Pass@123")); // true
        System.out.println(passwordValidator.validate("Password")); // false
        System.out.println(passwordValidator.validate("pass1234")); // false
        System.out.println(passwordValidator.validate("Pass12"));   // false
    }
    }
}

