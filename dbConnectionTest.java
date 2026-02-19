import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnectionTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/cardDetails";
        String username = "root";
        String password = "Ulemestekeskus#3";

        System.out.println("Loading driver ...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Use com.mysql.jdbc.Driver if you're not on MySQL 8+ yet.
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }

        System.out.println("Connecting database ...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

    }
}
