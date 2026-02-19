class LuhnsAlgorithm {
    long number;
    String string;
    int twoDigits;
    int firstDigit;
    int sumProduct = 0;

    LuhnsAlgorithm(Long n, String str) {
        this.number = n;
        this.string = str;

        // Finds the first digit and first two digits of the number
        this.twoDigits = Integer.parseInt(string.substring(0,2));
        this.firstDigit = (int) Math.floor(twoDigits/10);
    }

    Boolean LuhnsNumber() {
        // Loop iterates through every second value from the end of the number handling algorithm calculation
        for (int j=string.length()-2; j>=-1; j-=2) {
            int untouchedValue = string.charAt(j+1) - '0';
            if (j == -1) {
                sumProduct += untouchedValue;
                break;
            }
            int result = (string.charAt(j) - '0')*2;
            if (Integer.toString(result).length() == 2) {
                int secondResult = Integer.parseInt(Integer.toString(result).substring(1,2));
                int firstResult = (int) Math.floor(result/10);
                sumProduct += (secondResult + firstResult);
            } else {
                sumProduct += result;
            }
            sumProduct += untouchedValue;
        }

        // Checks if the result of Luhn's algorithm doesn't end with a '0', otherwise it calls main method again for input
        if (!Integer.toString(sumProduct).endsWith("0")) {
            System.err.println("INVALID NUMBER");
            // CCValidation.main(null);
            // System.exit(1);
        }

        return true;
    }

    String CardType() {
        // Final format check and output of card provider
        if (firstDigit == 4 && (string.length() == 13 || string.length() == 16)) {
            return "visa";
        } else if ((twoDigits >= 51 && twoDigits <= 55) && string.length() == 16) {
            return "mastercard";
        } else if ((twoDigits == 34 || twoDigits == 37) && string.length() == 15) {
            return "amex";
        } else {
            System.out.println("INVALID CARD TYPE");
            return null;
        }
    }
}

public class DontWaitForFunctionTest {
    public static void main(String[] args) {
        String string;
        Long number;
        int sumProduct = 0;

        // Loop waiting for the input to be consecutive digits 0-9 (can be a single digit)
        System.out.print("Number: ");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (true) { 
            String input = scanner.nextLine();

            if (input.matches("\\d+")) {
                number = Long.parseLong(input);
                string = Long.toString(number);
                break;
            } else {
                System.out.print("Number:");
            }
        }

        LuhnsAlgorithm numberCheck = new LuhnsAlgorithm(number, string);
        
        // THIS IS THE NOT WAITING PART !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        Runnable myrunnable = new Runnable() {
            public void run() {
                numberCheck.CardType();
            }
        };

        new Thread(myrunnable).start(); //Call it when you need to run the function
        // IT ENDS HERE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        if (numberCheck.CardType()==null && !numberCheck.LuhnsNumber()) {System.out.println("Number invalid"); DontWaitForFunctionTest.main(null);} 
        
        // Print card type
        System.out.println(numberCheck.CardType().toString().toUpperCase());
        
    }
}