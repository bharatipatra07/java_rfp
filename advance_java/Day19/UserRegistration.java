import java.util.Scanner;

public class UserRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        String regex = "^(?=.*[A-Z]).{8,}$";

        if (password.matches(regex)) {
            System.out.println("Password valid as per Rule 2");
        } else {
            System.out.println("Password invalid as per Rule 2");
        }
    }
}
