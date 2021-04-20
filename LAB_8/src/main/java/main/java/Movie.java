package main.java;

public class Movie {
    private int movieId;
    private String title;
    private int releaseDate;
    private int movieDuration;
    private int score;

    Movie(int movieId, String title, int releaseDate, int movieDuration, int score){
        this.movieId = movieId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.movieDuration = movieDuration;
        this.score = score;
    }


    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + movieId +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", movieDuration=" + movieDuration +
                ", score='" + score + '\'' +
                '}';
    }
}
