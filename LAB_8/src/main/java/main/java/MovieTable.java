package main.java;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

import javax.security.auth.login.Configuration;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MovieTable {

    Connection conn;

    public  MovieTable(Connection conn) throws SQLException
    {
        this.conn=conn;
    }

    public void createMovie(int id, String name, int releaseDate, int movieDuration, String score) throws SQLException
    {
        try {
            Statement myStatement = conn.createStatement();
            myStatement.executeUpdate(String.format("INSERT INTO MOVIE (movieid, title, releasedate, movieduration, score) VALUES (%d, '%s', %d, %d, '%s')", id, name, releaseDate, movieDuration, score));
    }catch(Exception e){
            System.out.println("Duplicate data - not inserted");
    }
    }

    public void findMovieByName(String name) throws SQLException
    {
        Statement myStatement = conn.createStatement();
        ResultSet myResult = myStatement.executeQuery(String.format("SELECT * FROM MOVIE WHERE title='%s'",name));
        while (myResult.next()) {
            System.out.println("Found:");
            System.out.println("Movie:" + myResult.getString("movieid") + " " +
                    myResult.getString("title") + " "+
                            myResult.getString("releasedate") + " " +
                            myResult.getString("movieduration") + " " +
                    myResult.getString("score"));

        }

    }

    public int findMovieById(int id) throws SQLException
    {
        Statement myStatement = conn.createStatement();
        ResultSet myResult = myStatement.executeQuery(String.format("SELECT * FROM MOVIE WHERE MOVIEID=%d",id));
        if (myResult.next()) {
            System.out.println("Found:");
            System.out.println("Movie:" + myResult.getString("movieid") + " " +
                    myResult.getString("title") + " "+
                    myResult.getString("releasedate") + " " +
                    myResult.getString("movieduration") + " " +
                    myResult.getString("score"));

            return 1;
        }

        return 0;
    }

}