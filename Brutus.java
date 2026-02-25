/**
 * @author Tom Kelly
 * A class that brute forces the decryption of a Caesar cipher.
 */
public class Brutus {
    public static final double[] english = {
        0.0855, 0.0160, 0.0316, 0.0387, 0.1210, 0.0218, 0.0209, 0.0496, 0.0733,
        0.0022, 0.0081, 0.0421, 0.0253, 0.0717, 0.0747, 0.0207, 0.0010, 0.0633,
        0.0673, 0.0894, 0.0268, 0.0106, 0.0183, 0.0019, 0.0172, 0.0011
    };

    /**
     * Calculates the number of instances of characters and stores in an int array.
     * @param str The string to analyze.
     * @return An integer array of length 26, where index 0 is 'a' and 25 is 'z'.
     */
    public static int[] count(String str) {
        int[] arr = new int[26];

        String lowerStr = str.toLowerCase();

        for (char ch : lowerStr.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                int charValue = ch - 'a'; 
                arr[charValue] += 1;
            }
        }

        return arr;
    }

    /**
     * Calculates the frequency of each letter in the string and stores each in a double array.
     * @param str The string to analyze.
     * @return A double array representing the percentage of each letter's frequency (0.0 to 1.0)
     */
    public static double[] frequency(String str) {
        double[] letterFreqs = new double[26];
        int[] letterCount = count(str);
        int letterOnlyLength = 0;

        for (int c : letterCount) {
            letterOnlyLength += c;
        }

        for (int i=0; i<letterCount.length; i++) {
            letterFreqs[i] += (double) letterCount[i] / letterOnlyLength;
        }

        return letterFreqs;
    }

    /**
     * Calculates the chi squared value for 2 double arrays.
     * @param letterFreqs The observed frequencies from the cipher text.
     * @param english The expected frequencies for the English language.
     * @return The chi squared value.
     */
    public static double chiSquared(double[] letterFreqs, double[] english) {
        double chiValue = 0;

        for (int i=0; i<26; i++) {
            chiValue += Math.pow(letterFreqs[i]-english[i],2) / english[i];
        }

        return chiValue;
    }

    /**
     * Main method takes ciphertext and decodes by comparing chi-squared value for different shifts,
     * it prints the result with the lowest chi squared value.
     * @param args Command line arguments. Expects only one string: the ciphertext.
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Brutus \"cipher text\"");
            System.exit(1);
        } else if (args.length > 1) {
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Brutus \"cipher text\"");
            System.exit(1);
        }

        String cipherText = args[0];
        if (cipherText.length() == 0) System.exit(1);
        char[] shiftedText = new char[cipherText.length()];
        double lowestChi = 10000;
        String decodedString = "";

        for (int shiftAmount=0; shiftAmount<26; shiftAmount++) {
            for (int i = 0; i < cipherText.length(); i++) {
                char baseChar = ' ';
                char ch = cipherText.charAt(i);

                if (ch >= 'a' && ch <= 'z') {
                    baseChar = 'a';
                    int unicodeSum = (ch - baseChar + shiftAmount) % 26;
                    char rotatedChar = (char) (unicodeSum + baseChar);
                    shiftedText[i] = rotatedChar;
                } else if (ch >= 'A' && ch <= 'Z') {
                    baseChar = 'A';
                    int unicodeSum = (ch - baseChar + shiftAmount) % 26;
                    char rotatedChar = (char) (unicodeSum + baseChar);
                    shiftedText[i] = rotatedChar;
                } else {
                    shiftedText[i] = ch;
                }
            }

            String currentShift = new String(shiftedText);
            double newChi = chiSquared(frequency(currentShift), english);

            if (newChi < lowestChi) {
                lowestChi = newChi;
                decodedString = currentShift;
            }
        }
        System.out.println(decodedString);
    }
}
