import java.util.Scanner;

public class UserRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        String regex = "^[a-zA-Z0-9]+([._+-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,}){1,2}$";

        if (email.matches(regex)) {
            System.out.println("Valid Email");
        } else {
            System.out.println("Invalid Email");
        }
    }
}
