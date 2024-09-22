package dbconnection;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionTest {

    @Test
    void postgresConnectionTest() {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to PostgreSQL successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void oracleConnectionTest() {
        String url = "jdbc:oracle:thin:@localhost:1521/oracle";
        String user = "system";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to Oracle successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
