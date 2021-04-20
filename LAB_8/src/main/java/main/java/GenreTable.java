package main.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GenreTable {

    Connection conn;

    public  GenreTable(Connection conn) throws SQLException {
        this.conn=conn;
    }

    public void createGenre(int id,String name) throws SQLException
    {
        try {
             Statement myStatement = conn.createStatement();
             myStatement.executeUpdate(String.format("INSERT INTO GENRE (GENREID, GENRENAME) VALUES (%d, '%s')", id, name));
        }catch (Exception e){
            System.out.println("Duplicate data - not inserted");
}
    }

    public void findGenreByName(String name) throws SQLException
    {
        Statement myStatement = conn.createStatement();
        ResultSet myResult = myStatement.executeQuery(String.format("SELECT * FROM GENRE WHERE GENRENAME='%s'", name));
        while (myResult.next()) {
            System.out.println("Found:");
            System.out.println("Genre:" + myResult.getString("GENREID") + " "+
                    myResult.getString("GENRENAME"));

        }

    }

    public void findGenreById(int id) throws SQLException
    {
        Statement myStatement = conn.createStatement();
        ResultSet myResult = myStatement.executeQuery(String.format("SELECT * FROM GENRE WHERE GENREID=%d", id));
        while (myResult.next()) {
            System.out.println("Found:");
            System.out.println("Genre:" + myResult.getString("GENREID") + " "+
                    myResult.getString("GENRENAME"));

        }

    }
}