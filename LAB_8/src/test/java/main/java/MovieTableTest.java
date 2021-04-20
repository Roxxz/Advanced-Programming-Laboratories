package main.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class MovieTableTest {

    @Test
    @DisplayName("Simple FindMovieById test")
    void findMovieById() throws SQLException {
        MovieTable movieTable = new MovieTable(Main.getConnection());
        assertEquals(1, movieTable.findMovieById(13772), "it should print out Cinderella");
    }
}