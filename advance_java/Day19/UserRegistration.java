import java.util.Scanner;

public class UserRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        String regex = "^(?=.*[A-Z])(?=.*[0-9]).{8,}$";

        if (password.matches(regex)) {
            System.out.println("Password is valid (Rules 1, 2, 3 passed)");
        } else {
            System.out.println("Password is invalid");
        }
    }
}
