package main.java;

public class MovieDirectors {
    private int movieId;
    private String movieDirectors;

    MovieDirectors(int movieId, String movieDirectors){
        this.setMovieId(movieId);
        this.setMovieActors(movieDirectors);
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieDirectors() {
        return movieDirectors;
    }

    public void setMovieActors(String movieDirectors) {
        this.movieDirectors = movieDirectors;
    }

    @Override
    public String toString() {
        return "MovieCast{" +
                "movieId=" + movieId +
                ", movieDirectors='" + movieDirectors + '\'' +
                '}';
    }
}
