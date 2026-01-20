import java.util.Scanner;

public class UserRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();

        String regex = "^[A-Z][a-z]{2,}$";

        if (lastName.matches(regex)) {
            System.out.println("Valid Last Name");
        } else {
            System.out.println("Invalid Last Name");
        }
    }
}
