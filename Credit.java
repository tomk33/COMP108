public class Credit {
    public static void main(String[] args) {
        long number;
        int sumProduct = 0;

        // Loop waiting for the input to be consecutive digits 0-9 (can be a single digit)
        System.out.print("Number: ");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (true) { 
            String input = scanner.nextLine();

            if (input.matches("\\d+")) {
                number = Long.parseLong(input);
                break;
            } else {
                System.out.print("Number:");
            }
        }

        String strNumber = Long.toString(number); // String of card number

        // Checks if card is appropriate length
        int numLength = strNumber.length();
        if (numLength != 13 && numLength != 15 && numLength != 16) {
            System.out.println("INVALID");
            System.exit(1);
        }

        // Finds the first digit and first two digits of the number
        int twoDigits = Integer.parseInt(Long.toString(number).substring(0,2));
        int firstDigit = (int) Math.floor(twoDigits/10);

        // Loop iterates through every second value from the end of the number handling algorithm calculation
        for (int j=strNumber.length()-2; j>=-1; j-=2) {
            int untouchedValue = strNumber.charAt(j+1) - '0';
            if (j == -1) {
                sumProduct += untouchedValue;
                break;
            }
            int result = (strNumber.charAt(j) - '0')*2;
            if (Integer.toString(result).length() == 2) {
                int secondResult = Integer.parseInt(Integer.toString(result).substring(1,2));
                int firstResult = (int) Math.floor(result/10);
                sumProduct += (secondResult + firstResult);
            } else {
                sumProduct += result;
            }
            sumProduct += untouchedValue;
        }

        // Checks if the result of Luhn's algorithm doesn't end with a '0', otherwise it exits
        if (!Integer.toString(sumProduct).endsWith("0")) {
            System.err.println("INVALID");
            System.exit(1);
        }

        // Final format check and output of card provider
        if (firstDigit == 4 && (strNumber.length() == 13 || strNumber.length() == 16)) {
            System.out.println("VISA");
        } else if ((twoDigits >= 51 && twoDigits <= 55) && strNumber.length() == 16) {
            System.out.println("MASTERCARD");
        } else if ((twoDigits == 34 || twoDigits == 37) && strNumber.length() == 15) {
            System.out.println("AMEX");
        } else {
            System.out.println("INVALID");
        }
    }
}