
@FunctionalInterface
interface UserInputValidator {
    boolean validate(String input);
}
public class UserRegistration {

    public static void main(String[] args) {
        UserInputValidator mobileValidator =
                mobile -> mobile.matches("^[0-9]{2} [0-9]{10}$");

        // Test cases
        System.out.println(mobileValidator.validate("91 9919819801")); // true
        System.out.println(mobileValidator.validate("91 991981980"));  // false
        System.out.println(mobileValidator.validate("919919819801"));  // false
        System.out.println(mobileValidator.validate("91-9919819801")); // false
        System.out.println(mobileValidator.validate("1 9919819801"));  // false
    }
}

