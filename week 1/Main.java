import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            ExpenseManager manager = new ExpenseManager("jdbc:sqlite:expenses.db");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Add Expense");
                System.out.println("2. View Expenses");
                System.out.println("3. Generate Report");
                System.out.println("4. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter category: ");
                        String category = scanner.nextLine();
                        System.out.print("Enter date (YYYY-MM-DD): ");
                        String date = scanner.nextLine();
                        manager.addExpense(new Expense(0, amount, category, date));
                        break;
                    case 2:
                        List<Expense> expenses = manager.getAllExpenses();
                        for (Expense expense : expenses) {
                            System.out.println(expense.getId() + ": " + expense.getAmount() + " - " + expense.getCategory() + " on " + expense.getDate());
                        }
                        break;
                    case 3:
                        ExpenseReport report = new ExpenseReport();
                        report.generateReport(manager.getAllExpenses());
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
