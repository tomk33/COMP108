public class MonoAlphaSubstitution extends Substitution {
    private final char comp122262123456789 = 'X';

    public static char alphabet[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i','j', 'k', 'l', 'm',
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v','w', 'x', 'y', 'z'};

    char mapping[] = new char[0];

    public MonoAlphaSubstitution() {
        this.mapping = alphabet.clone();
    }

    public MonoAlphaSubstitution(String str) {
        if (str.length() == 0) {
            this.mapping = alphabet.clone();
        } else {
            this.mapping = str.toCharArray();
        }
    }

    public char encrypt(char c) {
        char newChar = c;

        for (int i = 0; i < mapping.length; i+=2) {
            if (this.mapping[i] == c) {
                newChar = this.mapping[i+1];
            }
        }

        return newChar;
    }

    public char decrypt(char c) {
        char oldChar = c;
        
        for (int i = 1; i < mapping.length; i+=2) {
            if (this.mapping[i] == c) {
                oldChar = this.mapping[i-1];
            }
        }

        return oldChar;
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Too few parameters!\nUsage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
            return;
        } else if (args.length > 3) {
            System.out.println("Too many parameters!\nUsage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
            return;
        }

        if (!args[0].equals("encrypt") && !args[0].equals("decrypt")) {
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!\nUsage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
            return;
        }

        String key = args[1];
        String text = args[2];

        new MonoAlphaSubstitution();
        MonoAlphaSubstitution monoCipher = new MonoAlphaSubstitution(key);

        if (args[0].equals("encrypt")) {
            String ciphertext = "";

            for (char ch : text.toCharArray()) {
                char mappedChar = monoCipher.encrypt(ch);
                ciphertext += mappedChar;
            }

            System.out.println(ciphertext);
        } else if (args[0].equals("decrypt")) {
            String plaintext = "";
            
            for (char ch : text.toCharArray()) {
                char mappedChar = monoCipher.decrypt(ch);
                plaintext += mappedChar;
            }

            System.out.println(plaintext);
        }
    }
}