package lab11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection conn = null;
    private static Database db = null;

    private Database() {
        try {

            String dbURL = "jdbc:oracle:thin:@localhost:1521:XE";
            String username = "roxana";
            String password = "roxana";

            conn = DriverManager.getConnection(dbURL, username, password);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Connection getConnection() {
        if (db == null) {
            db = new Database();
        }
        return conn;
    }
}
