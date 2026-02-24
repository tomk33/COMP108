/**
 * A class that implements a Caesar cipher
 */
public class Caesar {
    /**
     * A class that shifts a character by a given amount
     */
    public static char rotate(int shift, char ch) {
        char baseChar;

        if (ch >= 'a' && ch <= 'z') {
            baseChar = 'a';
        } else if (ch >= 'A' && ch <= 'Z') {
            baseChar = 'A';
        } else {
            return ch;
        }

        int unicodeSum = (ch - baseChar + (shift % 26) + 26) % 26;
        char k = (char) (unicodeSum + baseChar);
        return k;
        
    }

    /**
     * Rotates an entire string by a given shift.
     */
    public static String rotate(int shift, String str) {
        String newStr = "";
        for (char ch : str.toCharArray()) {
            newStr += rotate(shift, ch);
        }
        return newStr;
    }

    /**
     * Main method to handle command line arguments and print the result
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Caesar n \"cipher text\"");
            System.exit(1);
        } else if (args.length > 2) {
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Caesar n \"cipher text\"");
            System.exit(1);
        }

        String message = args[1];
        int shift = Integer.parseInt(args[0], 10);
        System.out.println(rotate(shift, message));
    }
}
