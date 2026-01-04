import java.util.HashMap;

/**
 * OOPSBannerApp UC8 – Advanced OOP Concepts Implementation
 *
 * This use case uses the Java Collections Framework (HashMap)
 * to manage ASCII art patterns for characters and render
 * the banner dynamically for a given message.
 *
 * @author Bharati
 * @version 8.0
 */
public class OOPSBannerApp {

    public static HashMap<Character, String[]> createCharacterMap() {

        HashMap<Character, String[]> charMap = new HashMap<>();

        charMap.put('O', new String[]{
                "   ***   ",
                " **   ** ",
                " **   ** ",
                " **   ** ",
                " **   ** ",
                " **   ** ",
                "   ***   "
        });

        charMap.put('P', new String[]{
                "  *****  ",
                " **   ** ",
                " **   ** ",
                "  *****  ",
                " **      ",
                " **      ",
                " **      "
        });

        charMap.put('S', new String[]{
                "  *****  ",
                " **      ",
                " **      ",
                "  *****  ",
                "      ** ",
                "      ** ",
                "  *****  "
        });

        return charMap;
    }

    public static void displayBanner(String message,
                                     HashMap<Character, String[]> charMap) {

        int patternHeight = charMap.get(message.charAt(0)).length;

        for (int line = 0; line < patternHeight; line++) {
            StringBuilder sb = new StringBuilder();

            for (char ch : message.toCharArray()) {
                String[] pattern = charMap.get(ch);
                sb.append(pattern[line]).append(" ");
            }

            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {

        HashMap<Character, String[]> charMap = createCharacterMap();
        String message = "OOPS";

        displayBanner(message, charMap);
    }
}
