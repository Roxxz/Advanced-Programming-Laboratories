package main.java;

public class MovieCast {
    private int movieId;
    private String movieActors;

    MovieCast(int movieId, String movieActors){
        this.setMovieId(movieId);
        this.setMovieActors(movieActors);
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieActors() {
        return movieActors;
    }

    public void setMovieActors(String movieActors) {
        this.movieActors = movieActors;
    }

    @Override
    public String toString() {
        return "MovieCast{" +
                "movieId=" + movieId +
                ", movieActors='" + movieActors + '\'' +
                '}';
    }
}
