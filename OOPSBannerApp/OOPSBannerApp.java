/**
 * OOPSBannerApp UC6 - OOPS Banner Application (Use Case 6)
 *
 * This use case extends UC5 by implementing a modular approach to generate
 * each letter's pattern through dedicated helper methods. This improves
 * reusability, maintainability, and follows the DRY principle.
 *
 * @author Bharati
 * @version 6.0
 */

public class OOPSBannerApp {

    public static String[] getOPattern() {
        return new String[] {
                String.join("", "   ***   "),
                String.join("", " **   ** "),
                String.join("", " **   ** "),
                String.join("", " **   ** "),
                String.join("", " **   ** "),
                String.join("", " **   ** "),
                String.join("", "   ***   ")
        };
    }

    public static String[] getPPattern() {
        return new String[] {
                String.join("", "  *****  "),
                String.join("", " **   ** "),
                String.join("", " **   ** "),
                String.join("", "  *****  "),
                String.join("", " **      "),
                String.join("", " **      "),
                String.join("", " **      ")
        };
    }

    public static String[] getSPattern() {
        return new String[] {
                String.join("", "  *****  "),
                String.join("", " **      "),
                String.join("", " **      "),
                String.join("", "  *****  "),
                String.join("", "      ** "),
                String.join("", "      ** "),
                String.join("", "  *****  ")
        };
    }

    public static void main(String[] args) {

        String[] oPattern = getOPattern();
        String[] pPattern = getPPattern();
        String[] sPattern = getSPattern();

        for (int i = 0; i < oPattern.length; i++) {
            System.out.println(
                    String.join(" ",
                            oPattern[i],
                            oPattern[i],
                            pPattern[i],
                            sPattern[i]
                    )
            );
        }
    }
}
