import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private Connection connection;

    public ExpenseManager(String dbUrl) throws SQLException {
        connection = DriverManager.getConnection(dbUrl);
        createTable();
    }

    private void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS expenses (id INTEGER PRIMARY KEY AUTOINCREMENT, amount REAL NOT NULL, category TEXT NOT NULL, date TEXT NOT NULL)";
        Statement stmt = connection.createStatement();
        stmt.execute(sql);
    }

    public void addExpense(Expense expense) throws SQLException {
        String sql = "INSERT INTO expenses (amount, category, date) VALUES (?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setDouble(1, expense.getAmount());
        pstmt.setString(2, expense.getCategory());
        pstmt.setString(3, expense.getDate());
        pstmt.executeUpdate();
    }

    public List<Expense> getAllExpenses() throws SQLException {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            expenses.add(new Expense(rs.getInt("id"), rs.getDouble("amount"), rs.getString("category"), rs.getString("date")));
        }
        return expenses;
    }

    // Implement editExpense, deleteExpense, and other methods...
}
