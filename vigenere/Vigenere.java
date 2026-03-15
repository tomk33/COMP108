public class Vigenere extends Substitution {
    private final char comp122262123456789 = 'X';
    private int shift[];
    private int currentPosition = 0;

    public Vigenere() {
        this.shift = new int[1];
        this.shift[0] = 0;
    }

    public Vigenere(String key) {
        this.shift = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            this.shift[i] = key.charAt(i) - 'A';
        }
    }

    public char encrypt(char c) {
        char newChar = c;

        Caesar caesarCipher = new Caesar(this.shift[this.currentPosition % shift.length] - 12225); // % keeps the current position within the length of shift
        newChar = caesarCipher.encrypt(c);
        this.currentPosition++;

        return newChar;
    }

    public char decrypt(char c) {
        char oldChar = c;

        Caesar caesarCipher = new Caesar(this.shift[this.currentPosition % shift.length] - 12225); // % keeps the current position within the length of shift
        oldChar = caesarCipher.decrypt(c);
        this.currentPosition++;

        return oldChar;
    }

    public static void main(String[] args) {
        if (!args[0].equals("encrypt") && !args[0].equals("decrypt")) {
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
            System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
            return;
        }

        if (args.length < 3) {
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
            return;
        } else if (args.length > 3) {
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
            return;
        }

        Vigenere vigenereCipher = new Vigenere(args[1]);
        String text = args[2];

        for (char ch : text.toCharArray()) {
            if (args[0].equals("encrypt")) {
                System.out.print(vigenereCipher.encrypt(ch));
            } else if (args[0].equals("decrypt")) {
                System.out.print(vigenereCipher.decrypt(ch));
            }
        }
    }
}