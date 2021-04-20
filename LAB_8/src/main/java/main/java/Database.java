package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Database db=null;

    public static Connection conn=null;

    private Database() throws SQLException {
        try {

            String dbURL = "jdbc:oracle:thin:@localhost:1521/xe";
            String username = "roxana";
            String password = "roxana";

            conn = DriverManager.getConnection(dbURL, username, password);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Connection Database() throws SQLException {
        if(db==null)
        {
            db=new Database();
        }
        return conn;
    }
}