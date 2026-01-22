
@FunctionalInterface
interface UserInputValidator {
    boolean validate(String input);
}
public class UserRegistration {

    public static void main(String[] args) {

        UserInputValidator firstNameValidator =
                name -> name.matches("[A-Z][a-zA-Z]{2,}");

        // Test cases
        System.out.println(firstNameValidator.validate("Kishor")); // true
        System.out.println(firstNameValidator.validate("ki"));     // false
        System.out.println(firstNameValidator.validate("Ki"));     // false
        System.out.println(firstNameValidator.validate("kishor")); // false
    }
}

