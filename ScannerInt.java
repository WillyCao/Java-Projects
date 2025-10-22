import java.util.Scanner;

public class ScannerInt {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            
            int number = input.nextInt();

            if (number > 0) {
                positiveCount++;
            } 
            else if (number < 0) {
                negativeCount++;
            } 
            else {
                zeroCount++;
            }
        }

        System.out.println("Positive: " + positiveCount);
        System.out.println("Negative: " + negativeCount);
        System.out.println("Zeros: " + zeroCount);
        input.close();
    }
}