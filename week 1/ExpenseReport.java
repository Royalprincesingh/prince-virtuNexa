import java.util.List;

public class ExpenseReport {
    public void generateReport(List<Expense> expenses) {
        // Logic to generate and print the report
        System.out.println("Expense Report:");
        for (Expense expense : expenses) {
            System.out.println(expense.getId() + ": " + expense.getAmount() + " - " + expense.getCategory() + " on " + expense.getDate());
        }
    }
}
