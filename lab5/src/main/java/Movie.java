public class Movie extends Item {
    private final String directorName;
    private final float rating;
    private final int movieLength;
    private final MovieGenre genre;

    public Movie(String name, String id, String location, MovieGenre genre, String directorName, float rating, int movieLength) {
        super(name, id, location);
        this.genre = genre;
        this.directorName = directorName;
        this.rating = rating;
        this.movieLength = movieLength;
        System.out.println("You added the " + genre + " movie: " + this.name + "\n");
    }

    @Override
    public String toString() {
        return "\nMovie{" +
                "name= " + name +
                ", location= " + location +
                ", director's name= " + directorName +
                ", rating= " + rating +
                ", length= " + movieLength +
                ", genre= " + genre +
                "}";
    }

}
