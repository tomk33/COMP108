import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dbAccess {

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void main(String[] args) throws IOException {
        String url = "jdbc:mysql://localhost:3306/cardDetails";
        String username = "root";
        String password = "Ulemestekeskus#3";

        System.out.println("Loading driver ...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }

        System.out.println("Connecting database ...");

        // Everything inside the try-with so 'connection' can be used
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter file path: ");
            String path = br.readLine();

            String data = readFileAsString(path);
            System.out.println(data);

            System.out.print("Write all to DB? (y/n): ");
            if (!br.readLine().equalsIgnoreCase("y")) return;

            String[] lines = data.split("\\r?\\n");
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO cards (name, card_number) VALUES (?, ?)");

            for (String line : lines) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length != 2) continue;
                String name = parts[0].trim();
                long number = Long.parseLong(parts[1].trim());
                pstmt.setString(1, name);
                pstmt.setLong(2, number);
                pstmt.executeUpdate();
                // Debugging
                System.out.println("Inserted: " + name);
            }

            pstmt.close();
            System.out.println("Done");
        } catch (SQLException e) {
            // Debugging
            e.printStackTrace();
        }
    }
}