
@FunctionalInterface
interface UserInputValidator {
    boolean validate(String input);
}
public class UserRegistration {

    public static void main(String[] args) {

        UserInputValidator lastNameValidator =
                lastName -> lastName.matches("[A-Z][a-zA-Z]{2,}");

        // Test cases
        System.out.println(lastNameValidator.validate("Patra"));   // true
        System.out.println(lastNameValidator.validate("pa"));      // false
        System.out.println(lastNameValidator.validate("Pa"));      // false
        System.out.println(lastNameValidator.validate("patra"));   // false
    }
}

