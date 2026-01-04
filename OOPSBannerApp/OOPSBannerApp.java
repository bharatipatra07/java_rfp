package OOPSBannerApp;

/**
 * OOPSBannerApp UC4 - Render OOPS as Banner using String Array and Loop
 *
 * This use case improves upon UC3 by using a String array to store banner lines
 * and iterating through them with a loop, eliminating hardcoded print statements
 * and improving modularity and reusability.
 *
 * @author Bharati
 * @version 4
 */

public class OOPSBannerApp {

    public static void main(String[] args) {

        String[] lines = new String[7];
        lines[0] = String.join(" ",
                "   ***   ", "   ***   ", "  *****  ", "  *****  ");

        lines[1] = String.join(" ",
                " **   ** ", " **   ** ", " **   ** ", " **      ");

        lines[2] = String.join(" ",
                " **   ** ", " **   ** ", " **   ** ", " **      ");

        lines[3] = String.join(" ",
                " **   ** ", " **   ** ", "  *****  ", "  *****  ");

        lines[4] = String.join(" ",
                " **   ** ", " **   ** ", " **      ", "      ** ");

        lines[5] = String.join(" ",
                " **   ** ", " **   ** ", " **      ", "      ** ");

        lines[6] = String.join(" ",
                "   ***   ", "   ***   ", " **      ", "  *****  ");
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
