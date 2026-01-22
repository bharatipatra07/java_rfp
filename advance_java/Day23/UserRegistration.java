
@FunctionalInterface
interface UserInputValidator {
    boolean validate(String input);
}
public class UserRegistration {

    public static void main(String[] args) {

        UserInputValidator emailValidator = email -> {
            // Basic structure
            String emailRegex = "^[a-zA-Z0-9]+([._+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2})?$";
            // Ensure no double dots
            boolean noDoubleDots = !email.contains("..");
            // Ensure exactly one @
            boolean singleAt = email.chars().filter(ch -> ch == '@').count() == 1;
            // Ensure last character is not dot
            boolean lastCharNotDot = email.charAt(email.length() - 1) != '.';
            // Ensure first character is not dot
            boolean firstCharNotDot = email.charAt(0) != '.';

            return email.matches(emailRegex) && noDoubleDots && singleAt && lastCharNotDot && firstCharNotDot;
        };

        // Valid emails
        String[] validEmails = {
                "abc@yahoo.com",
                "abc-100@yahoo.com",
                "abc.100@yahoo.com",
                "abc111@abc.com",
                "abc-100@abc.net",
                "abc.100@abc.com.au",
                "abc@1.com",
                "abc@abc.com",
                "abc+100@gmail.com"
        };

        // Invalid emails
        String[] invalidEmails = {
                "abc", "abc@.com.my", "abc123@gmail.a", "abc123@.com", "abc123@.com.com",
                ".abc@abc.com", "abc()*@gmail.com", "abc@%*.com", "abc..2002@gmail.com",
                "abc.@gmail.com", "abc@abc@gmail.com", "abc@gmail.com.1a", "abc@gmail.com.aa.au"
        };

        System.out.println("Valid Emails:");
        for (String email : validEmails) {
            System.out.println(email + " -> " + emailValidator.validate(email));
        }

        System.out.println("\nInvalid Emails:");
        for (String email : invalidEmails) {
            System.out.println(email + " -> " + emailValidator.validate(email));
        }
    }
}

