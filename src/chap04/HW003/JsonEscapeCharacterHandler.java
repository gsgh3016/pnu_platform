package chap04.HW003;

public class JsonEscapeCharacterHandler {
    public String handleEscapedCharacters(String str) {
        StringBuilder sb = new StringBuilder();
        boolean isEscape = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (isEscape) {
                switch (c) {
                    case '"' -> sb.append('"');
                    case 'b' -> sb.append('\b');
                    case 'f' -> sb.append('\f');
                    case 'n' -> sb.append('\n');
                    case 'r' -> sb.append('\r');
                    case 't' -> sb.append('\t');
                    case 'u' -> {
                        String next = str.substring(i + 1, i + 5);
                        i += 4;
                        int ch = Integer.parseInt(next, 16);
                        sb.append((char) ch);
                    }
                }
                isEscape = false;
            } else if (c == '\\') {
                isEscape = true;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}