
public class Exec_timer {
    public static void main(String[] args) {

        // This reads some number from the terminal.
        // Don't worry about this for now and just use the variable
        System.out.print("Number:");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        long number = scanner.nextLong();
        // Start stopwatch
        long startTime = System.currentTimeMillis();

        int twoDigits = Integer.parseInt(Long.toString(number).substring(0,2));
        int firstDigit = Integer.parseInt(Long.toString(number).substring(0,1));
        //int firstDigit = (int) Math.floor(twoDigits/10);

        // Stop stopwatch
        long endTime = System.currentTimeMillis();
        long elapsedMillis = endTime - startTime;

        // Convert time
        long seconds = (elapsedMillis / 1000) % 60;
        long centiseconds = (elapsedMillis % 1000) / 10;

        String elapsedTime = String.format("%02d:%02d", seconds, centiseconds);

        if (firstDigit == 4) {

            System.out.println("VISA");
        } else if (twoDigits >= 51 && twoDigits <= 55) {
            System.out.println("MASTERCARD");
        } else if (twoDigits == 34 || twoDigits == 37) {
            System.out.println("AMEX");       
        } else {
            System.out.println("CARD NUMBER NOT RECOGNISED");
        }

        // Print time taken
        System.out.println("Time taken: " + elapsedTime);
    }
}