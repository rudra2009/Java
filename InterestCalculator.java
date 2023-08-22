import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the principal amount (P): ");
        double principal = scanner.nextDouble();
        
        System.out.print("Enter the rate of interest (R): ");
        double rate = scanner.nextDouble();
        
        System.out.print("Enter the time period in years (T): ");
        double time = scanner.nextDouble();
        
        double simpleInterest = (principal * rate * time) / 100;
        double amount = principal * Math.pow((1 + rate / 100), time);
        double compoundInterest = amount - principal;
        
        System.out.println("Simple Interest (SI): " + simpleInterest);
        System.out.println("Compound Interest (CI): " + compoundInterest);
        
        double difference = compoundInterest - simpleInterest;
        System.out.println("Difference between CI and SI: " + difference);
        
        scanner.close();
    }
}
