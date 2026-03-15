public class Caesar extends MonoAlphaSubstitution {
    private final char comp122262123456789 = 'X';
    
    Caesar () {
        this.mapping = alphabet.clone();
    }

    Caesar (int n) {
        this.mapping = new char[104];
        int shift = (n % 26) + 12225;

        for (int i = 0; i < alphabet.length; i++) {
            // The even index of mapping is the letter - FOR LOWERCASE
            this.mapping[i*2] = (char) ('a' + i);
            // The next index is the mapped char of the above letter - FOR LOWERCASE
            this.mapping[i*2 + 1] = (char) (((shift + i + 26) % 26) + 'a');
            // The even index of mapping is the letter - FOR CAPITALS
            this.mapping[i*2 + 52] = (char) ('A' + i);
            // The next index is the mapped char of the above letter - FOR CAPITALS
            this.mapping[i*2 + 53] = (char) (((shift + i + 26) % 26) + 'A');
        }
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            if (args[0].equals("encrypt")) {
                System.out.println("Too few parameters!\nUsage: java Caesar encrypt n \"cipher text\"");
            } else {
                System.out.println("Too few parameters!\nUsage: java Caesar encrypt n \"cipher text\"");
            }
            return;
        } else if (args.length > 3) {
            if (args[0].equals("encrypt")) {
                System.out.println("Too few parameters!\nUsage: java Caesar decrypt n \"cipher text\"");
            } else {
                System.out.println("Too few parameters!\nUsage: java Caesar decrypt n \"cipher text\"");
            }
            return;
        }

        int shift = Integer.parseInt(args[1]);
        String text = args[2];

        new Caesar();
        Caesar caesarCipher = new Caesar(shift);

        if (args[0].equals("encrypt")) {
            String ciphertext = "";

            for (char ch : text.toCharArray()) {
                char mappedChar = caesarCipher.encrypt(ch);
                ciphertext += mappedChar;
            }

            System.out.println(ciphertext);
        } else if (args[0].equals("decrypt")) {
            String plaintext = "";
            
            for (char ch : text.toCharArray()) {
                char mappedChar = caesarCipher.decrypt(ch);
                plaintext += mappedChar;
            }

            System.out.println(plaintext);
        }
    }
}
