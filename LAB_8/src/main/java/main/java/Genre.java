package main.java;

public class Genre {
    private String genreName;
    private int genreId;

    Genre(int genreId, String genreName){
        this.setGenreId(genreId);
        this.setGenreName(genreName);
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreName='" + genreName + '\'' +
                ", genreId=" + genreId +
                '}';
    }
}
