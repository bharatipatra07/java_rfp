package OOPSBannerApp;

/**
 * OOPSBannerApp UC3 - OOPS Banner Application (Use Case 3)
 *
 * This class extends the functionality of Use Case 2 by improving the way the "OOPS" banner
 * is constructed and displayed. It uses the String.join() method to create each line of the
 * banner, improving code readability and memory efficiency.
 *
 * @author Bharati
 * @version 3.0
 */

public class OOPSBannerApp {
    public static void main(String[] args) {

        System.out.println(String.join(" ",
                "   ***   ", "   ***   ", "  *****  ", "  *****  "));

        System.out.println(String.join(" ",
                " **   ** ", " **   ** ", " **   ** ", " **      "));

        System.out.println(String.join(" ",
                " **   ** ", " **   ** ", " **   ** ", " **      "));

        System.out.println(String.join(" ",
                " **   ** ", " **   ** ", "  *****  ", "  *****  "));

        System.out.println(String.join(" ",
                " **   ** ", " **   ** ", " **      ", "      ** "));

        System.out.println(String.join(" ",
                " **   ** ", " **   ** ", " **      ", "      ** "));

        System.out.println(String.join(" ",
                "   ***   ", "   ***   ", " **      ", "  *****  "));
    }
}
