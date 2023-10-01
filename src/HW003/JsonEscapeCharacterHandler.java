package HW003;

import java.util.Optional;

/**
 * Handler for processing JSON escape characters.
 */
public class JsonEscapeCharacterHandler {

    /**
     * Handles escape characters in a JSON string and returns the processed string.
     *
     * @param str JSON string with escape characters
     * @return Processed string with escape characters replaced
     */
    public String handleEscapedCharacters(String str) {
        StringBuilder result = new StringBuilder();
        boolean isEscaping = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (isEscaping) {
                result.append(processEscapedCharacter(c, str, i).orElse(c));
                isEscaping = false;
            } else if (c == '\\') {
                isEscaping = true;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    private Optional<Character> processEscapedCharacter(char c, String str, int index) {
        return switch (c) {
            case 'n' -> Optional.of('\n');
            case '"' -> Optional.of('"');
            case 't' -> Optional.of('\t');
            case 'r' -> Optional.of('\r');
            case 'b' -> Optional.of('\b');
            case 'u' -> {
                if (index + 3 < str.length()) {
                    String unicodeChar = str.substring(index + 1, index + 5);
                    yield Optional.of((char) Integer.parseInt(unicodeChar, 16));
                } else {
                    yield Optional.empty();
                }
            }
            default -> Optional.empty();
        };
    }
}
