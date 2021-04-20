package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException{

        Connection conn = getConnection();

        MovieTable movie = new MovieTable(conn);
        movie.createMovie(65, "Jumanji", 2015, 120, "6");
        movie.findMovieByName("Jumanji");

        movie.createMovie(79, "IT", 2018, 140, "7");
        movie.findMovieById(79);

        GenreTable genre = new GenreTable(conn);
        genre.createGenre(35, "Action");
        genre.createGenre(98, "Horror");
        genre.findGenreById(98);

        Movie movie1 = new Movie(65,"Jumanji", 2015, 120, 6);
        Movie movie2 = new Movie(79, "IT", 2018, 140, 7);

        Genre genre1 = new Genre(35, "Action");
        Genre genre2 = new Genre(98, "Horror");

        System.out.println(movie1);
        System.out.println(movie2);
        System.out.println(genre1);
        System.out.println(genre2);

        MovieGenres movieGenre1 = new MovieGenres(65, 35);
        MovieGenres movieGenre2 = new MovieGenres(79, 98);

        System.out.println(movieGenre1);
        System.out.println(movieGenre2);

        MovieCast movieCast1 = new MovieCast(65, "Dwayne Johnson, Karen Gillan, Jack Black");
        MovieCast movieCast2 = new MovieCast(79, "Bill Skarsgård, Sophia Lillis, Finn Wolfhard");

        System.out.println(movieCast1);
        System.out.println(movieCast2);

        MovieDirectors movieDirector1 = new MovieDirectors(65, "Jake Kasdan");
        MovieDirectors movieDirector2 = new MovieDirectors(79, "Andrés Muschietti");

        System.out.println(movieDirector1);
        System.out.println(movieDirector2);

        String fileToParse = "C:\\PA\\movies.csv";
        BufferedReader fileReader = null;

        final String DELIMITER = ",";
        try
        {
            String line;
            fileReader = new BufferedReader(new FileReader(fileToParse));

            while ((line = fileReader.readLine()) != null)
            {
                String[] tokens = line.split(DELIMITER);
                int movieId =  Integer.parseInt(tokens[0]);
                String title = tokens[1];
                int releaseDate = Integer.parseInt(tokens[2]);
                int movieDuration = Integer.parseInt(tokens[3]);
                String score = tokens[4];
                MovieTable m = new MovieTable(conn);
                m.createMovie(movieId, title, releaseDate, movieDuration, score);

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                assert fileReader != null;
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        conn.close();
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = Database.Database();//conectarea la baza de date
        return conn;
    }
}