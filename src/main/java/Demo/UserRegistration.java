public class UserRegistration {

    public static void main(String[] args) {

        System.out.println(UserEntryValidator.FIRST_NAME.validate("Kishor")); // true
        System.out.println(UserEntryValidator.LAST_NAME.validate("Patra"));   // true
        System.out.println(UserEntryValidator.EMAIL.validate("abc.100@abc.com.au")); // true
        System.out.println(UserEntryValidator.MOBILE.validate("91 9919819801")); // true
        System.out.println(UserEntryValidator.PASSWORD.validate("Pass@123")); // true

        System.out.println(UserEntryValidator.FIRST_NAME.validate("ki")); // false
        System.out.println(UserEntryValidator.EMAIL.validate("abc..2002@gmail.com")); // false
    }
}
