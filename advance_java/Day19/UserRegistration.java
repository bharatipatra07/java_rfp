import java.util.Scanner;

public class UserRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();

        String regex = "^[A-Z][a-z]{2,}$";

        if (firstName.matches(regex)) {
            System.out.println("Valid First Name");
        } else {
            System.out.println("Invalid First Name");
        }
    }
}
