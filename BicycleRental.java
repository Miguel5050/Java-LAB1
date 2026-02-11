import java.util.Scanner;

/**
 * Bicycle Rental Program
 * Calculates rental cost based on time of day rates
 * 
 * Rate Structure:
 * - 0-7 and 21-24: 500 RWF per hour
 * - 7-14 and 19-21: 1000 RWF per hour
 * - 14-19: 1500 RWF per hour
 */
public class BicycleRental {
    
    // Rate constants
    private static final int RATE_LOW = 500;      // Night/Early morning rate
    private static final int RATE_MEDIUM = 1000;  // Standard rate
    private static final int RATE_HIGH = 1500;    // Peak rate
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Display welcome message
        System.out.println("===================================");
        System.out.println("  BICYCLE RENTAL SYSTEM");
        System.out.println("===================================\n");
        
        // Get starting time
        System.out.print("Enter starting time (0-23): ");
        int startTime = scanner.nextInt();
        
        // Get ending time
        System.out.print("Enter ending time (1-24): ");
        int endTime = scanner.nextInt();
        
        // Validate input
        if (!isValidInput(startTime, endTime)) {
            System.out.println("\nERROR: Invalid input!");
            System.out.println("Please ensure:");
            System.out.println("- Start time is between 0 and 23");
            System.out.println("- End time is between 1 and 24");
            System.out.println("- Start time is less than end time");
            scanner.close();
            return;
        }
        
        // Calculate total cost
        int totalCost = calculateRentalCost(startTime, endTime);
        
        // Display results
        displayReceipt(startTime, endTime, totalCost);
        
        scanner.close();
    }
    
    /**
     * Validates the input times
     */
    private static boolean isValidInput(int startTime, int endTime) {
        return startTime >= 0 && startTime <= 23 &&
               endTime >= 1 && endTime <= 24 &&
               startTime < endTime;
    }
    
    /**
     * Calculates the total rental cost based on hourly rates
     */
    private static int calculateRentalCost(int startTime, int endTime) {
        int totalCost = 0;
        
        // Iterate through each hour of the rental period
        for (int hour = startTime; hour < endTime; hour++) {
            int hourlyRate = getHourlyRate(hour);
            totalCost += hourlyRate;
        }
        
        return totalCost;
    }
    
    /**
     * Determines the rate for a specific hour
     */
    private static int getHourlyRate(int hour) {
        if ((hour >= 0 && hour < 7) || (hour >= 21 && hour < 24)) {
            // Night/Early morning: 0-7 and 21-24
            return RATE_LOW;
        } else if ((hour >= 7 && hour < 14) || (hour >= 19 && hour < 21)) {
            // Standard hours: 7-14 and 19-21
            return RATE_MEDIUM;
        } else {
            // Peak hours: 14-19
            return RATE_HIGH;
        }
    }
    
    /**
     * Displays a detailed receipt
     */
    private static void displayReceipt(int startTime, int endTime, int totalCost) {
        System.out.println("\n===================================");
        System.out.println("  RENTAL RECEIPT");
        System.out.println("===================================");
        System.out.println("Start Time:     " + formatTime(startTime));
        System.out.println("End Time:       " + formatTime(endTime));
        System.out.println("Duration:       " + (endTime - startTime) + " hour(s)");
        System.out.println("-----------------------------------");
        
        // Show hourly breakdown
        System.out.println("\nHourly Breakdown:");
        for (int hour = startTime; hour < endTime; hour++) {
            int rate = getHourlyRate(hour);
            System.out.printf("%s - %s: %d RWF\n", 
                formatTime(hour), formatTime(hour + 1), rate);
        }
        
        System.out.println("-----------------------------------");
        System.out.println("TOTAL COST:     " + totalCost + " RWF");
        System.out.println("===================================\n");
        System.out.println("Thank you for choosing our service!");
    }
    
    /**
     * Formats hour to readable time format
     */
    private static String formatTime(int hour) {
        return String.format("%02d:00", hour);
    }
}