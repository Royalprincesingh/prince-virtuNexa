import java.io.*;

public class Account {
    private final String filePath = "ATMData.txt";

    public double getBalance() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return Double.parseDouble(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            return 0.0;  // default if no data or corrupt file
        }
    }

    public void updateBalance(double newBalance) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.valueOf(newBalance));
        } catch (IOException e) {
            System.out.println("Error updating balance.");
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        double balance = getBalance();
        updateBalance(balance + amount);
        System.out.println("₹" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        double balance = getBalance();
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            updateBalance(balance - amount);
            System.out.println("₹" + amount + " withdrawn successfully.");
        }
    }
}
