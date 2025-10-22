import java.text.DecimalFormat;
import java.util.Scanner;

public class MileageCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        long totalMiles = 0;
        long totalGallons = 0;
        int tripCounter = 0;
        int currentMiles = 0;
        int currentGallons = 0;
        System.out.print("\nEnter miles driven (-1 to exit): ");

        
        if (input.hasNextInt()) {

            currentMiles = input.nextInt();
        } else {
            System.err.println("Invalid input.");
            return;
        }


        while (currentMiles != -1) {
            System.out.print("Enter gallons used for this trip: ");
            if (input.hasNextInt()) {
                currentGallons = input.nextInt();
                if (currentGallons <= 0) {
                    System.out.println("Must be a positive integer.");
                    System.out.print("\nMiles driven for next trip (-1 to exit): ");
                    if (input.hasNextInt()) {
                        currentMiles = input.nextInt();
                    }
                    continue; 
                }
            } else {
                System.err.println("Invalid input.");
                break; 
            }
            double currentMPG = (double) currentMiles / currentGallons;
            System.out.println("Trip " + (++tripCounter) + " MPG: " + df.format(currentMPG));
            totalMiles += currentMiles;
            totalGallons += currentGallons;
            double combinedMPG = (double) totalMiles / totalGallons;
            System.out.println("Combined MPG: " + df.format(combinedMPG));
            System.out.println("");
            System.out.print("\nMiles driven for next trip (-1 to exit): ");
            if (input.hasNextInt()) {
                currentMiles = input.nextInt();
            } else {
                System.err.println("Invalid input.");
                break;
            }
        } 

        if (totalGallons > 0) {
            double finalCombinedMPG = (double) totalMiles / totalGallons;
            System.out.println("");
            System.out.println("Total trips: " + tripCounter);
            System.out.println("Total Miles: " + totalMiles);
            System.out.println("Total Gallons: " + totalGallons);
            System.out.println("Total Combined MPG: " + df.format(finalCombinedMPG));
        } else {
            System.out.println("\nNothing was recorded");
        }
        input.close();
    }
}