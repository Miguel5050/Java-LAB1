public class MultiplicationTable {

    public static void main(String[] args) {
        int number = 5;

        System.out.println("=========================================");
        System.out.println("  MULTIPLICATION TABLE OF " + number);
        System.out.println("=========================================\n");

        // Outer loop (i) - represents the number we're multiplying by
        for (int i = 1; i <= 10; i++) {

            // Inner loop (j) - can be used for additional formatting or repetition
            for (int j = 1; j <= 1; j++) {
                int result = number * i;
                System.out.println(number + " x " + i + " = " + result);
            }
        }

        System.out.println("\n=========================================");
    }
}