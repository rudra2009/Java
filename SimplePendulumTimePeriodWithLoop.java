import java.util.Scanner;

public class SimplePendulumTimePeriodWithLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of gravity values you want to calculate for: ");
        int numberOfValues = scanner.nextInt();

        double[] gravityValues = new double[numberOfValues];
        for (int i = 0; i < numberOfValues; i++) {
            System.out.print("Enter the value of acceleration due to gravity (g) for value " + (i + 1) + ": ");
            gravityValues[i] = scanner.nextDouble();
        }

        System.out.println("Calculating time periods:");

        for (int i = 0; i < numberOfValues; i++) {
            double g = gravityValues[i];

            // Calculate time period using the formula T = 2 * π * sqrt(1 / g)
            double timePeriod = 2 * Math.PI * Math.sqrt(1 / g);

            System.out.println("For gravity value " + g + ", the time period is: " + timePeriod + " seconds");
        }

        scanner.close();
    }
}
