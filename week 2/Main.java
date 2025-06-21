import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FactorialCalculator calculator = new FactorialCalculator();

        while (true) {
            System.out.print("Enter a non-negative integer to calculate its factorial (or -1 to exit): ");
            int number = scanner.nextInt();

            if (number == -1) {
                System.out.println("Exiting the program.");
                break;
            }

            // Input validation
            if (number < 0) {
                System.out.println("Invalid input. Please enter a non-negative integer.");
                continue;
            }

            // Calculate factorial using both methods
            long iterativeResult = calculator.factorialIterative(number);
            long recursiveResult = calculator.factorialRecursive(number);

            // Display results
            System.out.println("Factorial of " + number + " (Iterative): " + iterativeResult);
            System.out.println("Factorial of " + number + " (Recursive): " + recursiveResult);
        }

        scanner.close();
    }
}
