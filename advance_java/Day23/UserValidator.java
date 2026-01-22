package Day23;

@FunctionalInterface
 interface UserInputValidator {
    boolean validate(String input);
}

public class UserValidator {

    // First Name: Starts with Capital, min 3 chars
    public static final UserInputValidator FIRST_NAME =
            name -> name.matches("[A-Z][a-zA-Z]{2,}");

    // Last Name: Starts with Capital, min 3 chars
    public static final UserInputValidator LAST_NAME =
            name -> name.matches("[A-Z][a-zA-Z]{2,}");

    // Email Validation
    public static final UserInputValidator EMAIL =
            email -> email.matches(
                    "^[a-zA-Z0-9]+([._+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2})?$"
            ) && !email.contains("..");

    // Mobile: Country code + space + 10 digit number
    public static final UserInputValidator MOBILE =
            mobile -> mobile.matches("[0-9]{2} [0-9]{10}");

    // Password Rules:
    // min 8 chars, 1 uppercase, 1 number, exactly 1 special char
    public static final UserInputValidator PASSWORD =
            password -> password.length() >= 8
                    && password.matches(".*[A-Z].*")
                    && password.matches(".*[0-9].*")
                    && password.replaceAll("[a-zA-Z0-9]", "").length() == 1;
}
