import java.util.Random;
import java.util.Scanner;

public class CoinFlip {

    public enum Coin {
        HEADS,
        TAILS
    }
    private int headsCount = 0;
    private int tailsCount = 0;
    private final Random random = new Random();


    public Coin flip() {
        return (random.nextInt(2) == 0) ? Coin.HEADS : Coin.TAILS;
    }
    public void runSimulation() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Toss Coin\n2. Exit");
            System.out.print("Enter choice (1 or 2): ");
            
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                
                if (choice == 1) {
                    Coin result = flip();
                    System.out.printf("\nResult: %s!\n", result);

                    if (result == Coin.HEADS) {
                        headsCount++;
                    } else {
                        tailsCount++;
                    }
                    
                    displayResults();
                    
                } else if (choice == 2) {
                    System.out.println("\nFinal Result:");
                    displayResults();
                } else {
                    System.out.println("Invalid Input!");
                }
            } else {
                System.out.println("Invalid Input!");
                scanner.next(); 
                choice = 0;
            }
        } while (choice != 2);

        scanner.close();
    }

    private void displayResults() {
        int totalTosses = headsCount + tailsCount;
        
        if (totalTosses > 0) {
            double headsPercentage = (double) headsCount / totalTosses * 100;
            double tailsPercentage = (double) tailsCount / totalTosses * 100;


            System.out.printf("Total Toss Count: %d\n", totalTosses);
            System.out.printf("Heads: %d (%.2f%%)\n", headsCount, headsPercentage);
            System.out.printf("Tails: %d (%.2f%%)\n", tailsCount, tailsPercentage);
        } else {
            System.out.println("No Tosses Done");
        }
    }
    public static void main(String[] args) {
        new CoinFlip().runSimulation();
    }
}