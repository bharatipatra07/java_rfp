/**
 * OOPSBannerApp UC7 – Store Character Pattern in a Class
 *
 * This use case extends UC6 by implementing a CharacterPatternMap class
 * to encapsulate character-to-pattern mappings. The application retrieves
 * and displays the "OOPS" banner using these mappings, improving modularity
 * and code organization.
 *
 * @author Bharati
 * @version 7.0
 */
public class OOPSBannerApp {

    static class CharacterPatternMap {

        private final Character character;

        private final String[] pattern;

        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        public Character getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern;
        }
    }

    public static CharacterPatternMap[] createCharacterPatternMaps() {

        return new CharacterPatternMap[] {

                new CharacterPatternMap('O', new String[] {
                        "   ***   ",
                        " **   ** ",
                        " **   ** ",
                        " **   ** ",
                        " **   ** ",
                        " **   ** ",
                        "   ***   "
                }),

                new CharacterPatternMap('P', new String[] {
                        "  *****  ",
                        " **   ** ",
                        " **   ** ",
                        "  *****  ",
                        " **      ",
                        " **      ",
                        " **      "
                }),

                new CharacterPatternMap('S', new String[] {
                        "  *****  ",
                        " **      ",
                        " **      ",
                        "  *****  ",
                        "      ** ",
                        "      ** ",
                        "  *****  "
                }),

                new CharacterPatternMap(' ', new String[] {
                        "         ",
                        "         ",
                        "         ",
                        "         ",
                        "         ",
                        "         ",
                        "         "
                })
        };
    }


    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] charMaps) {

        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }

        return getCharacterPattern(' ', charMaps);
    }


    public static void printMessage(String message, CharacterPatternMap[] charMaps) {

        for (int row = 0; row < 7; row++) {

            StringBuilder line = new StringBuilder();

            for (char ch : message.toCharArray()) {
                String[] pattern = getCharacterPattern(ch, charMaps);
                line.append(pattern[row]).append(" ");
            }

            System.out.println(line.toString());
        }
    }
    public static void main(String[] args) {

        CharacterPatternMap[] charMaps = createCharacterPatternMaps();
        String message = "OOPS";

        printMessage(message, charMaps);
    }
}
