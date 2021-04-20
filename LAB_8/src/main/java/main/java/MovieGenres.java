package main.java;

public class MovieGenres {
    private int movieId;
    private int genreId;

    MovieGenres(int movieId, int genreId){
        this.setMovieId(movieId);
        this.setGenreId(genreId);
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Override
    public String toString() {
        return "MovieGenres{" +
                "movieId=" + movieId +
                ", genreId=" + genreId +
                '}';
    }
}
