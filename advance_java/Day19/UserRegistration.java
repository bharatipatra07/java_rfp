import java.util.Scanner;

public class UserRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Mobile Number: ");
        String mobile = sc.nextLine();

        String regex = "^91 [0-9]{10}$";

        if (mobile.matches(regex)) {
            System.out.println("Valid Mobile Number");
        } else {
            System.out.println("Invalid Mobile Number");
        }
    }
}
