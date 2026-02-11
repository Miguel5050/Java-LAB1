import java.util.Scanner;

/**
 * Mushroom Identification Program
 * Identifies mushrooms based on user responses to questions about characteristics
 * 
 * Mushroom Types:
 * 1. Agaric Jaunissant
 * 2. Amanite tue-mouche
 * 3. Cepe de bordeaux
 * 4. Coprin chevelu
 * 5. Girolle
 * 6. Pied bleu
 */
public class MushroomIdentifier {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Display welcome message
        System.out.println("=========================================");
        System.out.println("  MUSHROOM IDENTIFICATION SYSTEM");
        System.out.println("=========================================");
        System.out.println("Think of one of these mushrooms:");
        System.out.println("1. Agaric Jaunissant");
        System.out.println("2. Amanite tue-mouche");
        System.out.println("3. Cepe de bordeaux");
        System.out.println("4. Coprin chevelu");
        System.out.println("5. Girolle");
        System.out.println("6. Pied bleu");
        System.out.println("=========================================\n");
        System.out.println("I will ask you questions to identify it.");
        System.out.println("Please answer with 'yes' or 'no'\n");
        
        String mushroom = identifyMushroom(scanner);
        
        System.out.println("\n=========================================");
        System.out.println("Your mushroom is: " + mushroom);
        System.out.println("=========================================");
        
        scanner.close();
    }
    
    /**
     * Identifies the mushroom through a decision tree approach
     */
    private static String identifyMushroom(Scanner scanner) {
        // Question 1: Does your mushroom have gills?
        System.out.print("Does your mushroom have gills? (yes/no): ");
        String hasGills = scanner.nextLine().trim().toLowerCase();
        
        if (hasGills.equals("no")) {
            // Only Cepe de bordeaux has pores (no gills)
            return "Cepe de bordeaux";
        }
        
        // All remaining mushrooms have gills
        // Question 2: Does your mushroom grow in a forest?
        System.out.print("Does your mushroom grow in a forest? (yes/no): ");
        String growsInForest = scanner.nextLine().trim().toLowerCase();
        
        if (growsInForest.equals("no")) {
            // Grows in meadows: Coprin chevelu or Agaric Jaunissant
            // Question 3: Does your mushroom have a ring?
            System.out.print("Does your mushroom have a ring? (yes/no): ");
            String hasRing = scanner.nextLine().trim().toLowerCase();
            
            if (hasRing.equals("yes")) {
                // Both have rings, need convex cup question
                System.out.print("Does your mushroom have a convex cup? (yes/no): ");
                String hasConvexCup = scanner.nextLine().trim().toLowerCase();
                
                if (hasConvexCup.equals("yes")) {
                    return "Agaric Jaunissant";
                } else {
                    return "Coprin chevelu";
                }
            } else {
                // No ring, grows in meadow - contradiction in given data
                // But Coprin chevelu has ring, so if no ring, must be error
                // However, we'll return based on logic
                return "Coprin chevelu";
            }
        } else {
            // Grows in forest: Amanite tue-mouche, Girolle, or Pied bleu
            // Question 3: Does your mushroom have a convex cup?
            System.out.print("Does your mushroom have a convex cup? (yes/no): ");
            String hasConvexCup = scanner.nextLine().trim().toLowerCase();
            
            if (hasConvexCup.equals("yes")) {
                // Forest mushrooms with convex cup: Amanite tue-mouche or Pied bleu
                // Both have different ring properties
                System.out.print("Does your mushroom have a ring? (yes/no): ");
                String hasRing = scanner.nextLine().trim().toLowerCase();
                
                if (hasRing.equals("yes")) {
                    return "Amanite tue-mouche";
                } else {
                    return "Pied bleu";
                }
            } else {
                // Forest mushroom without convex cup: Girolle
                return "Girolle";
            }
        }
    }
}