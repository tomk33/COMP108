abstract class Substitution {
    public abstract char encrypt(char c);
    public abstract char decrypt(char c);

    public String encrypt(String plaintext) {
        String encryptedString = "";

        for (char i : plaintext.toCharArray()) {
            encryptedString += encrypt(i);
        }

        return encryptedString;
    }

    public String decrypt(String ciphertext) {
        String decryptedString = "";

        for (char i : ciphertext.toCharArray()) {
            decryptedString += encrypt(i);
        }

        return decryptedString;
    }
}
