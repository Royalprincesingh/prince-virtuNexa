public class FactorialCalculator {

    // Iterative method to calculate factorial
    public long factorialIterative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    // Recursive method to calculate factorial
    public long factorialRecursive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * factorialRecursive(number - 1);
    }
}
