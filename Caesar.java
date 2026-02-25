/**
 * A class that implements a Caesar cipher.
 * @author Tom Kelly
 */
public class Caesar {
    /**
     * Shifts/Rotates an alphabetic character by a given amount.
     * @param shift The number of positions to move forwards (+ve) or backwards (-ve) in the alphabet.
     * @param ch The character to be rotated.
     * @return The rotated character if alphabetic, otherwise the original character.
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
        return (char) (unicodeSum + baseChar);
    }

    /**
     * Rotates an entire string of characters by a given shift (essentially encrypting it).
     * @param shift The number of positions to shift each character.
     * @param str The string to be encrypted.
     * @return A new string containing the shifted characters.
     */
    public static String rotate(int shift, String str) {
        String newStr = "";
        for (char ch : str.toCharArray()) {
            newStr += rotate(shift, ch);
        }
        return newStr;
    }

    /**
     * Main method takes a shift and a message and performs the Caesar cipher.
     * args[0] is the integer shift amount.
     * args[1] is the message text to be encrypted.
     * @param args Command line arguments.
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